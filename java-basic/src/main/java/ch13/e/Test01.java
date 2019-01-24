package ch13.e;

public class Test01 {

  public static void main(String[] args) {
    B obj = new B();
     // 인스턴스 초기화 과정
    
     // A.v1  |  B.v2  <= 수퍼 클래스부터 해당 클래스까지 인스턴스 필드를 생성한다.
    // 0  |  0  <= 각 필드를 기본값으로 설정한다.
    // 100  | 0  <= A의 초기화 문장 실행
    //  110  |  0  <= A의 인스턴스블록 실행
    // 120  |  0  <= A의 생성자 실행
    // 120  |  200 <== B의 초기화 문장 실행
    // 120  |  210  <== B의 인스턴스 블록 실행
    // 120  |  220  <== B의 생성자실행
    obj.m1(); 
    
    obj.m2(); 
    // 수퍼클래스의 메서드를 수행안하더라도 수퍼클래스부터 싹 다 생성 초기화 블록 생성자실행

    // 결론
    // 수퍼클래스부터 초기화 작업을 실행한다.
  }

}