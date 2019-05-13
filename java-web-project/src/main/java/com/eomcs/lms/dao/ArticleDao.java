package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Article;

public interface ArticleDao {
  int insert(Article article);
  Article findByNo(int id);
  List<Article> findAll();
  
}
