// 흐름제어문 - 중첩 while과 break
package ch05;

public class Test11 {
  
  public static void main(String[] args) {
    int i = 1;
    do
      System.out.println(i + " ");
    while (i++ < 10);
    System.out.println();
    
    i = 0;
    do {
      System.out.print(++i);
      System.out.print(",");
    } while (i < 10);
    System.out.println();
      
    
  }
}
















