// 프록시 패턴 적용 - BoardDao에서 인터페이스를 추출한다.
package practice16.lms.dao;

import java.util.List;
import practice16.lms.domain.Board;

public interface BoardDao {
  void insert(Board board);
  List<Board> findAll();
  Board findByNo(int no);
  int update(Board board);
  int delete(int no);
}







