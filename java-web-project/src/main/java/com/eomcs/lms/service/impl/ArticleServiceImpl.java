package com.eomcs.lms.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.ArticleDao;
import com.eomcs.lms.domain.Article;
import com.eomcs.lms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

  ArticleDao articleDao;
  
  public ArticleServiceImpl(ArticleDao articleDao) {
    this.articleDao = articleDao;
  }
  
  @Override
  public Article get(int id) {
    
    return articleDao.findByNo(id);
  }

  @Override
  public List<Article> list() {
    List<Article> articles =  articleDao.findAll();
    return articles;
  }

  @Override
  public int add(Article article) {
    return articleDao.insert(article);
  }

}
