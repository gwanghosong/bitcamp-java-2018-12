// 계산 결과는 그 변수의 타입과 같다.
package ch03;

public class Test03 {
  public static void main(String[] args) {
    int a = 5;
    int b = 2;
    System.out.println(a / b); // int와 int의 계산 결과는 int이다.
    
    float f1 = 9876.543f;
    float f2 = 12.34567f;
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(f1 + f2); // float과 float의 계산 결과는 float이다.
    // 따라서 계산 결과가 4바이트 float의 크기를 넘어가면 적절히 반올림하여 나머지 값을 버린다.

    double d1 = 9876.543;
    double d2 = 12.34567;
    System.out.println(d1);
    System.out.println(d2);
    System.out.println(d1 + d2); // double과 double의 계산 결과는 double이다.
    
    // 많이 쓰는 것을 기준으로 함.
    // 따라서 부동소수점은 많이 쓰는 double일 경우 접미사를 붙이지 않음.
    // 정수는 4바이트리터럴 (-21억~21억)을 많이 사용해서 접미사를 붙이지 않음.


  }
}









