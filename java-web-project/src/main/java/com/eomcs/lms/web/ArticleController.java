package com.eomcs.lms.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.lms.domain.Article;
import com.eomcs.lms.domain.UploadFile;
import com.eomcs.lms.service.ArticleService;
import com.eomcs.lms.service.ImageService;
import com.eomcs.lms.util.MediaUtils;

@Controller
@RequestMapping("/article")
public class ArticleController {

  @Autowired
  ArticleService articleService;
  
  @Autowired
  ImageService imageService;
  
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
  
  @RequestMapping("add")
  public String add(Article article) {
//    article.setRegDate(new java.sql.Date(new Date().getTime()));
    articleService.add(article);
    
    return "redirect:.";
  }
  
  @PostMapping("/image")
  @ResponseBody
  public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
      try {
          imageService.preparePath(file.getOriginalFilename());
          UploadFile uploadedFile = imageService.store(file);
          return ResponseEntity.ok().body("../../upload/uploadFile/" + uploadedFile.getId());
      } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.badRequest().build();
      }
  }
  
  @GetMapping("/")
  public String listUploadedFiles(Model model) throws IOException {
      
      model.addAttribute("files", imageService.loadAll().collect(Collectors.toList()));
      
      return "index";
  }
  
  @GetMapping("/image/{fileId}")
  @ResponseBody
  public ResponseEntity<?> serveFile(@PathVariable int fileId) {
      try {
          UploadFile uploadedFile = imageService.load(fileId);
          HttpHeaders headers = new HttpHeaders();
          
          Resource resource = imageService.loadAsResource(uploadedFile.getSaveFileName());
          String fileName = uploadedFile.getFileName();
          headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");

          if (MediaUtils.containsImageMediaType(uploadedFile.getContentType())) {
              headers.setContentType(MediaType.valueOf(uploadedFile.getContentType()));
          } else {
              headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
          }
          
          return ResponseEntity.ok().headers(headers).body(resource);
          
      } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.badRequest().build();
      }
  }

  
}
