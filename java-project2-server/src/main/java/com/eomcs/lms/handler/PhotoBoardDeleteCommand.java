package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.mybatis.TransactionManager;

public class PhotoBoardDeleteCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  TransactionManager txManager;

  public PhotoBoardDeleteCommand(
      PhotoBoardDao photoBoardDao,
      PhotoFileDao photoFileDao,
      TransactionManager txManager) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.txManager = txManager;
    this.name = "/photoboard/delete";
  }

  @Override
  public void execute(Response response) throws Exception {
    txManager.beginTransaction();
    try {
      int no = response.requestInt("번호?");

      photoFileDao.deleteByPhotoBoardNo(no);

      if (photoBoardDao.delete(no) == 0) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
      response.println("삭제했습니다.");
      txManager.commit();

    } catch (Exception e) {
      txManager.rollback();
      response.println("삭제 중 오류 발생.");
    }
  }
}
