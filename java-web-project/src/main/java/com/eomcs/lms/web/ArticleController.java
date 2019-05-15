package com.eomcs.lms.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.domain.Article;
import com.eomcs.lms.service.ArticleService;
import com.eomcs.lms.service.ImageService;

@Controller
@RequestMapping("/article")
public class ArticleController {
  
  private static final Logger logger = LogManager.getLogger(ImageService.class);

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
  
  @RequestMapping(value="add", produces="text/plain;charset=UTF-8")
  public String add(@RequestBody Map<String,Object> contentMap) {
    String articleContent = (String) contentMap.get("content");
    String changeStr = 
        articleContent.replaceAll("../../../java-web-project/app/image/", "../../../java-web-project/app/article/image/");
    String subject = (String) contentMap.get("subject");
    @SuppressWarnings("unchecked")
    ArrayList<Object> addNo = (ArrayList<Object>) contentMap.get("noArr");
    try {
      articleService.add(subject, changeStr, addNo);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "redirect:.";
  }
}
