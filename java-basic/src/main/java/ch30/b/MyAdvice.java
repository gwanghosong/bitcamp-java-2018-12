package ch30.b;

// 지정된 객체의 메서드를 호출할 때,
// : 메서드 호출 전이나 후에 어떤 작업을 수행하는 일을 한다.
public class MyAdvice {
  
  // 어떤 메서드 호출 전/후에 먼저 호출될 메서드이다.
  public void advice1() {
    System.out.println("MyAdvice.advice1()");
  }
  
  public void advice2() {
    System.out.println("MyAdvice.advice2()");
  }
}
