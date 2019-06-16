package com.eomcs.lms.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.Resource;
import com.eomcs.lms.domain.Article;
import com.eomcs.lms.domain.ArticleFile;

public interface ArticleService {
  public List<Article> list();
  public Article get(int id);
  public void add(String subject, String content, ArrayList<Object> addNo) throws Exception;
  public ArticleFile viewFile(int fileId);
  public Resource loadAsResource(String fileName) throws Exception;
  public void preparePath(String uploadPath);
}
