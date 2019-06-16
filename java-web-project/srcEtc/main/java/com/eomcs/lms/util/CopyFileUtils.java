package com.eomcs.lms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Calendar;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CopyFileUtils {
  
  private static final Logger logger = LogManager.getLogger(CopyFileUtils.class);

  //파일을 해당위치로 복사하고 지운다.
  public static boolean moveFile(String source, String dest) {
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

    return deleteFile(source, result);
  }

  // 임시파일 저장경로(originDir)를 새로운 저장경로(changeDir)로 변경
  public static String getSavePath(
      String source, 
      String originDir, 
      String changeDir, 
      String subPath) {

    String savePath = 
        source.substring(0, source.lastIndexOf(File.separator) + 1);
    
    // 시스템에 win이 포함되어 있는 windows 운영체제인지 확인
    if (System.getProperty("os.name").indexOf("Win") >= 0) {
      logger.info("Windows입니다!");
      savePath = UploadFileUtils.changeWindowPath(savePath);
    } 
    
    String saveOsPath = 
        savePath.replaceAll(originDir, changeDir) + 
        subPath.substring(
            subPath.lastIndexOf(File.separator) + 1, subPath.length());
    logger.info("saveOsPath!! ==> " + saveOsPath);
    return saveOsPath;
  }

  // 저장할 물리경로 구하기
  public static String getPhysicalPath(
      String contextRootPath, 
      String subPathName, 
      String absolutePath,
      String parentDirName) {
    
    // 시스템에 win이 포함되어 있는 windows 운영체제인지 확인
    if (System.getProperty("os.name").indexOf("Win") >= 0) {
      logger.info("Windows입니다!");
      subPathName = UploadFileUtils.reverseSlashPath(subPathName);
      absolutePath = UploadFileUtils.reverseSlashPath(absolutePath);
    }

    String spn = subPathName.substring(0, subPathName.lastIndexOf("/"));
    String year = spn.split("/")[0];
    String month = spn.split("/")[1];
    String date = spn.split("/")[2];
    String copyPath = 
        contextRootPath
        + "upload" + File.separator + parentDirName
        + File.separator + year 
        + File.separator  + month 
        + File.separator  + date 
        + File.separator  + absolutePath.substring(absolutePath.lastIndexOf("/") + 1);
    logger.info("copyPath ==> " + copyPath);
    return copyPath;
  }

  // 원본파일 삭제
  public static boolean deleteFile(String source, boolean result) {
    
    File f = new File(source);
    if (f.delete()) {
      result = true;
    }
    return result;
  }
  
  // 일정시간이 지난 임시저장파일 및 임시저장폴더 삭제
  public static void deleteTemporaryFile(String parentDirPath) {
    
    // Calendar 객체 생성
    Calendar cal = Calendar.getInstance() ;
    long todayMil = cal.getTimeInMillis() ;     // 현재 시간(밀리 세컨드)
    long oneDayMil = 24*60*60*1000 ;            // 일 단위
     
    Calendar fileCal = Calendar.getInstance() ;
    Date fileDate = null ;
     
    File path = new File(parentDirPath) ;
    File[] list = path.listFiles() ;            // 파일 리스트 가져오기
     
    for(File file : list){
                         
        // 파일의 마지막 수정시간 가져오기
        fileDate = new Date(file.lastModified()) ;
         
        // 현재시간과 파일 수정시간 시간차 계산(단위 : 밀리 세컨드)
        fileCal.setTime(fileDate);
        long diffMil = todayMil - fileCal.getTimeInMillis() ;
         
        //날짜로 계산
        int diffDay = (int)(diffMil/oneDayMil) ;
     
        // 1일이 지난 임시 파일 삭제
        if (file.isFile()) {
          if(diffDay > 1 && file.exists()){
            file.delete();
            logger.info(file.getName() + " 파일을 삭제했습니다.");
          }
        } else {
        // 2일이 지난 임시 폴더 삭제
        if (file.isDirectory()) {
          if (diffDay > 2 && file.exists()) {
            delete(file);
            logger.info(file.getName() + "폴더를 삭제했습니다.");
           }
         }
       }
    }
  }
  
  // 디렉토리를 삭제할 경우 그 디렉토리 하위에 있는 파일들과 디렉토리들을 먼저 삭제하고, 
  // 해당 디렉토리를 삭제한다.
  static void delete(File dir) {
    // 파일의 하위 디렉토리와 파일 목록을 얻는다. pseudo code
    File[] files = dir.listFiles();

    for (File file : files) {
      if (file.isFile()) {
        file.delete();
      } else {
        delete(file);
      }
    }
    
    dir.delete();
  }
}
