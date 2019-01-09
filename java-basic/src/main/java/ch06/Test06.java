// 메서드 - 가변 파라미터
package ch06;

public class Test06 {
  public static void main(String[] args) {
    int result = plus();
    System.out.println(result);
    
    result = plus(2);
    System.out.println(result);
    
    result = plus(2, 3);
    System.out.println(result);
    
    result = plus(2, 3, 4);
    System.out.println(result);
    
    int[] arr1 = new int[3];
    arr1[0] = 10;
    arr1[1] = 20;
    arr1[2] = 30;
    result = plus(arr1);
    System.out.println(result);
    
    int[] arr2 = new int[] {10, 20, 30};
    result = plus(arr2);
    System.out.println(result);
    
    int[] arr3 = {10, 20, 30, 40};
    result = plus(arr3);
    System.out.println(result);
    
    //int[] arr4;
    //arr4 = {10, 20, 30, 40}; 컴파일 오류
    
    result = plus(new int[] {10, 20, 30});
    System.out.println(result);
    
    // result = plus({100, 200, 300}); 컴파일 오류!
    
 
  }
  
  
  static int plus(int... value) {
    // value는 int[] 값을 갖고 있는 레퍼런스, 주소변수
    int sum = 0; // 메서드 안에 선언된 변수를 local variable이라 함. 파라미터도 로컬변수임.
    for (int i = 0; i < value.length; i++) {
      sum += value[i];
    }
    return sum;
   }
}
















