// 예외 처리하기 - 여러 개의 예외가 발생할 때 : 멀티 catch 블록을 사용한다.
package ch21.b;

import java.util.HashMap;
import java.util.Scanner;

public class Test02 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    HashMap<String, Command> commandMap = new HashMap<>();
    commandMap.put("plus", new PlusCommand(keyboard));

    while (true) {
      System.out.print("명령> ");
      String input = keyboard.nextLine();

      if (input.equals("quit"))
        break;

      // 예외 처리 문법을 적용하면, 예외가 발생하더라도 JVM을 멈추지 않는다.
      try {
        Command command = commandMap.get(input);
        command.execute();
        
        // try 블록에서 발생할 수 있는 예외가 여러 개일 때
        // 각 예외 정보를 받을 catch 블록을 여러개 둘 수 있다.
        // 모든 예외마다 설정해야 그 예외를 처리할 수 있다.
      } catch (NullPointerException e) {
        System.out.println("해당 명령이 존재하지 않습니다.");
        // key값을 잘못입력할시 그 key에 해당하는 값이 없어서 생기는 오류
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
        // 숫자를 입력해야하는데 다른 형태를 입력했을 경우 생기는 오류
      }
    }

    System.out.println("실행 완료!");
    keyboard.close();
  }
}
