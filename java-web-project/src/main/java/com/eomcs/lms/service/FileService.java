package com.eomcs.lms.service;

import com.eomcs.lms.domain.UploadFile;

public interface FileService {
  public UploadFile findOneByFileName(String fileName);
}
