// Serialize - 인스턴스 필드의 값 출력 : getter/setter 없는 경우
package ch22.g;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_1 {

  public static void main(String[] args) {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("score1.data"))) {

      Score1 score = new Score1();
      score.name = "홍길동";
      score.kor = 100;
      score.eng = 100;
      score.math = 100;
      score.sum = score.kor + score.eng + score.math;
      score.aver = score.sum / 3f;

      // 인스턴스 출력하기 
      out.writeObject(score);

      // Score1 클래스는 java.io.Serializable을 구현하지 않았기 때문에 
      // writeObject()를 사용할 수 없다.
      System.out.println("출력 완료!");
      
      // getter/setter 없어도 필드 값을 출력하는데 문제 없다.

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
