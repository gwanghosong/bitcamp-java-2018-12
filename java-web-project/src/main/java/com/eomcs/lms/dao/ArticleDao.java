package com.eomcs.lms.dao;

import java.util.List;
import java.util.Map;
import com.eomcs.lms.domain.Article;

public interface ArticleDao {
  //int insert(Map<String,Object> params);
  int insert(Article article);
  Article findByNo(int id);
  List<Article> findAll();
  
}
