package com.eomcs.lms.service;

import java.util.List;
import com.eomcs.lms.domain.Article;

public interface ArticleService {
  List<Article> list();
  Article get(int id);
  int add(Article article);
  
}
