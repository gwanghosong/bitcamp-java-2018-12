// 메서드 - 메서드 중첩 호출
package ch06;

public class Test05 {
  public static void main(String[] args) {
    int result = plus(2, 3);
    result = plus(result, 4); // result 변수의 값이 넘어가는것.
    result = plus(result, 5);
    System.out.println(result);
    
    result = plus(plus(plus(2, 3), 4), 5); //안쪽부터실행
    System.out.println(result);
    
    System.out.printf("100 + 200 = %d\n", plus(100, 200));
  }
  
  
  static int plus(int a, int b) {
    return a + b;
  }
}
















