// 인스턴스 출력하기 - ObjectOutputStream 데코레이터 사용하기
package ch22.e;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test04_1 {

  public static void main(String[] args) {

    ArrayList<Score> students = new ArrayList<>();
    students.add(new Score("홍길동", 100, 100, 100));
    students.add(new Score("임꺽정", 90, 90, 90));
    students.add(new Score("유관순", 80, 80, 80));

    // ObjectOutputStream
    // DataOutputStream 기능을 포함한다.
    // 인스턴스를 바이트 배열로 만들어 출력하는 기능이 있다.
    // 단, java.io.Serializable 인터페이스를 구현한 클래스에 대해서만 가능하다.
    //
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("Score.data")))) {
      // 먼저 배열개수를 알려주고 출력.
      out.writeInt(students.size());
      // index 필요없고 배열 전체사용시 for (Score s : students) 형태 사용
      for (Score s : students) {
        out.writeObject(s);
      }

      out.flush();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력 완료!");
  }

}
