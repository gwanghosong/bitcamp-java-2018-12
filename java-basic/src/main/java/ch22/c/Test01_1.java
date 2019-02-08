// 버퍼사용 - 사용 전
// 
package ch22.c;

import java.io.FileInputStream;

public class Test01_1 {
  public static void main(String[] args) {

    try {
    FileInputStream in = new FileInputStream("jls11.pdf");
    
    System.out.println("데이터 읽는 중...");
    
    long start = System.currentTimeMillis();
    
    int b;
    // 해석
    // b에 in.read()로 읽은 바이트를 집어 넣는데
    // 그 값이 1과 다르면 참이므로 계속 실행
    // 그러다가 -1, 즉 읽을 값이 없을 때 리턴되는 -1값이 되면 종료.
    while ((b = in.read()) != -1) {
    }
    
    
    long end = System.currentTimeMillis();
    System.out.println(end - start);
    
    in.close();
    
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("출력 완료!");
  }
}
