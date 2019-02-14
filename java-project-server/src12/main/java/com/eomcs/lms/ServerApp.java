// 11단계: 서비스 클래스의 일반화(상속)를 수행한다.
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.service.BoardService;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.MemberService;

public class ServerApp {

  static ObjectInputStream in;
  static ObjectOutputStream out;

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

    BoardService boardService = new BoardService(boardDao);
    MemberService memberService = new MemberService(memberDao);
    LessonService lessonService = new LessonService(lessonDao);

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작");

      // 객체는 반복 안하기 위해서 while문생성
      // 각 인스턴스 초기화, 생성시 오류 발생이 각각에 영향 안미치도록 하기위해 분리함.

      while (true) {
        try (Socket socket = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream((socket.getInputStream()))) {

          // 클라이언트마다 입출력 스트림을 새로 받기위해서 입출력장치 설정
          boardService.init(in, out);
          lessonService.init(in, out);
          memberService.init(in, out);

          System.out.println("클라이언트와 연결되었음.");
          ServerApp.in = in; // this 못쓰는 이유? static이잖아, this는 인스턴스변수만 접근가능
          ServerApp.out = out;

          // switch문은 값의 단순 비교까지만 가능
          // 복잡한 것은 if문써야함.
          // startsWith(A) A로 시작한다면~
          loop: while (true) {
            String request = in.readUTF();
            System.out.println(request);

            if (request.startsWith("/member")) {
              memberService.execute(request);

            } else if (request.startsWith("/lesson")) {
              lessonService.execute(request);

            } else if (request.startsWith("/board")) {
              boardService.execute(request);

            } else if (request.equals("quit")) {
              quit();
              break loop;
            } else {
              out.writeUTF("FAIL");
            }
            out.flush();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와의 연결을 끊었음.");
      }

    } catch (Exception e) {
      e.printStackTrace();

    }
  }

  static void quit() throws Exception {
    // 순차적으로, 즉 논리적으로 ABC가 순차적으로 실행이 되어야 프로그램이 정상적으로 돌아간다면
    // try {ABC} 이렇게 하나로 묶어야 하고
    // 순차적이 아닌, ABC 각각이 논리적으로 실행이 되어야 프로그램이 정상적으로 돌아간다면
    // try {A}, try {B}, try {C} 이렇게 각각 묶어서 해야지
    // 오류가 하나가 나도 나머지는 정상적으로 작동하게 된다.
    try {
      boardDao.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }

    try {
      memberDao.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }

    try {
      lessonDao.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }

    out.writeUTF("종료함!");
    out.flush();
  }
}
