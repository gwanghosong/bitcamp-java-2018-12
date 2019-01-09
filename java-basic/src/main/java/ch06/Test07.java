// 메서드 - 가변 파라미터 vs 배열 레퍼런스
package ch06;

public class Test07 {
  public static void main(String[] args) {
    plus1();
    plus1(10);
    plus1(10, 20);
    
    plus2(new int[] {});
    plus2(new int[] {10});
    plus2(new int[] {10, 20});
 
  }
  
  
  static int plus1(int... value) {
    int sum = 0; 
    for (int i = 0; i < value.length; i++) {
      sum += value[i];
    }
    return sum;
    }
   
  
  static int plus2(int[] value) {
    int sum = 0; 
    for (int i = 0; i < value.length; i++) {
      sum += value[i];
    }
    return sum;
    }
  
}
















