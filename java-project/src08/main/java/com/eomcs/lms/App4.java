package com.eomcs.lms;
//이렇게 통합
import java.sql.Date;
import java.util.Scanner;

public class App4 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;
    Lesson[] lessons = new Lesson[LENGTH];
    Member[] members = new Member[LENGTH];
    Board[] boards = new Board[LENGTH];

    int lessonidx = 0;
    int membersidx = 0;
    int boardidx = 0;

    while (true) {
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

      } else if (command.equals("/member/add")) {
        Member member = new Member();

        System.out.print("번호? ");
        member.no = Integer.parseInt(keyboard.nextLine());

        System.out.print("이름? ");
        member.name = keyboard.nextLine();

        System.out.print("이메일? ");
        member.email = keyboard.nextLine();

        System.out.print("암호? ");
        member.password = keyboard.nextLine();

        System.out.print("사진? ");
        member.photo = keyboard.nextLine();

        System.out.print("전화? ");
        member.tel = keyboard.nextLine();

        member.registeredDate = new Date(System.currentTimeMillis()); 

        members[membersidx++] = member;

        System.out.println("저장하였습니다.");

      } else if (command.equals("/lesson/list")) {
        for (int j = 0; j < membersidx; j++) {
          System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
              members[j].no, members[j].name, 
              members[j].email, members[j].tel, 
              members[j].registeredDate);
        }

      } else if (command.equals("/board/add")) {
        Board board = new Board();

        System.out.print("번호? ");
        board.no = Integer.parseInt(keyboard.nextLine());

        System.out.print("내용? ");
        board.contents = keyboard.nextLine();

        board.createdDate = new Date(System.currentTimeMillis()); 

        board.viewCount = 0;

        boards[boardidx++] = board;

        System.out.println("저장하였습니다.");
      } else if (command.equals("/board/list")) {
        for (int j = 0; j < boardidx; j++) {
          System.out.printf("%3d, %-20s, %s, %d\n", 
              boards[j].no, boards[j].contents, 
              boards[j].createdDate, boards[j].viewCount);
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



