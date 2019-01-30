// 예외 던지기 - RuntimeException 예외 던지기
package ch21.d;

public class Test07 {

  public static void main(String[] args) {
    // RuntimeException도 Exception과 마찬가지로
    // main()에서는 예외를 처리해야 한다.
    // 정상적인 프로그램 종료를 수행해야 한다.
    // try ~ catch를 사용하지 않아도 된다는 것이 예외를 자동으로 처리한다는 것이 아니다!
    // RuntimeException 계열의 예외도 최소한 main()에서는 처리해 줘야 한다.
    // 
    // RuntimeException 예외는 메서드 선언부에 throws 절을 붙이지 않아도 되기 때문에
    // 스텔스처럼 조용히 전달된다. 코딩하기가 편하다.
    // 그래서 대부분의 라이브러리나 프레임워크에서는 
    // 개발자가 예외처리를 위해 throws 절을 사용하는 번거로움을 덜어주고자
    // 라이브러리/프레임워크 내부에서 발생하는 예외를 보통 RuntimeException에 담아 던진다.
    // 왜냐하면 그냥 Exception 예외가 되면 그 예외가 포함된 메서드를 호출할 때마다
    // throws절을 선언해줘야하기때문에 너무나~~~ 번거로워진다.
    // 따라서 RuntimeException에 담아 던짐으로써  throws 절을 작성하지 않아도 되고,
    // 적절한 시점에서 개발자에게 적절한 위치에서 처리하라고 선택권을 주는 셈이다.
    // 하지만 최소 마지막 main()에서까지는 처리해야 시스템이 정상 작동한다.
    //
    try {
      m3();
    } catch (RuntimeException e) {
      System.out.println(e.toString());
    }
    System.out.println("종료!");
  }

  static void m3() {
    // RuntimeException 예외를 발생시키는 메서드는 
    // 메서드 선언부에 어떤 예외를 던지는지 선언(보고)하지 않아도 된다.
    // try ~ catch로 처리하지 않아도 된다.
    m2();
  }

  static void m2() {
    // RuntimeException 예외를 발생시키는 메서드는 
    // 메서드 선언부에 어떤 예외를 던지는지 선언(보고)하지 않아도 된다.
    // try ~ catch로 처리하지 않아도 된다.
    m1(); 
  }

  static void m1() {
    // RuntimeException 예외를 발생시키는 메서드는 
    // 메서드 선언부에 어떤 예외를 던지는지 선언(보고)하지 않아도 된다.
    throw new RuntimeException("m1()에서 발생한 예외");
  }
}
