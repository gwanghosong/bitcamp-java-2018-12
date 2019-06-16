package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.UploadFile;

public interface ImageDao {
  public List<UploadFile> findAll();
  public UploadFile findOne(int fileId);
  public UploadFile findOneByFileName(String fileName);
  public int save(UploadFile uploadFile);
  public UploadFile findOneBySaveFilePath(String saveFilePath);
}
