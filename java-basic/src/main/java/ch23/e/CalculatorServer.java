// Stateless 응용 - 서버에서 계산 결과 유지하기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class CalculatorServer {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버 실행 중...");

      // 서버의 Stateless 통신 방법에서 클라이언트를 구분하여 각 클라이언트의 계산 결과를 유지하려면?
      // 커피숍에서는 고객의 쿠폰 포인트를 어떻게 관리할까?
      HashMap<String, Object> client = new HashMap<>();

      while (true) {

        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());){

          int result;
          if (!client.containsKey(socket.getInetAddress().getHostAddress())) {
            result = 0;
            client.put(socket.getInetAddress().getHostAddress(), result);
          }
          
          result = (int) client.get(socket.getInetAddress().getHostAddress());

          System.out.println("클라이언트와 연결됨! 요청처리 중...");

          String[] input = in.readLine().split(" ");

          int b = result;
          String op = null;

          try {
            op = input[0];
            b = Integer.parseInt(input[1]);
          } catch (Exception e) {
            out.println("식의 형식이 바르지 않습니다.");
            out.flush();
            continue; // while문 다시 반복
          }

          switch (op) {
            case "+": result += b; break;
            case "-": result -= b; break;
            case "*": result *= b; break;
            case "/": result /= b; break;
            case "%": result %= b; break;
            default:
              out.printf("%s 연산자를 지원하지 않습니다.\n", op);
              out.flush();
              continue;
          }
          client.put(socket.getInetAddress().getHostAddress(), result);
          out.printf("결과는 %d 입니다.\n", result);
          out.flush();

        } catch (Exception e) {
          //클라이언트 요청을 처리하다가 예외가 발생하면 무시하고 연결을 끊는다.
          System.out.println("클라이언트와 통신 중 오류 발생!");
          e.printStackTrace();
        }
        System.out.println("클라이언트와 연결 끊음!");
      } // while문

    } catch (Exception e) { // try 2
      e.printStackTrace();
    }
  } // main
} // class
