// 7단계 : 서버 실행 테스트
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonTest {

  // ObjectOutputStream, ObjectInputStream을 static 으로 선언하는 순간
  // 이 변수로 접근할 수 있는 것은 하나의 서버만 가능하다.
  // 여러개의 서버로 접근하기 위해서는 인스턴스 필드로 만들어야 한다.
  // 메서드도 없애줘야 한다.
  // this.는 static에 내장변수가 없다.
  // 또한 static 메서드는 static 메서드나 필드만 접근가능하다.
  // 따라서 static 을 없애줘야 한다.
  

  ObjectOutputStream out;
  ObjectInputStream in;

  public LessonTest(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  public void test() throws Exception {
    add(new Lesson(1, "자바 프로그래밍"));
    add(new Lesson(2, "노드 프로그래밍"));

//    detail(1);
//
//    update(new Lesson(1, "자바스크립트 프로그래밍"));
//
//    detail(1);
//
//    delete(2);

    list();
  }

  private void add(Lesson lesson) throws Exception {
    out.writeUTF("/lesson/add");
    out.flush();
    if (!in.readUTF().equals("OK"))
      return;
    
    out.writeObject(lesson);
    out.flush();

    String status = in.readUTF();

    if (status.equals("OK"))
      System.out.println("데이터 추가 성공!");
    else
      System.out.println("데이터 추가 실패!");
  }

  private void list() throws Exception {
    out.writeUTF("/lesson/list");
    out.flush();
    if (!in.readUTF().equals("OK"))
      return;
    
    String status = in.readUTF();

    if (!status.equals("OK")) {
      System.out.println("데이터 목록 가져오기 실패!");
      return;
    }

    @SuppressWarnings("unchecked")
    List<Lesson> lessons = (List<Lesson>) in.readObject();
    for (Lesson l : lessons) {
      System.out.println(l);
    }
  }

  private void detail(int no) throws Exception {
    out.writeUTF("/lesson/detail");
    out.flush();
    if (!in.readUTF().equals("OK"))
      return;
    
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();

    if (!status.equals("OK")) {
      System.out.println("데이터 목록 가져오기 실패!");
      return;
    }

    Lesson lesson = (Lesson) in.readObject();
    System.out.println(lesson);
  }

  private void update(Lesson lesson) throws Exception {
    out.writeUTF("/lesson/update");
    out.flush();
    if (!in.readUTF().equals("OK"))
      return;
    
    out.writeObject(lesson);
    out.flush();

    String status = in.readUTF();

    if (status.equals("OK"))
      System.out.println("데이터 변경 성공!");
    else
      System.out.println("데이터 변경 실패!");
  }

  private void delete(int no) throws Exception {
    out.writeUTF("/lesson/delete");
    out.flush();
    if (!in.readUTF().equals("OK"))
      return;
    
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();

    if (status.equals("OK"))
      System.out.println("데이터 삭제 성공!");
    else
      System.out.println("데이터 삭제 실패!");
  }
}
