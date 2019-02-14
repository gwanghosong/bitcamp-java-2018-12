package com.eomcs.lms.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardService implements Service {

  // BoardService가 작업을 수행할 때 사용할 객체(의존 객체; dependency)
  BoardDao boardDao;

  public BoardService(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  public void execute(String request, ObjectInputStream in, ObjectOutputStream out) throws Exception {
    // this.in = in
    // this.out = out
    // 메서드가 일시적으로 호출될때만 사용하는 필드 값은 그냥 파라미터로 넘겨 받아라.
    // 그리고 메서드가 이렇게 받으면 기능이 늘어나서 응집력이 낮아지니까 하지말자
    // 또한 멀티스레드환경에서는 문제가 발생한다.

    switch (request) {
      case "/board/add" :
        add(in, out);
        break;
      case "/board/list" :
        list(in, out);
        break;
      case "/board/detail" :
        detail(in, out);
        break;
      case "/board/update" :
        update(in, out);
        break;
      case "/board/delete" :
        delete(in, out);
        break;
      default:
        out.writeUTF("FAIL");
    }
    out.flush();
  }

  private void add(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.flush();
    boardDao.insert((Board) in.readObject());
    out.writeUTF("OK");
  }

  private void list(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.flush();
    out.writeUTF("OK");
    out.writeUnshared(boardDao.findAll());
  }

  private void detail(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();

    Board b = boardDao.findByNo(no);
    if (b == null) {
      out.writeUTF("FAIL");
      return; 
    }
    out.writeUTF("OK");
    out.writeObject(b);
    return;
  }

  private void update(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.flush();
    Board board = (Board) in.readObject();

    if (boardDao.update(board) == 0) {
      out.writeUTF("FAIL");
      return;
    }
    out.writeUTF("OK");
  }

  private void delete(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();

    if (boardDao.delete(no) == 0) {
      out.writeUTF("FAIL");
      return;
    }
    out.writeUTF("OK");
  }

}
