package ch01;
/** 
java doc 주석이라 한다. 즉 자바 API문서(HTML)를 생성할 때 참고하는 주석이다. 클래스, 변수, 매서드 선언에 붙인다.
**/
public class Test03 { // 주석
  /**
  이 매서드는 Object 클래스의 매서드를 재정의한 것이다
  **/
  @Override // 애노테이션이란 주석. 프로그램에서 사용.
  public String toString() {
    return "ok";
  }
  public static void main(String[] args) {
    /* 주석
    주석
    주석
    *주석
    */
    System.out.println("Hello!");
  }
}
