// 예외 던지기 - RuntimeException 예외 던지기
package ch21.d;

public class Test06 {

  public static void main(String[] args) {
    // main()에서 RuntimeException 예외를 처리하지 않으면
    // 당연히 그 상위 호출자, 즉 JVM에게 전달된다.
    // 
    // 각 메서드마다 throws 절을 작성할 필요가 없다.
    // RuntimeException은 Exception에 비해 다루기가 편하다.
    // 다루기가 편할 뿐이지 마찬가지로 예외를 try ~ catch로 처리하지않으면
    // 마찬가지로 예외 발생 상황에서 시스템이 멈추기는 매한가지다.
    // 따라서 main()메서드에서는 무조건 예외를 처리해줘야한다.
    //
    m3();
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
