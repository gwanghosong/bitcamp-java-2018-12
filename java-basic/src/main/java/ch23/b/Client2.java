// 데이터 주고받기 - 에코(echo) 클라이언트 만들기
package ch23.b;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

  public static void main(String[] args) {
    // java -cp bin/main ch23.b.Client2로 실험
    try (Socket socket = new Socket("localhost", 8888 );
        // 문자열을 주고 받기 편하도록 오리지널 입출력 스트림 객체에 데코레이터를 붙인다.
        // Scanner는 데코레이터는 아니지만, 데코레이터처럼 마지막에는 사용가능하다.
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {

      System.out.println("서버와 연결되었음!");

      out.println("Hello!");
      out.flush(); // 중요! 스트림 객체의 내부 버퍼에 출력된 내용을 네트워크로 방출시킨다.
      // 안쓰면 스트림 객체의 내부 버퍼에 내용이 네트워크로 방출이 안되므로 내용이 안보내짐. 
      System.out.println("서버에 데이터를 보냈음!"); 

      String response = in.nextLine();
      System.out.println(response);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
