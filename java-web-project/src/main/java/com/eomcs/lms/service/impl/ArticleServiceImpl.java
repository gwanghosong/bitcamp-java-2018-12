package com.eomcs.lms.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.ArticleDao;
import com.eomcs.lms.dao.ArticleFileDao;
import com.eomcs.lms.dao.ImageDao;
import com.eomcs.lms.domain.Article;
import com.eomcs.lms.domain.ArticleFile;
import com.eomcs.lms.domain.UploadFile;
import com.eomcs.lms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

  private static final Logger logger = LogManager.getLogger(ArticleServiceImpl.class);
  
  ArticleDao articleDao;
  ArticleFileDao articleFileDao;
  ImageDao imageDao;
  
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
          filePath.replaceAll("temporary", "article");
      articleFile.setFilePath(changeFilePath);
      articleFile.setContentType(uploadFile.getContentType());
      articleFile.setSize(uploadFile.getSize());
      
      String saveFathName = uploadFile.getSaveFileName();
      String sfn = saveFathName.substring(0, saveFathName.lastIndexOf("/"));
      String year = sfn.split("/")[0];
      String month = sfn.split("/")[1];
      String date = sfn.split("/")[2];
      String oldPath = changeFilePath.substring(0, changeFilePath.lastIndexOf("\\") + 1);
      System.out.println(servletContext.getAttribute("contextRootPath"));
      String copyPath = 
          servletContext.getRealPath("./")
          + "upload\\article"
          + "\\" + year 
          + "\\" + month 
          + "\\" + date 
          + "\\" + changeFilePath.substring(changeFilePath.lastIndexOf("/") + 1);
      logger.info("oldPath ==>" + oldPath); 
      logger.info("copyPath ==>" + copyPath);
      if (moveFile(filePath, copyPath))
        articleFileDao.insert(articleFile);
    }
    return count;
  }
  
  
//파일을 해당위치로 복사하고 지운다.
public boolean moveFile(String source, String dest) {
   boolean result = false;
   
   // 새롭게 저장할 위치에 폴더생성
   try {
     new File(dest).getParentFile().mkdirs();
   } catch (Exception e) {
     e.printStackTrace();
   }
       
   // 스트림 선언
   FileInputStream inputStream = null;
   FileOutputStream outputStream = null;
       
   try {
     // 스트림 생성
       inputStream = new FileInputStream(source);
       outputStream = new FileOutputStream(dest);
   } catch (FileNotFoundException e) {
       e.printStackTrace();
       result = false;
   }

   // 채널 선언, 채널 생성
   FileChannel fcin = inputStream.getChannel();
   FileChannel fcout = outputStream.getChannel();
       
   // 채널을 통한 스트림 전송
   long size = 0;
   try {
       size = fcin.size();
       fcin.transferTo(0, size, fcout);
           
       fcout.close();
       fcin.close();
       outputStream.close();
       inputStream.close();
           
       result = true;
   } catch (IOException e) {
       e.printStackTrace();
       result = false;
   }
       
   // 원본파일 삭제
   File f = new File(source);
   if (f.delete()) {
       result = true;
   }
   return result;
}
}
