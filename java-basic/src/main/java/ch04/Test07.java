// 부동 소수점의 비교 오류
package ch04;

public class Test07 {
  public static void main(String[] args) {
    float f1 = 0.1f;
    float f2 = 0.1f;
    
    System.out.println(f1 * f2 == 0.01f); // false
    
    // 이유?
    System.out.println(f1 * f2); // 0.010000001 결과 값 뒤에 0.000000001 오차 발생!
    // why? 부동소수점을 메모리에 저장할 때 이진수로 바꾸는데 이 때 오차가 발생할 수 있다.
    
    // 해결책?
    // 오차를 제거한 후 비교
    // 다만 계산 결과를 절대값으로 만든 후에 오차 이하의 값인지 비교하라!
    float r = f1 * f2 - 0.01f; 
    System.out.println(((f1 * f2) - 0.01f) <= Float.POSITIVE_INFINITY);
    System.out.println(Math.abs(r) <= Float.POSITIVE_INFINITY); // 이거써
  }
}
















