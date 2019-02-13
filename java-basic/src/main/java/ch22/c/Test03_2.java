// primitive data type의 값을 출력하는 것을 도와주는 데코레이터 사용하기
// 
package ch22.c;

import java.io.FileOutputStream;

public class Test03_2 {
  public static void main(String[] args) {

    try (FileOutputStream out = new FileOutputStream("data.bin");
        DataOutputStream out2 = new DataOutputStream(out)) {

      int no = 100;
      String name = "ABC가각간";
      int age = 20;

      // DataOutputStream은 바이너리 형태로 출력한다.
      out2.writeInt(no); // 00 00 00 64
      out2.writeUTF(name); // 41, 42, 43, EA B0 80, EA B0 81, EA B0 84
      out2.writeInt(age); // 00 00 00 14

    } catch (Exception e) {
      e.printStackTrace();
    } 

    System.out.println("출력 완료!");
  }
}
