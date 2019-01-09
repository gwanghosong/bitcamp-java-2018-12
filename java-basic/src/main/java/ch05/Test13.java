// 흐름제어문 - for 반복문
package ch05;

public class Test13 {
  
  public static void main(String[] args) {
    for (int i = 1, j = 3, k = 5; i <= 10; i++, j--, k += 2)
      System.out.printf("(%d,%d,%d) ", i, j, k);
    System.out.println();
    
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
       }
      System.out.println();
    }
    System.out.println("-----------------------");
    
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
        if (j == 5)
          break;
       }
      System.out.println();
    }
    System.out.println("-----------------------");
    
    loop1:
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
        if (j == 5)
          break loop1;
       }
      System.out.println();
    }
    System.out.println("-----------------------");
    
    loop1: {
      for (int i = 1; i <= 10; i++) {
        for (int j = 1; j <= i; j++) {
          System.out.print(j + " ");
          if (j == 5)
            break loop1;
         }
        System.out.println();
      }
      System.out.println("-----------------------");
    }
    
    
      for (int i = 1; i <= 10; i++) {
        for (int j = 1; j <= i; j++) {
          if (j % 2 == 0)
            continue; // 다음 줄로 가지 않고 변수증가문으로 이동
          System.out.print(j + " ");
         }
        System.out.println();
      }
      System.out.println("-----------------------");
    
  }
}
















