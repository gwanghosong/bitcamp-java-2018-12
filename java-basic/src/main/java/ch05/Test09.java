// 흐름제어문 - while과 break, continue
package ch05;

public class Test09 {
  
  public static void main(String[] args) {
    int a = 1;
    while (a <= 10) {
      System.out.print(a + " ");
      a++;
      
      if (a > 5)
        break; //반복문을 멈추고 나간다.
    }
    
    System.out.println();
    a = 1;
    
    while (a <= 10) {
      if (a % 2 == 0) {
        a++;
        continue; //짝수이면 다음 코드 실행하지않고 조건검사로 바로 올라감.
      }
      
      System.out.print(a + " ");
      a++;
    }
    
   
  }
}
















