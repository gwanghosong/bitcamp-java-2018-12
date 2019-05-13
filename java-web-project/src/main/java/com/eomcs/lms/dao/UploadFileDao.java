package com.eomcs.lms.dao;

import com.eomcs.lms.domain.UploadFile;

public interface UploadFileDao {
  public UploadFile findOneByFileName(String fileName);
}
