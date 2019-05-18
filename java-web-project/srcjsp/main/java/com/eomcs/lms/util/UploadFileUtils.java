package com.eomcs.lms.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;
import java.util.regex.Matcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.lms.service.impl.ArticleServiceImpl;

public class UploadFileUtils {
  
  private static final Logger logger = LogManager.getLogger(ArticleServiceImpl.class);
  
  /**
   * @param filePath
   * @param multipartFile
   * @return 생성된 파일 명(유일한 값)
   * @throws IllegalStateException
   * @throws IOException
   */
  public static String fileSave(String uploadPath, MultipartFile file) throws IllegalStateException, IOException {
      
      // 파일경로명으로 파일 객체 생성
      File uploadPathDir = new File(uploadPath);
      
      // 파일경로가 없다면 없는 경로마다 폴더생성
      if ( !uploadPathDir.exists() ){
          uploadPathDir.mkdirs();
      }
      
      // 파일 중복명 처리
      String genId = UUID.randomUUID().toString();
      genId = genId.replace("-", "");
      
      // 파일명 꺼내기
      String originalfileName = file.getOriginalFilename(); // green.jpg
      
      // 확장자명 꺼내기
      String fileExtension = getExtension(originalfileName); // jpg
      
      // UUID + 확장자명으로 파일명 생성
      String saveFileName = genId + "." + fileExtension;
      
      // 저장경로 하위에 .../년/월/일 디렉토리 생성
      String savePath = calcPath(uploadPath);
      
      // /년/월/일 를 포함하여 경로를 설정하고 UUID로 설정한 파일명으로 빈 파일객체 생성
      File target = new File(uploadPath + savePath, saveFileName);
      
      // 파일 내용 복사
      FileCopyUtils.copy(file.getBytes(), target);
      
      // /년/월/일/UUID파일명 Unix 저장경로지정
      String UnixPath = makeFilePath(uploadPath, savePath, saveFileName);
      
      // 시스템에 win이 포함되어 있는 windows 운영체제인지 확인
      if (System.getProperty("os.name").indexOf("Win") >= 0) {
        logger.info("Windows입니다!");
        return changeWindowPath(UnixPath);
      } else {
        logger.info("Unix입니다!");
        return UnixPath;
      }
  }
  
  public static String fileCopy(
      String uploadPath, MultipartFile file) throws IllegalStateException, IOException {
    
    // 파일경로명으로 파일 객체 생성
    File uploadPathDir = new File(uploadPath);
    
    // 파일경로가 없다면 없는 경로마다 폴더생성
    if ( !uploadPathDir.exists() ){
        uploadPathDir.mkdirs();
    }
    
    // 파일명 꺼내기
    String originalfileName = file.getOriginalFilename();
    
    // 저장경로 하위에 .../년/월/일/ 디렉토리 생성
    String savePath = calcPath(uploadPath);
    
    // /년/월/일 디렉토리경로를 포함하여 경로를 설정하고 파일명으로 파일객체 생성
    File target = new File(uploadPath + savePath, originalfileName);
    
    // 파일복사
    FileCopyUtils.copy(file.getBytes(), target);
    
    // /년/월/일/파일명 경로 리턴
    String UnixPath = makeFilePath(uploadPath, savePath, originalfileName);
    
    // 시스템에 win이 포함되어 있는 windows 운영체제인지 확인
    if (System.getProperty("os.name").indexOf("Win") >= 0) {
      logger.info("Windows입니다!");
      return changeWindowPath(UnixPath);
    } else {
      logger.info("Unix입니다!");
      return UnixPath;
    }
}
  
  /**
   * 파일이름으로부터 확장자를 반환
   * 
   * @param fileName
   *            확장자를 포함한 파일 명
   * @return 파일 이름에서 뒤의 확장자 이름만을 반환
   */
  public static String getExtension(String fileName) {
    
      int dotPosition = fileName.lastIndexOf('.');
      
      if (-1 != dotPosition && fileName.length() - 1 > dotPosition) {
          return fileName.substring(dotPosition + 1);
      } else {
          return "";
      }
  }
  
  private static String calcPath(String uploadPath) {
      
      Calendar cal = Calendar.getInstance();
      
      String yearPath = File.separator + cal.get(Calendar.YEAR);
      String monthPath = 
          yearPath + 
          File.separator + 
          new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
      String datePath = 
          monthPath + 
          File.separator + 
          new DecimalFormat("00").format(cal.get(Calendar.DATE));
      
      makeDir(uploadPath, yearPath, monthPath, datePath);
      
      return datePath;
  }
  
  private static void makeDir(String uploadPath, String... paths) {
      
      logger.info(
          paths[paths.length - 1] + 
          " : " + 
          new File(paths[paths.length - 1]).exists()); // ex) \2019\05\16
      
      if (new File(paths[paths.length - 1]).exists()) {
          return;
      }
      
      for (String path : paths) {
          File dirPath = new File(uploadPath + path);
          
          if (!dirPath.exists()) {
              dirPath.mkdir();
          }
      }
  }
  
  // 유닉스 운영체제 파일 저장 경로
  private static String makeFilePath(
      String uploadPath, String path, String fileName) throws IOException {
    
      String filePath = uploadPath + path + File.separator + fileName;
      
      return filePath.substring(uploadPath.length()).replace(File.separatorChar, '/');
  }
  
  // 윈도우 운영체제 파일 저장 경로
  public static String changeWindowPath(String testPath) {
    String OsFilePath = testPath.replaceAll(
        "/", Matcher.quoteReplacement(File.separator));
    logger.info("WindowOsPath ===> " + OsFilePath);
    return OsFilePath;

  }
  
  // 윈도우 경로 역으로 다시 변환
  public static String reverseSlashPath(String testPath) {
    String reverseSlashPath = 
        testPath.replaceAll(Matcher.quoteReplacement(File.separator), "/");
    logger.info("reverseSlashPath ===> " + reverseSlashPath);
    return reverseSlashPath;
  }

}
