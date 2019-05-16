package com.eomcs.lms.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import javax.servlet.ServletContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.lms.dao.ImageDao;
import com.eomcs.lms.domain.UploadFile;
import com.eomcs.lms.service.ImageService;
import com.eomcs.lms.util.UploadFileUtils;

@Service
public class ImageServiceImpl implements ImageService {
  
  private static final Logger logger = LogManager.getLogger(ImageServiceImpl.class);
  
  @Autowired ServletContext servletContext;
  private Path rootLocation;
  private String uploadDir;
  
  @Autowired ImageDao imageDao;
  
  public ImageServiceImpl(ImageDao imageDao) {
    this.imageDao = imageDao;
  }
  
  public void preparePath(String uploadPath) {
    String uploadRelativePath = File.separator + "upload" + File.separator + "temporary";
    this.uploadDir = servletContext.getRealPath(uploadRelativePath);
    logger.info("PATH :: " + uploadPath);
    logger.info("저장할경로 : " + uploadDir);
    this.rootLocation = Paths.get(this.uploadDir);
    logger.info(this.rootLocation);
  }
  
  public Stream<Integer> loadAll() {
      List<UploadFile> files = imageDao.findAll();
      return files.stream().map(file -> file.getId());
  }
  
  public UploadFile load(int fileId) {
      return imageDao.findOne(fileId);
  }
  
  public Resource loadAsResource(String fileName) throws Exception {
      try {
          if (fileName.toCharArray()[0] == '/') {
              fileName = fileName.substring(1);
          }
          
          Path file = loadPath(fileName);
          Resource resource = new UrlResource(file.toUri());
          logger.info(resource);
          if (resource.exists() || resource.isReadable()) {
              return resource;
          } else {
              throw new Exception("Could not read file: " + fileName);
          }
      } catch (Exception e) {
          throw new Exception("Could not read file: " + fileName);
      }
  }
  
  public Path loadPath(String fileName) {
      return rootLocation.resolve(fileName);
  }
  
  public UploadFile store(MultipartFile file) throws Exception {
    try {
        if (file.isEmpty()) {
            throw new Exception("Failed to store empty file " + file.getOriginalFilename());
        }
        
        String saveFileName = UploadFileUtils.fileSave(uploadDir, file);
        
        if (saveFileName.toCharArray()[0] == '/') {
            saveFileName = saveFileName.substring(1);
        }
        
        Resource resource = loadAsResource(saveFileName);
        
        UploadFile saveFile = new UploadFile();
        saveFile.setSaveFileName(saveFileName);
        saveFile.setFileName(file.getOriginalFilename());
        saveFile.setContentType(file.getContentType());
        saveFile.setFilePath(uploadDir + File.separator + saveFileName);
        saveFile.setSize(resource.contentLength());
        saveFile.setRegDate(new java.sql.Date(new Date().getTime()));
        imageDao.save(saveFile);
        saveFile = imageDao.findOne(saveFile.getId());
        
        return saveFile;
    } catch (IOException e) {
        throw new Exception("Failed to store file " + file.getOriginalFilename(), e);
    }
}


}
