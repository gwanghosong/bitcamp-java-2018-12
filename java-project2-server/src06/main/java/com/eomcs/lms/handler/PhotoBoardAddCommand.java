package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardAddCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao; // 서버의 PhotoBoardDaoImpl 객체를 대행하는 프록시 객체이다.

  public PhotoBoardAddCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setTitle(response.requestString("제목?"));
    photoBoard.setLessonNo(response.requestInt("수업 번호?"));
    photoBoardDao.insert(photoBoard);

    response.println("저장하였습니다.");
  }
}



