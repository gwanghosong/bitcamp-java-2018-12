// main() 메서드의 파라미터
package ch06;

public class Test13 {
  public static void main(String[] args) {
    System.out.println("--------------------------");
    for (String arg : args) // 배열 또는 컬렉션에 저장된 값이 매 반복마다하나씩 순서대로 읽혀서 변수에 저장.
      System.out.println(arg);
    System.out.println("--------------------------");
  }
}

// for(타입  변수명  :  배열 또는 컬렉션) {
//      반복할문장
// }


// $ java -cp ./bin/main ch06.Test13 args(문자열)
/*
 * 결과
 * ------------------------------------
 * args
 * -------------------------------------
 */


 













