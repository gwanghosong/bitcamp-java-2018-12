// 콘솔로 출력하기
package ch02;

public class Test11 {
  public static void main(String[] args) {
    //값출력
    // println()= 출력 + 줄바꿈
    System.out.println(20);
    System.out.println(3.14f);
    System.out.println("Hello");
    System.out.println('Y');
    System.out.println(true);
    
    //값을 주지 않으면 줄바꿈만 수행한다.
    System.out.println();
    
    // print() 는 출력만한다. 줄바꿈없다.
    System.out.println(20);
    
    System.out.print(20);
    System.out.print(3.14f);
    System.out.print("Hello");
    System.out.print('Y');
    System.out.print(true);
    
    System.out.print('\n');
    
    System.out.print("Ok!\n"); // == println("Ok!")
    System.out.print("Hi!\n"); // == println("Hi!")
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














