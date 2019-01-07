// 배열 - 인스턴스와 레퍼런스
package ch03;

public class Test14 {
  public static void main(String[] args) {
    // 값을 담고 있는 메모리 => 인스턴스
    // 인스턴스 주소를 담고 있는 메모리 => 레퍼런스
    int[] arr1 = {101, 102, 103, 104, 105};
    int[] arr2 = {81, 82, 83, 84, 85};
    
    arr2 = arr1; // arr1에 저장된 주소를 arr2에 복사한다.
    // arr2에 저장되었던 배열 주소는 잃어버려 더이상 그 배열을 사용할 수 없다.
    // 이렇게 주소를 잃어버려 사용할 수 없는 메모리를 'garbage'라 부른다.
    System.out.printf("%d, %d\n", arr1[1], arr2[1]);
    
    arr1[1] = 500;
    // arr1이나 arr2 모두 같은 배열 인스턴스를 가리키기 때문에 두 값은 같다.
    System.out.printf("%d, %d\n", arr1[1], arr2[1]);
    
    // System.gc(); garbage collector 실행 메서드
  }
}









