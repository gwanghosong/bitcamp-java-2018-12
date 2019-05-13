package com.eomcs.lms.web;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.domain.Article;
import com.eomcs.lms.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

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
  
  @RequestMapping("add")
  public String add(Article article) {
//    article.setRegDate(new java.sql.Date(new Date().getTime()));
    articleService.add(article);
    
    return "redirect:.";
  }
  
}
