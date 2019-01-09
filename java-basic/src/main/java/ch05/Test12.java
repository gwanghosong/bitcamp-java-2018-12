// 흐름제어문 - for 반복문
package ch05;

public class Test12 {
  
  public static void main(String[] args) {
    // 이렇게써
    for (int i = 1; i <= 10; i++)
      System.out.print(i + " ");
    System.out.println();
    // i = 200; 컴파일오류
    
    int i = 1;
    for (; i<=10; i++)
      System.out.print(i + " ");
    System.out.println();
   
    i = 1;
    for (; i<=10;) {
      System.out.print(i + " ");
      i++;
    }
    System.out.println();
    
    i = 1;
    for (;;) {
      if (i > 10)
        break;
      System.out.print(i + " ");
      i++;
    }
    
    
    System.out.println();
    
    
  }
}
















