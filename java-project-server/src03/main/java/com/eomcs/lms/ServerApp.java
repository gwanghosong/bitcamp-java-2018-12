// 3단계
package com.eomcs.lms;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작");

      while (true) {
        try (Socket socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream())) {

          System.out.println("클라이언트와 연결되었음.");

          String request = in.nextLine();
          out.println(request);
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
