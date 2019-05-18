package com.eomcs.lms.service.impl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.ArticleDao;
import com.eomcs.lms.dao.ArticleFileDao;
import com.eomcs.lms.dao.ImageDao;
import com.eomcs.lms.domain.Article;
import com.eomcs.lms.domain.ArticleFile;
import com.eomcs.lms.domain.UploadFile;
import com.eomcs.lms.service.ArticleService;
import com.eomcs.lms.util.CopyFileUtils;
import com.eomcs.lms.util.UploadFileUtils;

@Service
public class ArticleServiceImpl implements ArticleService {

  private static final Logger logger = LogManager.getLogger(ArticleServiceImpl.class);

  ArticleDao articleDao;
  ArticleFileDao articleFileDao;
  ImageDao imageDao;
  private Path rootLocation;
  private String uploadDir;

  @Autowired ServletContext servletContext;

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
  public void add(String subject, String content, ArrayList<Object> addNo) {

    Article article = new Article();
    article.setSubject(subject);
    article.setContent(content);
    articleDao.insert(article);

    int count = article.getId();
    UploadFile uploadFile = new UploadFile();
    ArticleFile articleFile = new ArticleFile();
    String changeStr = content;

    for (int i = 0; i < addNo.size(); i++) {
      int no = Integer.parseInt((String) addNo.get(i));
      uploadFile = imageDao.findOne(no);

      articleFile.setArticleId(count);
      articleFile.setFileName(uploadFile.getFileName());
      articleFile.setSaveFileName(uploadFile.getSaveFileName());
      articleFile.setContentType(uploadFile.getContentType());
      articleFile.setSize(uploadFile.getSize());

      String savePathName = uploadFile.getSaveFileName();
      String tempDirName = "temporary";
      String saveDirName = "article";
      String tempFilePath = uploadFile.getFilePath();
      String changeFilePath = 
          CopyFileUtils.getSavePath(tempFilePath, tempDirName, saveDirName, savePathName);
      logger.info("changeFilePath ==>" + changeFilePath);

      articleFile.setFilePath(changeFilePath);

      String contextRootPath = servletContext.getRealPath("./");
      String copyPath = 
          CopyFileUtils.getPhysicalPath(
              contextRootPath, 
              savePathName, 
              changeFilePath, 
              saveDirName);

      String temporaryDirPath = 
          tempFilePath.substring(0, tempFilePath.length() - savePathName.length());
      logger.info("temporaryDirPath ==>" + temporaryDirPath);
      if (CopyFileUtils.moveFile(tempFilePath, copyPath)) {
        articleFileDao.insert(articleFile);
        CopyFileUtils.deleteTemporaryFile(temporaryDirPath);

        String oldStr = 
            ".." + File.separator + 
            ".." + File.separator + 
            ".." + File.separator + 
            "java-web-project" + File.separator + 
            "app" + File.separator + 
            "image" + File.separator + 
            uploadFile.getId();
        String newStr =
            ".." + File.separator + 
            ".." + File.separator +
            ".." + File.separator + 
            "java-web-project" + File.separator + 
            "app" + File.separator + 
            "article" + File.separator + 
            "image" + File.separator + 
            articleFile.getId();
        
        logger.info("content before ==> " + content);
        logger.info("oldStr before ==> " + oldStr);
        logger.info("newStr before ==> " + newStr);
        
        // 시스템에 win이 포함되어 있는 windows 운영체제인지 확인
        if (System.getProperty("os.name").indexOf("Win") >= 0) {
          logger.info("Windows입니다!");
          oldStr = UploadFileUtils.reverseSlashPath(oldStr);
          newStr = UploadFileUtils.reverseSlashPath(newStr);
        }
        
        logger.info("content after ==> " + content);
        logger.info("oldStr after ==> " + oldStr);
        logger.info("newStr after ==> " + newStr);

        changeStr = changeStr.replaceAll(oldStr, newStr);

        logger.info("oldStr ===> " + oldStr);
        logger.info("newStr ===> " + newStr);
        logger.info("changeStr ===> " + changeStr);

      }
    }
    article.setContent(changeStr);
    articleDao.updateContent(article);
  }

  public ArticleFile viewFile(int fileId) {
    return articleFileDao.findOne(fileId);
  }
  
  public Resource loadAsResource(String fileName) throws Exception {
    try {
        if (fileName.toCharArray()[0] == '/') {
            fileName = fileName.substring(1);
        }
        
        Path file = loadPath(fileName); 
        Resource resource = new UrlResource(file.toUri());
        logger.info("Resource ==> " + resource);
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
  
  public void preparePath(String uploadPath) {
    String uploadRelativePath = File.separator + "upload" + File.separator + "article";
    this.uploadDir = servletContext.getRealPath(uploadRelativePath);
    logger.info("PATH :: " + uploadPath);
    logger.info("저장할경로 : " + uploadDir);
    this.rootLocation = Paths.get(this.uploadDir);
    logger.info(this.rootLocation);
  }
}
