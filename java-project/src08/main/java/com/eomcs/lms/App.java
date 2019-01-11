package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;
    Lesson[] lessons = new Lesson[LENGTH];

    int lessonidx = 0;

    while (lessonidx < 10) {
      // 가장 먼저해야 할 것 : 입력해야할 것 부터 입력
      System.out.print("명령> ");
      String command = keyboard.nextLine();

      //입력 조건이 참일때만 이 명령을 실행
      if (command.equals("/lesson/add")) {

        Lesson lesson = new Lesson();

        System.out.print("번호? ");
        lesson.no = Integer.parseInt(keyboard.nextLine());

        System.out.print("수업명? ");
        lesson.title = keyboard.nextLine();

        System.out.print("설명? ");
        lesson.contents = keyboard.nextLine();

        System.out.print("시작일? ");
        lesson.startDate = Date.valueOf(keyboard.nextLine());

        System.out.print("종료일? ");
        lesson.endDate = Date.valueOf(keyboard.nextLine());

        System.out.print("총수업시간? ");
        lesson.totalHours = Integer.parseInt(keyboard.nextLine());

        System.out.print("일수업시간? ");
        lesson.dayHours = Integer.parseInt(keyboard.nextLine());

        lessons[lessonidx++] = lesson;
        // 저장하였습니다.로 수정
        System.out.println("저장하였습니다.");

        // if가 아니라면 이 조건이 참일 때 이것을 실행. 즉 분기문!
      } else if (command.equals("/lesson/list")) {
        for (int j = 0; j < lessonidx; j++) {
          System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
              lessons[j].no, lessons[j].title, 
              lessons[j].startDate, lessons[j].endDate, 
              lessons[j].totalHours);
        }
      } else if (command.contentEquals("quit")) {
        System.out.println("안녕!");
        break;
        // 조건에 맞는 것이 없는 경우, 그 밖의 경우 else { 출력문 }
      } else {
        System.out.println("실행할 수 없는 명령입니다");
      }

      System.out.println(); // 빈 줄 출력
    }

    keyboard.close();
  }
}



