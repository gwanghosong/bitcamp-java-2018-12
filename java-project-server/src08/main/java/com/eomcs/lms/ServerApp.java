// 8단계 : 클라이언트 요청을 처리하는 클래스에 대해 리펙토링 수행
// 리펙토링 : 소스 코드를 유지보수 하기 좋게 소스 코드의 구조를 변경하고 정리하는 것.
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class ServerApp {

  static ArrayList<Member> members = new ArrayList<>();
  static ArrayList<Lesson> lessons = new ArrayList<>();
  static ArrayList<Board> boards = new ArrayList<>();

  static ObjectInputStream in;
  static ObjectOutputStream out;

  public static void main(String[] args) {


    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작");

      while (true) {
        try (Socket socket = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream((socket.getInputStream()))) {

          System.out.println("클라이언트와 연결되었음.");
          members.clear();
          lessons.clear();
          boards.clear();

          ServerApp.in = in; // this 못쓰는 이유? static이잖아, this는 인스턴스변수만 접근가능
          ServerApp.out = out;

          MemberService memberService = new MemberService(in, out);
          LessonService lessonService = new LessonService(in, out);
          BoardService boardService = new BoardService(in, out);

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
    out.writeUTF("종료함!");
    out.flush();
  }
}
