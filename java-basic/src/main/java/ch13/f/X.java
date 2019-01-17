package ch13.f;

// 수퍼 클래스를 지정하지 않으면, 무조건 자동으로 java.lang.Object를 상속 받는다.
//
public class X /*extends Object*/{
  private int v1 = 100;
  
  public X(int value) { 
    // super(); // 생략하면 수퍼클래스의 기본 생성자를 호출하는 코드가 자동으로 추가된다.
    // A클래스의 수퍼클래스? Object이다.
    
    this.v1 = value;
    System.out.println("X.X()");
  }
  
  public void m1() {
    System.out.printf("X.v1 = %d\n", this.v1);
  }
}
