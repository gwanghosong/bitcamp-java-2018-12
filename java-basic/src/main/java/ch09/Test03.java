// 클래서 필드가 한계
package ch09;

public class Test03 {
  
  public static void main(String[] args) {
    
    // 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 8 = ?
    
    // Calculator2의 result 변수는 오직 한 개만 존재한다.
    // 따라서 다음과 같이 두 개의 계산식을 동시에 수행할 수 없다.
    
    Calculator2.plus(2); // 식1 계산 2
    Calculator2.plus(6); // 식2 계산 6을 생각하겠지만 실제는 2 + 6
    
    Calculator2.multiple(3); // 식1 2 * 3 을 생각하겠지만 실제는 2 + 6 * 3
    Calculator2.divide(2); // 6 / 2 나머지 계산도 똑같다.
    
    Calculator2.minus(2); // 식1 2 * 3  -2
    Calculator2.plus(8); // 식 2  6 / 2 + 8 =  11
    Calculator2.plus(7); // 식1 = 2 * 3 - 2 + 7 = 11
    
    System.out.println(Calculator2.result);
    // 하나의 계산결과가 나옴
    
    // 동시에 계산식을 수행하는 방법은 없을까?
    // Calculator2는 불가능하다.
    // 오히려 Calculator1은 가능하다. 왜? 계산 결과를 호출하는 쪽에서 관리하기 때문이다.
    //Calculator2는 계산 결과를 클래스에서 자체적으로 관리하기 때문에
    // 사용하기 매우 편하다!
    // 이렇게 클래스의 메서드들이 작업한 결과를 그 클래스에서 관리하면
    // 소스 코드 유지보수가 쉬워진다.
  }
}
















