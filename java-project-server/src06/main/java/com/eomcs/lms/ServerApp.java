// 6단계
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.eomcs.lms.domain.Member;

public class ServerApp {

  static ArrayList<Member> members = new ArrayList<>();
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
          ServerApp.in = in; // this 못쓰는 이유? static이잖아, this는 인스턴스변수만 접근가능
          ServerApp.out = out;

          // 라벨 loop: 적용
          loop: while (true) {
            String request = in.readUTF();
            System.out.println(request);
            switch (request) {
              case "quit":
                quit();
                break loop;
              case "/member/add" :
                add();
                break;
              case "/member/list" :
                list();
                break;
              case "/member/detail" :
                detail();
                break;
              case "/member/update" :
                update();
                break;
              case "/member/delete" :
                delete();
                break;
              default:
                out.writeUTF("이 명령을 처리할 수 없음!");
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

  static void add() throws Exception {
    members.add((Member)in.readObject());
    out.writeUTF("OK");
  }

  static void list() throws Exception {
    out.writeUTF("OK");
    out.writeObject(members);
  }

  // 함수를 어디부분까지 수행하고 그 메서드를 종료하고 싶으면
  // return;을 사용해서 거기까지 수행하고 종료하게 할 수 있다.
  // 즉, 해당 메소드 실행중 특정 조건에 따라 해당 메소드의 진행을 멈추고 빠져나올때 사용한다.
  
  // break는 if문, for문 같은 반복문을 진행하다 멈출 때 사용
  
  static void detail() throws Exception {
    int no = in.readInt();

    for (Member m : members) {
      if (m.getNo() == no) {
        out.writeUTF("OK");
        out.writeObject(m);
        return;
      }
    }

    out.writeUTF("FAIL");
  }

  static void update() throws Exception {
    Member member = (Member) in.readObject();

    int index = 0;
    for (Member m : members) {
      if (m.getNo() == member.getNo()) {
        members.set(index, member);
        out.writeUTF("OK");
        return;
      }
      index++;
    }

    out.writeUTF("FAIL");
  }
  static void delete() throws Exception {
    int no = in.readInt();

    int index = 0;
    for (Member m : members) {
      if (m.getNo() == no) {
        members.remove(index);
        out.writeUTF("OK");
        return;
      }
      index++;
    }

    out.writeUTF("FAIL");
  }
}
