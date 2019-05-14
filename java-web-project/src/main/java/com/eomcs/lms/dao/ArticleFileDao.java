package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.UploadFile;

public interface ArticleFileDao {
  public List<UploadFile> findAll();
  public UploadFile findOne(int fileId);
  public UploadFile findOneByFileName(String fileName);
  public void copyFile(int count);
  public UploadFile findOneBySaveFilePath(String saveFilePath);
}
