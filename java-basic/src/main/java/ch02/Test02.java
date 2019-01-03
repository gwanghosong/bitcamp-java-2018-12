// 리터럴(literal) - 자바 언어로 표현한 값
package ch02;

public class Test02 {
  public static void main(String[] args) {
 // 20억을 4바이트로 출력하라.
    System.out.println(2000000000);
    // 20억을 8바이트 리터럴로 출력하라.
    System.out.println(2000000000L);
    // 30억을 8바이트 리터럴로 출력하라.
    System.out.println(3000000000L);
    // 30억을 4바이트 리터럴로 출력하라.
    //System.out.println(3000000000); // 컴파일 오류!
  }
}

/*
# 리터럴
정수(integer)
  100 (10진수)
  0144 (8진수)
  0x64, 0X64 (16진수)
  0b01100100, 0B01100100 (2진수; binary)  
부동소수점(floating point)
  3.14
  31.4E-1
  314E-2
  0.314E1
  0.0314E2
논리
  true
  false
문자(결국 숫자로 표현한다)
  (char)0x41
  (char)65
  'A'
문자열
  "ABC"
  "가각간"
메모리 주소(레퍼런스; reference)
  자바에서는 임의의 메모리 주소를 표현할 방법이 없다.
  new 명령으로 메모리를 주소를 리턴 받아야 한다.

# 4바이트 정수 리터럴
100

# 8바이트 정수 리터럴
정수 뒤에 접미사 L or l을 붙인다.
100L(주로사용)
100l
# 콘솔로 출력하는 명령어
  System.out.println(값);
 */















