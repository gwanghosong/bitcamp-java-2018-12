// 부동소수점 리터럴 크기
package ch02;

public class Test06 {
  static final float f = 12.375f;
  public static void main(String[] args) {
    System.out.println(0.1f*0.1f); //결과값이 예상과 다름
    // why? 부동소수점을 이진수로 바꿀 때 아주 작은 수의 오차가 있을 수 있다.
    // 그래서 부동소수점을 비교할 때 정수 비교할 때처럼 단순하게 비교하면 
    // 원하는 결과를 얻을 수 없다.
    // 다음 결과를 보라.
    System.out.println(0.1f * 0.1f == 0.01f); // true 예상 => 그러나 false
    
    // 해결방안?
    // 예상한 값과의 오차가 부동소수점에서 인정하는 오차보다 이하의 값이라면 같은 것으로 취급하라!
    System.out.println((0.1f * 0.1f - 0.01f) <= Float.POSITIVE_INFINITY);
    
  }
}

/*
# 리터럴
언더바로 자릿수 표현하기 123_456_789
# 콘솔로 출력하는 명령어
  System.out.println(값);
 */















