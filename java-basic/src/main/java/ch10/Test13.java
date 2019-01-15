// 초기화 블록 - 클래스 로딩과 스태틱 블록 실행 과정
package ch10;

class A {
  static int a = 7;
  
  static {
    System.out.println("A.static{}");
    a += B.b; // this.a 는 가능  this.b는 불가능 왜? 다른 클래스잖아!
  }
}

class B {
  static int b = 22;
  
  static {
    System.out.println("B.static{}");
    b += A.a;
  }
}

public class Test13 {
  
  public static void main(String[] args) {
    System.out.println(A.a); // 예상 29 실제 36
    System.out.println(B.b); // 예상 51 실제 29
    
    System.out.println(B.b); // 실제 51
    System.out.println(A.a); // 실제 29
    
    // 순서바꾸면 값이 달라짐 
    // why? 클래스 로딩 순서가 달라지기 때문!
    // 위에 것은 A 클래스가 먼저 로딩
    // 밑에 것은 B 클래스가 먼저 로딩
    // 순서도 생각해야한다.
    
    // 클래식 로딩 절차
    // 1) 클래스를 Method Area에 로딩한다.
    // 2) 스태틱 변수를 만든다.
    // 3) 스태틱 블록을 실행한다.
    //
    
    // 클래스 로딩할 때는?
    // => 1) 클래스 멤버(변수, 메서드)를 사용할 때
    //  2) Calss.forName("클래스명")을 통해 임의로 로딩할 때
    // 단 한 번 로딩된 클래스는 다시 로딩하지 않는다.
    
    // 스태틱 블록의 목적
    // => 클래스 멤버(스태틱 변수, 스태틱 메서드)를 사용하기 전에 유효한 값으로 초기화 시키는 것이다.
    
    // 그러면 왜 스태틱블록과 생성자가 다른것인가?
    // 스태틱블록은 클래스가 로딩될때 실행된다. 
    // 즉 클래스가 로딩될때 딱 한번 실행되고 설정된 그 값으로 딱 한번만 설정되고 역할을 다한다.
    // 생성자로 초기화하는 것은(즉 초기값을 설정하는 것은) 객체에 따라 다른 상태를 주어서
    // 객체마다 다른 특성을 나타내게 할 수 있다.
    // 즉, 파라미터값을 다르게 주거나, 다른 객체를 선택하거나 등 다르게 설정하는 것이 가능하게 한다.
  }
}