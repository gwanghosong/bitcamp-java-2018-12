// 논리 연산자 : &&, ||, ^
package ch04;

public class Test10 {
  public static void main(String[] args) {
    // 모두 트루여야 트루
    System.out.println(true && true);
    System.out.println(true && false);
    
    // 하나만 트루면 트루
    System.out.println(true || false);
    System.out.println(false || false);
    
    // 서로 다를 때만 트루
    System.out.println(true ^ true);
    System.out.println(false ^ false);
    System.out.println(true ^ false);
    
    // !(not) 논리 연산자
    System.out.println(!true);
    System.out.println(!false);

  }
}
















