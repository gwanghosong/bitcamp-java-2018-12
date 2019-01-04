// 문자 제어코드
package ch02;

public class Test10 {
  public static void main(String[] args) {
    System.out.println("Hello,\nworld!"); //줄바꿈은 이 제어 문자 사용
    System.out.println("안녕하세요, \n\n반갑습니다!");
    System.out.println("Hello,\rworld!");
    System.out.println("Hello,\b\b\bworld!"); //backspace 3개지우면 Helworld!
    System.out.println("Hello,\tworld!");
    System.out.println("Hello,\fworld!");
    System.out.println("Hello,\"w\"orld!");
    System.out.println("Hello,'w'orld!");
    System.out.println('\'');
    System.out.println('"');
    System.out.println("Hello, \\\\\\world!");
  }
}

/*
\n line feed LF 0x0a
\r Carrage Return CR 0x0d
\f Form Feed 0x0c 다음페이지부터 출력
\t Tab 0x09
\b Backspace 0x08
\' sing quote 0x27
\" double quote 0x22
\\ Backslash 0x5c

 */














