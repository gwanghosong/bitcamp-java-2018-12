package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.ArticleFile;

public interface ArticleFileDao {
  public List<ArticleFile> findAll();
  public ArticleFile findOne(int fileId);
  public ArticleFile findOneByFileName(String fileName);
  public int insert(ArticleFile articleFile);
  public ArticleFile findOneBySaveFilePath(String saveFilePath);
}
