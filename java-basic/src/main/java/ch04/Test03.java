// 연산의 결과는 피연산자의 데이터 타입과 같다.
package ch04;

public class Test03 {
  public static void main(String[] args) {
    // int와 int의 연산 결과는 int이다.
    float r = 5 / 2; // r 변수에 값을 저장하기 전에 이미 결과는 2이다. 
    // 1. 연산을 수행하고, 2. r 변수값에 저장 3. 따라서 2.0이나옴.
    System.out.println(r);
    
    // 해결책!
    // 두 개의 정수 값을 제대로 float으로 계산하고 싶다면 형변환 하라.
    // 형변환? 다른 타입의 메모리를 임시로 만들어 값을 넣는 방법.
    // type conversion을  타입 캐스팅(type casting) 이라고도 부른다.
    // 주의! 형변환이라고 해서 원래 변수나 값의 타입을 다른 타입으로 변경하는 것이 아니다.
    // 문법? (새로 만들 메모리의 타입) 값;
    float r2 = (float)5 / (float)2;
    // float 타입의 임시 메모리가 생성된 후 정수 5가 저장된다.
    // float 타입의 임시 메모리가 생성된 후 정수 2가 저장된다.
    // 임시 생성된 두 개의 float 메모리 값을 계산한다.
    // 당연히 그 결과는 float 타입이다.
    System.out.println(r2);
    
    // 타입이 다른 경우 연산을 수행할 수 없다.
    // 반드시 계산을 수행하는 피연산자의 타입이 같아야 한다.
    // 다르다면 내부적으로 두 피연산자의 값을 같은 타입으로 만든 후에 계산을 수행한다.
    // 즉, 개발자가 지시하지 않아도 내부적으로 같은 타입으로 만드는 것을 
    // '암시적 형변환(implicit type conversion(casting))' 이라고 한다.
    float r3 = 5 / (float)2;
    System.out.println(r3);
    
    byte b1 = 20;
    byte b2 = 30;
    // byte b3 = b1 + b2; // 컴파일오류
    int x1 = b1 + b2; // OK!
    
    short s1 = 20;
    short s2 = 30;
    // short s3 = s1 + s2; // 컴파일 오류 
    int x2 = s1 + s2; // OK!
    
    char c1 = 20;
    char c2 = 30;
    // char c3 = c1 + c2; // 컴파일 오류
    int x3 = c1 + c2; // OK!
    
    int i1 = 100;
    float f1 = 200.5f;
    // int i2 = i1 + f1; // 컴파일 오류!
    float f2 = i1 + f1;
    
    float f3 = 9876.543f;
    float f4 = 12.34567f;
    double d1 = f3 + f4;
    // float과 float의 계산 결과는 float이다.
    // d1 저장되기 전에 자릿수(7자리)를 초과한 값은 오차 값으로 저장된다.
    // 그래서 d1을 출력하면 오차가 있는 값이 출력되는 것이다.
    System.out.println(d1);
    
    //해결책!
    // 계산하기 전에 더 큰 타입으로 형변환하라.
    double d2 = (double)f3 + (double)f4;
    // => 그런데 출력 결과를 보면 예상 결과와 다르게 나온다.
    // 이유? float을 double로 형변환 할 때 오차가 이미 생긴다.
    // 부동소수점을 다룰 때 생기는 오차이다.개발자가 제어할 수 없다.
    System.out.println(d2);
    
    // 해결책?
    // 부동소수점의 경우 계산 결과가 float 초과할 것같으면 애초에 double에 저장하라
    double d7 = 9876.543;
    double d8 = 12.34567;
    double d9 = d7 + d8;
    System.out.println(d9);
    
    
   
  }
}
















