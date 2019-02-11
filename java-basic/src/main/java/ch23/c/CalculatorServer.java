// 계산기 서버 만들기 
package ch23.c;

import java.net.ServerSocket;

public class CalculatorServer {

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      while (true) { 
        try {
          new CalculatorProcessor(serverSocket.accept()).execute();
        } catch (Exception e) {
          System.out.println("클라이언트와 통신 중에 오류 발생!");
          e.printStackTrace();
        }
      }

    } catch (Exception e) {
      e.printStackTrace();

    }
  }
}


//out.write("계산기 서버에 오신 것을 환영합니다!" + "\n" + "계산식을 입력하세요!" + "\n" + "예) 23 + 7 " + "\n");
//out.flush();
//        while (true) {
//          if (in.equals("quit")) {
//
//            out.println("quit");
//            out.flush();
//            break;
//          } else {
//
//
//
//            int result = 0;
//
//            System.out.println(result);
//            out.write(result);
//            out.flush();
//
//          }
//
//        }
//        System.out.println("종료합니다!");
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//
//  }
//
//
//
//  static int plus(int a, int b) {
//    return a + b;
//  }
//  static int minus(int a, int b) {
//    return a - b;
//  }
//  static int multiple(int a, int b) {
//    return a * b;
//  }
//  static int divide(int a, int b) {
//    return a / b;
//  }






