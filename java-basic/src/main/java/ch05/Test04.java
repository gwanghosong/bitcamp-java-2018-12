// 흐름제어문 - switch
package ch05;

public class Test04 {
  public static void main(String[] args) {
    byte b = 1;
    short s = 1;
    char c = 1;
    int i = 1;
    long l = 1L; // 에러
    float f = 1.0f; // 에러
    double d= 1.0; // 에러
    
    switch (b) {
      case 1:
        System.out.println("11");
        System.out.println("1111");
        break;
      case 2:
        System.out.println("22");
        System.out.println("2222");
        break;
      case 'A': //'A'의 리턴값은 2바이트 정수(UTF-16코드) 값이다.
        System.out.println("AAAA");
        break;
      default:
        System.out.println("????");
    }
  }
}
















