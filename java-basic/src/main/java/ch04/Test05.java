// 연산자 우선 순위
package ch04;

public class Test05 {
  public static void main(String[] args) {
   
    float r = 3.2f + 5 / 2;
    System.out.println(r); // 5.2
    
    float r2 = (3.2f + 5) / 2;
    System.out.println(r2); 
    
    int a = 2;
    int r3 = a++ + a++ * a++;
    System.out.println(r3);
    // r3 = 2 + 3 * 4 ++연산을 먼저수행!
    // = 2+ 12  *연산을 먼저 수행!
    // = 14
   
    
  }
}
















