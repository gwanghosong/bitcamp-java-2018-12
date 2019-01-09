// 메서드 - 메서드의 리턴값
package ch06;

public class Test03 {
  public static void main(String[] args) {
    int i;
    //i = m1();  리턴 값의 타입과 변수의 타입 맞춰 컴파일오류!
    String s;
    s = m1();
    System.out.println(s);
    
    i = m2();
    System.out.println(i);
    
    m1();
    m2();
  }
  
  static String m1() {
    return "홍길동";
  }
  
  static int m2() {
    return 100;
  }
}
















