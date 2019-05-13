package com.eomcs.lms.service;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.lms.domain.UploadFile;

public interface ImageService {
  public UploadFile store(MultipartFile file) throws Exception;
  public void preparePath(String uploadPath);
  public Stream<Integer> loadAll();
  public UploadFile load(int fileId);
  public Resource loadAsResource(String fileName) throws Exception;
  public Path loadPath(String fileName);
}
