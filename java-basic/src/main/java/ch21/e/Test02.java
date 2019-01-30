// 예외 정보 출력하기 
package ch21.e;

import java.util.Scanner;

public class Test02 {

// 블록 안에 선언된 변수는 블록 안에서 선언되고 사라진다.
// 블록 밖에 선언된 변수를 블록 안으로 가져오는 것은 가능하지만
// 블록 안에 선언된 변수를 블록 밖으로 가져가는 것은 불가능하다.
// Scanner keyboard = null;를 try 블록 안으로 가져오면
// finally 에서 keyboard.close();가 컴파일 에러가 떠버린다.
  public static void main(String[] args) throws Exception {
    Scanner keyboard = null;

    try {
      keyboard = new Scanner(System.in);
      System.out.print("값1? ");
      int a = Integer.parseInt(keyboard.nextLine());

      int result = sum(a);
      System.out.println(result);
    } catch (Exception e) {
      // 예외가 발생한 메서드의 위치 정보를 콘솔에 자세하게 출력한다.
      e.printStackTrace();
    } finally {
      keyboard.close();
    }
  }

  static int sum(int value) { // f(n) = n + f(n-1)
    if (value == 1) {
      return 1;
    } else if (value <= 0){
      System.out.println("1이상 정수값만 입력할 수 있습니다.");
      return 0; // 0은 이 이하의 값이 입력됬다는 의미.
    } else {
    return value + sum(value - 1);
    }
  }
}
