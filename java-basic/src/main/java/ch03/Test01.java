// 변수선언과 메모리크기
package ch03;

public class Test01 {
  public static void main(String[] args) {
    // 1바이트 정수 값을 담을 메모리
   byte b1;
   byte b2;
   byte b3;
   
   b1 = -128; // 리터럴 값이 4바이트이지만 메모리에 넣을 수 있따면 허락한다.
   b2 = 127;
   // b2 = 127L; // 단 8바이트 값은 담을 수 있더라도 허락하지 않는다. 컴파일 오류!
   // b3 = 128; // 128은 1바이트에 담을 수 없다.
   // 2바이트 정수 값을 담을 메모리
   short s1;
   short s2;
   short s3;
   
   s1 = -32768;
   s2 = 32767;
   //s2 = 300L; 컴파일 오류!
   //s3 = 32768; 컴파일 오류!
   
   // 4바이트 정수 값을 담을 메모리
   
   int i1;
   int i2;
   int i3;
   
   i1 = -2100000000;
   i2 = 2100000000;
   // i2 = 2100000000L 컴파일 오류! 8바이트 값을 4바이트에 넣을수없음.
   //i3 = 2_200_000_000; 리터럴 표현 오류! 4바이트를 초과하는값을 표현
   
   // 8바이트 정수 값을 담을 메모리
   long l1;
   long l2;
   long l3;
   
   l1 = 922_0000_0000_0000_0000L;
   // l2 = 990_0000_0000_0000_0000L; 8바이트 리터럴 표현 오류
   
   // 4바이트 부동소수점
   float f1;
   float f2;
   
   f1 = 98765.43f;
   f2 = 98765.43456789f; // 유효 자릿수를 넘어가는 경우 짤려서 저장된다.
   // 정수 메모리와 달리 컴파일 오류가 발생하지 않는다.
   // 그래서 더더욱 주의해서 사용해야 한다.
   System.out.println(f1);
   System.out.println(f2);
   
   f1 = 9876.543f;
   f2 = 12.34567f;
   
  
   System.out.println(f1);
   System.out.println(f2);
  
   
   // 8바이트 부동소수점
   double d1;
   double d2;
   
   d1 = 98765.43; // 주의! 8바이트 부동 소수점을 표현할 떄는 f, F 접미사를 제거하라.
   d2 = 98765.43456789;
   System.out.println(d1);
   System.out.println(d2); // 유효자릿수 15자리까지 대부분 짤리지 않고 들어감.
   
   // 논리 값
   boolean bool1;
   boolean bool2;
   boolean bool3;
   
   bool1 = true;
   bool2 = false;
   //bool3 = 1; 컴파일 오류! true false 외의 다른 값은 저장불가능
   
   // 문자의 UTF-16 코드 값
   char c1;
   char c2;
   char c3;
   
   c1 = 44032; // 4바이트 정수 리터럴이더라도 0~65535까지의 값이라면 
   // char 메모리에 저장하는 것을 허락한다. 
   // why? UTF-16의 저장 2byte = 2^16만큼 저장가능하기때문
   c2 = 0xac00;
   c3 = '가'; // '' 의 리턴 값은 2바이트(0~65535) 유니코드 정수 값이다.
   
   System.out.println(c1); // 변수 자체가 char이기 때문에 (char)를 붙이지 않아도 된다.
   System.out.println(c2);
   System.out.println(c3);
  }
}

/*
 
 */















