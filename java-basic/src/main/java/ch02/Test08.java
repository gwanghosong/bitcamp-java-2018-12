// 논리 리터럴
package ch02;

public class Test08 {
  public static void main(String[] args) {
    System.out.println(true);
    System.out.println(false);
    
    //System.out.println((boolean)1); // 자바는 정수 값을 true/false로 형변환할 수 없다.
    
    // ''single quote의 리턴값은 2바이트 정수값(UTF-16 CODE) 이다.
    
    if ('가' == 0xac00) { // == 연산의 결과는 true/false 이다.
      System.out.println("맞다!");
    } else {
      System.out.println("아니다!");
    }
    /* 컴파일 오류!
    if (10 - 10) { // c언어에서는 0은 false, 그 외의 모든 수는 true이다. 자바는 아니다!
      System.out.println("참이다!");
    }
    */
  }
}

/*


 */














