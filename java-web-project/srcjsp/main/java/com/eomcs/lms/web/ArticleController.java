package com.eomcs.lms.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.eomcs.lms.domain.Article;
import com.eomcs.lms.domain.ArticleFile;
import com.eomcs.lms.service.ArticleService;
import com.eomcs.lms.util.MediaUtils;

@Controller
@RequestMapping("/article")
public class ArticleController {

  private static final Logger logger = LogManager.getLogger(ArticleService.class);

  @Autowired
  ArticleService articleService;

  @RequestMapping("form")
  public void form() {
  }

  @GetMapping
  public String list(Model model) {
    List<Article> articles = articleService.list();
    model.addAttribute("list", articles);
    return "article/list";
  }

  @GetMapping("{id}")
  public String detail(Model model, @PathVariable int id) {
    Article article = articleService.get(id);
    model.addAttribute("article", article);
    return "article/detail";
  }

  @RequestMapping(value="add", produces="text/plain;charset=UTF-8")
  public String add(@RequestBody Map<String,Object> contentMap) {
    String articleContent = (String) contentMap.get("content");
    String subject = (String) contentMap.get("subject");
    @SuppressWarnings("unchecked")
    ArrayList<Object> addNo = (ArrayList<Object>) contentMap.get("noArr");

    try {
      articleService.add(subject, articleContent, addNo);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "redirect:./";
  }
  
  @GetMapping("/image/{fileId}")
  @ResponseBody
  public ResponseEntity<?> serveFile(@PathVariable int fileId) {
    try {
      ArticleFile articleFile = articleService.viewFile(fileId);
      HttpHeaders headers = new HttpHeaders();
      logger.info("저장한 파일이름   " + articleFile.getSaveFileName());
      String saveFileName = articleFile.getSaveFileName();
      articleService.preparePath(articleFile.getFileName());
      Resource resource = articleService.loadAsResource(saveFileName);
      String fileName = articleFile.getFileName();
      logger.info("FileName ==> " + fileName);
      headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");

      if (MediaUtils.containsImageMediaType(articleFile.getContentType())) {
        headers.setContentType(MediaType.valueOf(articleFile.getContentType()));
      } else {
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
      }
      logger.info(resource);
      return ResponseEntity.ok().headers(headers).body(resource);

    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

}
