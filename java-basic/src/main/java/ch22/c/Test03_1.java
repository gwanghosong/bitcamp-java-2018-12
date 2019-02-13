// primitive data type의 값을 출력하기
// 
package ch22.c;

import java.io.FileOutputStream;

public class Test03_1 {
  public static void main(String[] args) {

    try (FileOutputStream out = new FileOutputStream("data.bin")){

      int value = 0x22334455;

      // 위의 4바이트 value값을 출력하시오!
      // 문제는 그대로 하면 byte크기만큼 맨 뒤의 8비트, 즉 1바이트 크기인 55만 출력함.
      // 따라서 비트이동연산자로 8bit씩 밀어줘서 해결.
      // 4바이트 = 32바이트 
      // 예를 들어 value(0x22334455)가 이런 형태라 하자.
      // aaaaaaaa bbbbbbbb cccccccc dddddddd
      out.write(value >> 24); // aaaaaaaa 출력
      out.write(value >> 16); // bbbbbbbb 출력
      out.write(value >> 8); // cccccccc 출력
      out.write(value); // dddddddd 출력
      
    } catch (Exception e) {
      e.printStackTrace();
    } 

    System.out.println("출력 완료!");
  }
}
