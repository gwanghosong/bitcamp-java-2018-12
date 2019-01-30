package design_pattern.decorator.before;

public class Test01 {
  public static void main(String[] args) {

    // 전기차 트럭을 만들어 보자!
    // Hybrid를 상속받고 트럭 기능을 덧 붙인다.
    // 트럭에는 Sedan 기능이 필요 없지만, 
    // 상속은 중간의 특정 기능을 뺄 수 없다.
    // 무조건 상속 받을 수 밖에 없다.
    HybridTruck c1 = new HybridTruck();
    c1.dump();
    
    System.out.println("--------------------------");

    // 만약 Hybrid이면서 Convertible 기능을 갖는 자동차를 만들고 싶다면?
    // Hybrid나 Convertible 둘 중 한 개를 상속 받아서 구현해야 한다.
    // 하위 클래스는 다른 클래스의 기능을 중복해서 개발해야 한다.
    // 다중 상속은 불가능
    // 예를들어보자
    // class T가 있고, 이 클래스는 메서드 m1()을 갖는다.
    // 이를 class A와 class X가 상속받는다.
    // 그리고 메서드 m1()을 오버라이딩한다고 생각해보자.
    // 그리고 class S가 이 class A와 class X를 다중상속한다고 가정해보자.
    // 물론 기본적으로 자바는 다중상속이 안되기 때문에 extends A, X 자체가 컴파일 오류가 난다.
    // 하여튼 가정해보면 class S는 m1() 메서드를 공통적으로 상속받는다.
    // 그렇다면 obj.m1(); 
    // 어떤 m1()을 호출해야 하는가? A클래스에도 m1()이 있고, X 클래스에도 m1()이 있다.
    // 메서드를 호출할 때 수퍼 클래스들 사이에 같은 이름의 메서드가 여러개 있을 경우
    // 그 중 어떤 것을 호출할 지 결정할 수 없기 때문에 다중 상속을 허락하지 않는다.
    //
    HybridConvertible c2 = new HybridConvertible();
    c2.open(true);
    c2.run2();

    // Convertible 자동차에 간단히 물건을 내리는 덤프 기능을 포함한다면?
    // 위의 경우와 마찬가지로 Truck 클래스나 Convertible 클래스 둘 중 하나를 상속받아야하고,
    // 둘 중 하나의 기능을 중복 작성해야 한다.
    // 이것이 상속의 한계다.

  }
}
