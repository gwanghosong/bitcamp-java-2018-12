package design_pattern.decorator.after;

public class Test01 {
  public static void main(String[] args) {
    
    // Decorator 패턴이 적용된 자동차를 만들어 써보자!
    //
    // Decorator 디자인 패턴의 목표:
    // 기능을 플러그인처럼 붙였다 뗐다를 자유롭게 하기 위함이다.
    // 모든 종류의 차가 Car의 하위클래스이므로
    // Car 파라미터 자리에 어떤 차가 오더라도 성립한다.
    // Decorator 하위 클래스들은 기본 생성자가 없다.
    // 따라서 인스턴스를 직접적으로 만들지는 못하지만,
    // 만들어진 인스턴스를 파라미터로 받아와서 만드는 것은 가능하다.
    // 즉, 만들어진 차에 해당 클래스의 기능을 추가해서 만든다는 의미다.
    // 기능추가한다는것이다!
    //
    // 전기차 트럭을 만들어 보자!
    Truck c1 = new Truck();
    Hybrid c2 = new Hybrid(c1);
    c2.run();

    System.out.println("--------------------------");
    // 만약 Hybrid이면서 Convertible 기능을 갖는 자동차를 만들고 싶다면?
    //
    Convertible c3 = new Convertible(c2);
    c3.openRoof(true);
    c3.run();
    
    System.out.println("------------------------------");
    // Hybrid 기능빼고 Sedan에 Convertible 기능을 달자.
    Sedan s1 = new Sedan();
    Convertible c4 = new Convertible(s1);
    c4.openRoof(true);
    c4.run();
    
    System.out.println("----------------------------");
    Dump c5 = new Dump(c4);
    c5.run();
    
    System.out.println("----------------------------");
    Dump c6 = new Dump(c3);
    c6.run();
  }
}
