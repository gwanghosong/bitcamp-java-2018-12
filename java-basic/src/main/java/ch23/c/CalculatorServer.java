// 계산기 서버 만들기
package ch23.c;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class CalculatorServer {

  public static void main(String[] args) {

    try (
        Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {

      try (
          Socket socket = serverSocket.accept();
          PrintWriter out = new PrintWriter(socket.getOutputStream());
          Scanner in = new Scanner(socket.getInputStream());
          InputStream in2 = socket.getInputStream()) {


        out.write("계산기 서버에 오신 것을 환영합니다!" + "\n" + "계산식을 입력하세요!" + "\n" + "예) 23 + 7 " + "\n");

        out.flush();

        while (true) {
          if (in.equals("quit")) {
            
            out.println("quit");
            out.flush();
            break;
          } else {

            int a = in.nextInt();
            String op = in.next();
            int b = in.nextInt();


            int result = 0;

            switch (op) {
              case "+": result = plus(a, b); break;
              case "-": result = minus(a, b); break;
              case "*": result = multiple(a, b); break;
              case "/": result = divide(a, b); break;
              default:
                System.out.println("지원하지 않는 연산자입니다.");
                return; 
            }
            System.out.println(result);
            out.write(result);
            out.flush();

          }
          
        }
        System.out.println("종료합니다!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }



  static int plus(int a, int b) {
    return a + b;
  }
  static int minus(int a, int b) {
    return a - b;
  }
  static int multiple(int a, int b) {
    return a * b;
  }
  static int divide(int a, int b) {
    return a / b;
  }

}






