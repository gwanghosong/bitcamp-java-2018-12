// 흐름제어문 - if ~ else
package ch05;

public class Test02 {
  public static void main(String[] args) {
    int age = 22;
   
    if (age >= 20)
      System.out.println("성인입니다.");
    else
      System.out.println("미성년입니다.");
    
    if (age >= 20) {
      System.out.println("-----------------------");
      System.out.println("성인입니다.");
    }
    else {
      System.out.println("-----------------------");
      System.out.println("미성년입니다.");
    }
    // K & R 형식
    if (age >= 20) {
      System.out.println("-----------------------");
      System.out.println("성인입니다.");
    } else {
      System.out.println("-----------------------");
      System.out.println("미성년입니다.");
    }
    
    // if문만 작성 가능 but else문만 작성 불가능!
    /*else
      System.out.println("ok?");
    */
  }
}
















