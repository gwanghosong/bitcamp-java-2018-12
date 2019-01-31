// try-with-resources 문법 사용전
package ch21.f;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    
    // 자바에서 제공하는 자원들 중에서는 쓰고 난 다음에 해제시켜야 하는 자원이 있다.
    // 보통 파일이나 네트워크 입출력, 데이터베이스 연결과 같은 한정된 자원이다.
    // 무한대의 자원이 아닌 한정된 자원인 경우 다른 프로그램이 사용할 수 있도록 해제시킨다.
    // 예를 들어, 네트워크 연결이 1라인이라고 하자.
    // 그러면 1개의 프로그램이 그 라인을 사용하고 해제하지 않으면,
    // 다른 프로그램들은 계속 사용하지 못한다.
    // 따라서 해제해줘야 한다.
    // 이 예제에서는 Scanner 객체나 FileWriter, PrintWriter 객체가 이에 해당한다.
    //
    // 이런 한정된 자원을 사용하는 경우 대부분의 메서드가 예외를 던지게 정의되어 있다.
    // 그래서 자원을 해제시킬 때 주로 try ~ catch ~ finally 에서 처리한다.
    Scanner keyboard = null;

    try {
      keyboard = new Scanner(System.in);
      System.out.print("값1? ");
      int a = Integer.parseInt(keyboard.nextLine());

      int result = sum(a);
      System.out.println(result);
    } catch (Exception e) {
      StringWriter out = new StringWriter();
      PrintWriter out2 = new PrintWriter(out); 
      
      // 상세 오류 정보를 String으로 받기
      e.printStackTrace(out2);
      
      out2.close();
      
      try {
        out.close(); // PrintWriter가 사용하는 자원, 즉 인스턴스가 out이니까 
        // out.close();를 수행함으로써 생길 수 있는 예외를 처리
      } catch (Exception e2) {
        // 자원을 해제시키다가 예외가 발생할 경우 개발자가 처리할게 없다.
        // 그래서 예외를 받기만 하고 특별히 뭔가를 수행하지는 않는다.
      }
      // StringWriter 객체에 저장된 문자열 꺼내기
      String str = out.toString();
      System.out.println(str);
      
    } finally {
      keyboard.close();
      
    }
  }

  static int sum(int value) { // f(n) = n + f(n-1)
    if (value == 1)
      return 1;
    return value + sum(value - 1);
  }
}