// l-value와 r-value 용어
package ch03;

public class Test04 {
  public static void main(String[] args) {
    int a = 100;
    int b = a;
    
    System.out.printf("%d, %d\n", a, b);
    
    a = 200;
    
    System.out.printf("%d, %d\n", a, b);
    
    // 100 = 20; // 컴파일 오류! l-value 는 반드시 메모리여야 한다.
   // 100 = a; 컴파일 오류;
    
    a = 300; // r-value는 리터럴 가능하다.
    a = b; // r-value는 변수 가능하다. 의미? 변수의 값을 왼쪽 변수에 저장하라는 의미다.

  }
}









