// 12단계 : stateful >> stateless로 변경
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.service.BoardService;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.MemberService;
import com.eomcs.lms.service.Service;

public class ServerApp {

  static BoardDao boardDao = null;
  static MemberDao memberDao = null;
  static LessonDao lessonDao = null;

  public static void main(String[] args) {

    try {
      boardDao = new BoardDao("board.bin");
      boardDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생!");
    }

    try {
      memberDao = new MemberDao("member.bin");
      memberDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생!");
    }

    try {
      lessonDao = new LessonDao("lesson.bin");
      lessonDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생!");
    }

    HashMap<String, Service> serviceMap = new HashMap<>();
    serviceMap.put("/board/", new BoardService(boardDao));
    serviceMap.put("/member/", new MemberService(memberDao));
    serviceMap.put("/lesson/", new LessonService(lessonDao));

    // /board/, /member/, /lesson/ key를 모은 Set
    Set<String> keySet = serviceMap.keySet();

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작");

      // 객체는 반복 안하기 위해서 while문생성
      // 각 인스턴스 초기화, 생성시 오류 발생이 각각에 영향 안미치도록 하기위해 분리함.

      while (true) {
        try (Socket socket = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream((socket.getInputStream()))) {

          System.out.println("클라이언트와 연결되었음.");

          String request = in.readUTF();
          System.out.println(request);


          String serviceName = null;
          for (String key : keySet) {
            if (request.startsWith(key)) {
              serviceName = key;
              break;
            }
          }

          if (serviceName == null) {
            out.writeUTF("FAIL");

          } else {
            Service service = serviceMap.get(serviceName);
            service.execute(request, in, out);
          }
          out.flush();

        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와의 연결을 끊었음.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
