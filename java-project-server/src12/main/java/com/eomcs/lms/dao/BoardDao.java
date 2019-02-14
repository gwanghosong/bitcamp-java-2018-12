// 데이터 처리 관련 코드를 별도의 클래스로 분리
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDao extends AbstractDao<Board> {

  public BoardDao(String filepath) {
    this.filepath = filepath;
  }

  public void insert(Board board) {
    list.add(board);
  }

  public List<Board> findAll() {
    return list;
  }

  public Board findByNo(int no) {
    for (Board b : list) {
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

  public int update(Board board) {
    // index 찾기가 힘드니까 No의 수가 같은 인스턴스를 찾는데
    // index를 0으로 지정해주고 거기서부터 하나씩 늘려가면서 찾고,
    // No수가 같은 곳이 나오면 바로 그 index를 대입해서 그 인스턴스를 바꿔준다.
    int index = 0;
    for (Board b : list) {
      if (b.getNo() == board.getNo()) {
        list.set(index, board);
        return 1;
      }
      index++;
    }
    return 0;
  }

  public int delete(int no) throws Exception {
    int index = 0;
    for (Board b : list) {
      if (b.getNo() == no) {
        list.remove(index);
        return 1 ;
      }
      index++;
    }
    return 0;
  }
}
