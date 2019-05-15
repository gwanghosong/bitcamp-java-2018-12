package com.eomcs.lms.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import javax.servlet.ServletContext;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.eomcs.lms.dao.ArticleDao;
import com.eomcs.lms.dao.ArticleFileDao;
import com.eomcs.lms.dao.ImageDao;
import com.eomcs.lms.domain.Article;
import com.eomcs.lms.domain.ArticleFile;
import com.eomcs.lms.domain.UploadFile;
import com.eomcs.lms.service.ArticleService;
import com.eomcs.lms.util.UploadFileUtils;

@Service
public class ArticleServiceImpl implements ArticleService {

  private static final Logger logger = LogManager.getLogger(ArticleServiceImpl.class);
  
  ArticleDao articleDao;
  ArticleFileDao articleFileDao;
  ImageDao imageDao;
  
  @Autowired ServletContext servletContext;
  private Path rootLocation;
  private String uploadDir;
  
  public ArticleServiceImpl(ArticleDao articleDao, ArticleFileDao articleFileDao, ImageDao imageDao) {
    this.articleDao = articleDao;
    this.articleFileDao = articleFileDao;
    this.imageDao = imageDao;
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
  public int add(String subject, String content, ArrayList<Object> addNo) {
    Article article = new Article();
    article.setSubject(subject);
    article.setContent(content);
    articleDao.insert(article);
    int count = article.getId();
    UploadFile uploadFile = new UploadFile();
    ArticleFile articleFile = new ArticleFile();
    for (int i = 0; i < addNo.size(); i++) {
      int no = Integer.parseInt((String) addNo.get(i));
      uploadFile = imageDao.findOne(no);
      articleFile.setArticleId(count);
      articleFile.setFileName(uploadFile.getFileName());
      articleFile.setSaveFileName(uploadFile.getSaveFileName());
      String filePath = uploadFile.getFilePath();
      String changeFilePath = 
          filePath.replaceAll("/java-web-project/upload/uploadFile/", "/java-web-project/upload/articleFile/");
      articleFile.setFilePath(changeFilePath);
      articleFile.setContentType(uploadFile.getContentType());
      articleFile.setSize(uploadFile.getSize());
        try {
         store(prepareMultipartFile(changeFilePath));
        } catch (Exception e) {
          e.printStackTrace();
        }
      articleFileDao.insert(articleFile);
      
    }
    return count;
  }
  
  
  public void preparePath(String uploadPath) {
    this.uploadDir = servletContext.getRealPath("/upload/articleFile");
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
  
  public HashMap<String,Object> store(MultipartFile file) throws Exception {
    try {
        if (file.isEmpty()) {
            throw new Exception("Failed to store empty file " + file.getOriginalFilename());
        }
        
        String saveFileName = UploadFileUtils.fileSave(uploadDir, file);
        
        if (saveFileName.toCharArray()[0] == '/') {
            saveFileName = saveFileName.substring(1);
        }
        
        Resource resource = loadAsResource(saveFileName);
        
        HashMap<String,Object> value = new HashMap<>();
        value.put("saveFileName", saveFileName);
        value.put("originalFilename", file.getOriginalFilename());
        value.put("contentType", file.getContentType());
        value.put("filePath", uploadDir + File.separator + saveFileName);
        value.put("size", resource.contentLength());
        
        return value;
    } catch (IOException e) {
        throw new Exception("Failed to store file " + file.getOriginalFilename(), e);
    }
}
  
  public MultipartFile prepareMultipartFile(String path) throws Exception {
    File file = new File("/home/bitcamp/eclipse-workspace2/.metadata/.plugins/org.eclipse.wst.server.core/tmp3/wtpwebapps/java-web-project/upload/uploadFile/2019/05/15/7be7bf2bd9994241a06629d1596cb461.png");
    FileItem fileItem = new DiskFileItem(
        "mainFile", 
        Files.probeContentType(file.toPath()), 
        false, 
        file.getName(), 
        (int) file.length(), 
        file.getParentFile());

    try {
        InputStream input = new FileInputStream(file);
        OutputStream os = fileItem.getOutputStream();
        IOUtils.copy(input, os);
        // Or faster..
        // IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
    } catch (IOException ex) {
        // do something.
    }

    MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
    
    return multipartFile;
  }
}
