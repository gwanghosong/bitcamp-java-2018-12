// 3단계 - 프록시 패턴을 적용하여 C/S(Client/Server) 계산기 어플리케이션 사용하기
// 서버 개발자가 제공해준 프록시 객체를 사용하여 계산을 수행한다.
// 프록시 객체는 마치 자신이 실제 일을 하는 것처럼 행동한다.

package design_pattern.proxy.after.client;

import java.util.Scanner;
import design_pattern.proxy.after.server.Calculator;
import design_pattern.proxy.after.server.CalculatorStub;

public class App {
  public static void main(String[] args) throws Exception {

    Scanner keyboard = new Scanner(System.in);

    // 클라이언트 개발자가 원격에 있는 객체를 사용하기 위해서 
    // 원격 서버와 통신하는 코드를 프로토콜(데이터를 주고 받는 규칙)에 맞춰 직접 작성하였다.
    Calculator calc = new CalculatorStub();
    // client에서 Calculator 인터페이스와 stub을 받아도 성립한다.
    // 즉 똑같은 규칙을 받아오면 성립한다.
    // 근데 rmi에서는 이렇게하면 성립이안된다.
    // 유추하건데 rmiregistry는 서버에 stub을 등록할때
    // stub이 실제로 작업하는 impl위치나 인터페이스 위치까지 
    // 같이 등록해서 stub으로 받으면 
    // 폴더에서 똑같은 규칙으로 구현한 stub과 달라지는게 아닌가 예상한다.
    // 

    while (true) {
      System.out.print("계산식>(예: 100 + 200) ");
      String input = keyboard.nextLine();
      if (input.equalsIgnoreCase("quit"))
        break;

      String[] values = input.split(" ");
      try {
        int a = Integer.parseInt(values[0]);
        int b = Integer.parseInt(values[2]);
        String op = values[1];

        switch (values[1]) {
          // 이렇게 Calculator를 로컬에서 사용하는 것처럼
          // CalculatorStub이라는 프록시를 통해 작업을 수행할 수 있다.
          // Calculator를 사용해야 하는 클라이언트 개발자는
          // calculator를 사용하기 위해 서버와 통신하는 코드를 작성할 필요가 없다.
          // 서버 개발자가 프록시 객체를 만들어 제공해 줄 것이다.
          case "+":System.out.println(calc.plus(a, b)); break;
          case "-": System.out.println(calc.minus(a, b)); break;
          default:
        }
      } catch (Exception e) {
        System.out.println("식 또는 계산 오류: " + e.getMessage());
      }
    }
    keyboard.close();
  }
}

