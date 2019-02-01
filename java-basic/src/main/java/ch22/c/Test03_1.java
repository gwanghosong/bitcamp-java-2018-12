// primitive data type의 값을 출력하기
// 
package ch22.c;

import java.io.FileOutputStream;

public class Test03_1 {
  public static void main(String[] args) {

    try (FileOutputStream out = new FileOutputStream("data.bin")){

      int value = 0x22334455;

      // 위의 4바이트 value값을 출력하시오!
      // 문제는 그대로 하면 byte크기만큼 즉 55만 출력함.
      // 따라서 비트이동연산자로 해결
      out.write(value >> 24);
      out.write(value >> 16);
      out.write(value >> 8);
      out.write(value);

    } catch (Exception e) {
      e.printStackTrace();
    } 

    System.out.println("출력 완료!");
  }
}
