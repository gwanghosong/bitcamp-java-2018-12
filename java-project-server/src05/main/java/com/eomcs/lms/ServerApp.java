// 5단계
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
              case "add" :
                add();
                break;
              case "list" :
                list();
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
    out.writeObject(members);
  }

}
