// 흐름제어문 - if ~ else if ~ else if ~ else
package ch05;

public class Test03 {
  public static void main(String[] args) {
    int age = 70;
   
    if (age < 8)
      System.out.println("유아입니다.");
    else {
      if (age >= 8 && age < 14)
      System.out.println("어린이입니다.");
      else {
        if (age >= 14 && age < 65)
          System.out.println("성인입니다.");
        else
          System.out.println("노인입니다.");
      }
    }
    
    // if ~ else 작성시
    if (age < 8)
      System.out.println("유아입니다.");
    else if (age >= 8 && age < 14)
      System.out.println("어린이입니다.");
    else if (age >= 14 && age < 65)
      System.out.println("성인입니다.");
    else
      System.out.println("노인입니다.");
    
    age = 17;
    if (age > 19) 
      if (age >= 65)
        System.out.println("노인입니다.");
    else
      System.out.println("미성년입니다.");
     // 들여쓰기에 속지마라!
    // else는 가장 가까운 if에 종속!
  }
}
















