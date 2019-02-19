package practice;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import practice.domain.Board;
import practice.domain.Lesson;
import practice.domain.Member;
import practice.service.BoardService;
import practice.service.LessonService;
import practice.service.MemberService;


public class ServerApp {

  static ArrayList<Member> members = new ArrayList<>();
  static ArrayList<Lesson> lessons = new ArrayList<>();
  static ArrayList<Board> boards = new ArrayList<>();

  static ObjectInputStream in;
  static ObjectOutputStream out;

  static MemberService memberService = null;
  static LessonService lessonService = null;
  static BoardService boardService = null;

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작!");

      try {
        memberService = new MemberService();
        memberService.loadData("member.bin");
      } catch (Exception e) {
        System.out.println("데이터 로드 중 오류 발생!");
      }

      try {
        lessonService = new LessonService();
        lessonService.loadData("lesson.bin");
      } catch (Exception e) {
        System.out.println("데이터 로드 중 오류 발생!");
      }

      try {
        boardService = new BoardService();
        boardService.loadData("board.bin");
      } catch (Exception e) {
        System.out.println("데이터 로드 중 오류 발생!");
      }

      while (true) {
        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

          memberService.init(in, out);
          lessonService.init(in, out);
          boardService.init(in, out);

          System.out.println("클라이언트와 연결되었음.");
          members.clear();
          ServerApp.in = in;
          ServerApp.out = out;

          loop: while (true) {
            String request = in.readUTF();
            System.out.println(request);

            if (request.startsWith("/member/")) {
              memberService.execute(request);

            } else if (request.startsWith("/lesson/")) {
              lessonService.execute(request);

            } else if (request.startsWith("/board/")) {
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
    try {
      memberService.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      boardService.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      lessonService.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    out.writeUTF("종료함!");
    out.flush();
  }
}





