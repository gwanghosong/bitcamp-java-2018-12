// 인스턴스 출력하기 - 배열 활용
package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test02_1 {

  public static void main(String[] args) {

    // 다음 세 학생의 성적 정보를 Score.data 파일에 바이너리 형식으로 저장하라.
    // java.io.BufferedOutputStream 클래스를 사용하라.
    // java.io.DataOutputStream 클래스를 사용하라.

    Score[] students = {
        new Score("홍길동", 100, 100, 100),
        new Score("임꺽정", 90, 90, 90),
        new Score("유관순", 80, 80, 80)
    };

    try (DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("Score.data")))) {
      // 먼저 배열개수를 알려주고 출력.
      out.writeInt(students.length);
      // index 필요없고 배열 전체사용시 for (Score s : students) 형태 사용
      for (Score s : students) {
        out.writeUTF(s.getName());
        out.writeInt(s.getKor());
        out.writeInt(s.getEng());
        out.writeInt(s.getMath());
      }

      out.flush();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력 완료!");
  }

}
