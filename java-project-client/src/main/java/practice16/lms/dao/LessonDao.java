// 프록시 패턴 적용 - LessonDao에서 인터페이스를 추출한다.
package practice16.lms.dao;

import java.util.List;
import practice16.lms.domain.Lesson;

public interface LessonDao {
  void insert(Lesson lesson);
  List<Lesson> findAll();
  Lesson findByNo(int no);
  int update(Lesson lesson);
  int delete(int no);
}







