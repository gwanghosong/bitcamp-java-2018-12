package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  //없어진것static final int LENGTH = 10;
  Scanner keyboard;
  LessonList list; // LessonList클래스설계도에 따라 생성된 인스턴스들의 주소를 담는
  // 레퍼런스변수 list를 생성한다.
  //없어진것Lesson[] lessons = new Lesson[LENGTH];
  //없어진것int lessonIdx = 0;

  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    list = new LessonList(); 
  } // keyboard 파라미터를 가진 생성자
  // 이 생성자에 파라미터값 keyboard를 이용하여 만들면
  // LessonHandler 클래스에 만드는 인스턴스에 파라미터로 입력된 그 키보드입력장치를
  // 이 클래스의 keyboard 인스턴스필드에 넣어주고
  // 그 다음 LessonList 클래스설계도에 따라 생성된 인스턴스 주소를 담는 레퍼런스 변수인 list
  // 이 list에 새롭게 LessonList 클래스 설계도에 따라 작성된 인스턴스들의 주소를 담아서 저장한다.
  

  /* public void listLesson() {
    for (int j = 0; j < this.lessonIdx; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n",
          this.lessons[j].getNo(), this.lessons[j].getTitle(), 
          this.lessons[j].getStartDate(),
          this.lessons[j].getEndDate(), this.lessons[j].getTotalHours());
    }
  }
  */
  public void listLesson() {
    Lesson[] lessons = list.toArray();
    for (Lesson lesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n",
          lesson.getNo(), lesson.getTitle(),
           lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
  }
  // return 값이 없는 인스턴스 메서드 , 파라미터 값이 없는 default 값을 넣은 listlesson 인스턴스메서드
  // Lesson클래스타입으로 담길 레퍼런스 변수 lessons에
  // list에 저장된 주소의 인스턴스를 찾아가서 그 값으로 toArray메서드를 실행한 값을 리턴받아서 저장한다는 것인데
  // 기본적으로 list는 LessonList클래스 설계도에 따라 생성했기 때문에
  // list와 size값이 있기 때문에 실행 가능하다. 
  // 그 값에 따라 배열을 생성하고 그 주소를 lessons레퍼런스 주소에 저장한다.
  // for (데이터타입 대입할변수이름: 인스턴스이름) 은 인스턴스이름에 저장된 인스턴스필드들을 차근차근
  // 식에 대입해서 반복한다.
  // Lesson클래스타입의 식의 lesson이란 곳에 lessons 인스턴스의 필드 값들을 대입하여 반복한다.
  // lessons를 lesson에 대입한다는 것은 즉 lessons의 레퍼런스 주소를 lesson에 대입한다는 것으로
  // lessons의 레퍼런스 주소마다 저장된 인스턴스 필드값들을 호출하는 명령을 실행해서 값을 반복적으로
  // 호출해서 값을 만든다는 것이다.

  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("수업명? ");
    lesson.setTitle(this.keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(this.keyboard.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(this.keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(this.keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(this.keyboard.nextLine()));

    /*
    // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
    this.lessons[this.lessonIdx] = lesson;
    this.lessonIdx++;
    */
    list.add(lesson);
    // list 레퍼런스변수의 주소에 저장된 인스턴스를 찾아가서
    // add라는 인스턴스 메서드를 실행하는데 그 값을 파라미터 lesson으로넣는다.
    // 즉 배열의길이 size와 list.length를 lesson 레퍼런스와 연결된 인스턴스에 찾아가서 
    // 그 값을 넣고 대입값을 출력한다.

    System.out.println("저장하였습니다.");
  }
}
