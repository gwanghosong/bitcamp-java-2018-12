// 키보드로 입력한 값을 받기 - int 값 읽기
package ch03;

public class Test08 {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    System.out.print("a? ");
    int a;
    a = keyboard.nextInt();
    
    System.out.print("b? "); // blocking
    int b = keyboard.nextInt();
    
    System.out.printf("%d * %d = %d\n", a, b, a * b);
    
    
    
  }
}









