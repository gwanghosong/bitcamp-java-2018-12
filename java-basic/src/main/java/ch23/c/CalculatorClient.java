// 계산기 클라이언트 만들기 : 최소 +, -, *, /, % 연산자는 지원한다. 
package ch23.c;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import ch22.c.BufferedOutputStream;

/* 
 실행 예 :
 클라이언트가 계산기 서버에 접속한 후

 계산기 서버에 오신 걸 환영합니다! <== 서버의 응답
 계산식을 입력하세요! <== 서버의 응답
 예) 23 + 7 <== 서버의 응답
 > 23 + 7 <== 사용자의 입력. '>' 문자는 클라이언트에서 출력한다.
 결과는 30 입니다.  <== 서버의 응답
 > 23 ^ 7 <== 사용자의 입력. '>' 문자는 클라이언트에서 출력한다.
 ^ 연산자를 지원하지 않습니다. <== 서버의 응답
 > ok + yes <== 사용자의 입력 '>' 문자는 클라이언트에서 출력한다.
 식의 형식이 잘못되었습니다. <== 서버의 응답
 > quit <== 사용자의 입력 '>' 문자는 클라이언트에서 출력한다.
 안녕히 가세요! <== 서버의 응답

 */

public class CalculatorClient {

  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        Scanner keyboard = new Scanner(System.in);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        DataInputStream in2 = new DataInputStream(
            new BufferedInputStream(socket.getInputStream()))) {

      String response = in.nextLine();
      String response1 = in.nextLine();
      String response2 = in.nextLine();
      System.out.println(response);
      System.out.println(response1);
      System.out.println(response2);
      while (true) {
        if (response2.equals("quit")) {
          break;
        } else {
      System.out.print("> ");
      out.println(keyboard.nextLine());
      out.flush();
        }
        
      }
      System.out.println(in.nextLine());
      System.out.println("종료합니다!");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


