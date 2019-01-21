// 추상 메서드의 효용성 - 서브 클래스에서 구현하도록 강제하는 효과가 있다.
package ch17.e;

public class Test01 {

  public static void main(String[] args) {

    int[] values = {23, 7, 12, 15, 9, 2, 22 , 8, 11, 25, 13, 5};
    int[] values2 = {23, 7, 12, 15, 9, 2, 22 , 8, 11, 25, 13, 5};
    int[] values3 = {23, 7, 12, 15, 9, 2, 22 , 8, 11, 25, 13, 5};

    // 정렬 객체를 사용하는 방법을 통일하면 사용하기가 쉬워진다.
    // 어떻게?
    // 두 클래스를 같은 부모의 자식 클래스가 되게 하라.
    // 같은 부모라는 뜻은 같은 메서드를 같는다는 의미다.
    // 즉 메서드가 같으니 사용법도 같다.
    // 
    Sorter s1;
    Sorter s2; 

    // 두 개의 정렬 객체가 같은 타입이기 때문에 사용하기 편하다.
    // 언제든 다른 객체로 교체할 수 있어 유연하다.
    display(new BubbleSort(), values);
    display(new QuickSort(), values2);
    
    // 이제 MergerSort는 Sorter의 추상 메서드인 sort()를 구현했다.
    // 정상적으로 동작할 것이다.
    
    display(new MergeSort(), values3);
    
  }

  // 정렬을 수행하는 객체와 값을 주면
  // 그값을 출력하는 메서드 이다.
  static void display(Sorter sorter, int[] values) {

    // 정렬 객체의 클래스가 뭔지 상관없다.
    // 그 클래스를 사용할 때는 공통 분모가 되는 
    // 수퍼 클래스의 메서드를 호출한다.
    // 오버라이딩한 경우 오버라이딩한 메서드를 호출한다.
    sorter.sort(values);

    // 정렬된 값을 출력한다.
    for (int value : values) {
      System.out.print(value + ",");
    }
    System.out.println();
  }
}
