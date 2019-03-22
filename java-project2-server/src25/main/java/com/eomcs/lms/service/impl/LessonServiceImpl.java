package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {

  LessonDao lessonDao;
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  PlatformTransactionManager txManager;

  public LessonServiceImpl(
      LessonDao lessonDao,
      PhotoBoardDao photoBoardDao,
      PhotoFileDao photoFileDao,
      PlatformTransactionManager txManager) {
    this.lessonDao = lessonDao;
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.txManager = txManager;
  }

  @Override
  public List<Lesson> list() {

    return lessonDao.findAll();
  }

  @Override
  public int add(Lesson lesson) {

    return lessonDao.insert(lesson);
  }

  @Override
  public Lesson get(int no) {

    Lesson lesson = lessonDao.findByNo(no);

    return lesson;
  }

  @Override
  public int update(Lesson lesson) {

    return lessonDao.update(lesson);
  }

  @Override
  public int delete(int no) {

    // 트랜잭션의 동작 방식을 설정한다.
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    // 트랜잭션을 준비한다.
    TransactionStatus status = txManager.getTransaction(def);
    try {

      HashMap<String,Object> params = new HashMap<>();
      params.put("lessonNo", no);

      List<PhotoBoard> boards = photoBoardDao.findAll(params);
      for (PhotoBoard board : boards) {
        photoFileDao.deleteByPhotoBoardNo(board.getNo());
        photoBoardDao.delete(board.getNo());

      } 

      int count = lessonDao.delete(no);
      txManager.commit(status);
      return count;

    } catch (RuntimeException e) {
      txManager.rollback(status);
      throw e;
    }
  }
}
