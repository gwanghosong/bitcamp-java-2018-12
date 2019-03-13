package com.eomcs.lms.handler;
import java.util.ArrayList;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.mybatis.TransactionManager;

public class PhotoBoardAddCommand extends AbstractCommand {
  
  TransactionManager txManager;
  PhotoBoardDao photoBoardDao; // 서버의 PhotoBoardDaoImpl 객체를 대행하는 프록시 객체이다.
  PhotoFileDao photoFileDao;

  public PhotoBoardAddCommand(
      PhotoBoardDao photoBoardDao, 
      PhotoFileDao photoFileDao,
      TransactionManager txManager) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.txManager = txManager;
    this.name = "/photoboard/add";
  }

  @Override
  public void execute(Response response) throws Exception {
    txManager.beginTransaction();
    
    try {
    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setTitle(response.requestString("사진 제목?"));
    photoBoard.setLessonNo(response.requestInt("수업번호?"));
    photoBoardDao.insert(photoBoard);

    response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
    response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

    ArrayList<PhotoFile> files = new ArrayList<>();
    while (true) {
      String filePath = response.requestString("사진 파일?");
      if (filePath.length() == 0) {
        if (files.size() == 0) {
          response.println("최소 한개의 사진 파일을 등록해야 합니다.");
          continue;
        } else {
          break;
        }
      }

      PhotoFile file = new PhotoFile();
      file.setFilePath(filePath);
      file.setPhotoBoardNo(photoBoard.getNo());
      
      files.add(file);
    }
    
    photoFileDao.insert(files);
    
    response.println("저장하였습니다.");
    txManager.commit();
    
    } catch (Exception e) {
      e.printStackTrace();
      response.println("저장 중 오류 발생");
      txManager.rollback();
    }
  }
}



