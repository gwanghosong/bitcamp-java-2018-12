package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.lms.handler.BoardHandler;

public class App {
  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    BoardHandler Board1 = new BoardHandler();
    Board1.keyboard = keyboard; //인스턴스에 만든 키보드에 이 클래스의 키보드를 꼽아준다.
    BoardHandler Board2 = new BoardHandler();
    Board2.keyboard = keyboard; 
    LessonHandler Lesson1 = new LessonHandler();
    Lesson1.keyboard = keyboard;
    MemberHandler Member1 = new MemberHandler();
    Member1.keyboard = keyboard;
    

    while (true) {
      String command = prompt(); //while문안에서만 실행할 변수

      if (command.equals("/lesson/add")) {
        Lesson1.addLesson();
      } else if (command.equals("/lesson/list")) {
        Lesson1.listLesson();
      } else if (command.equals("/member/add")) {
        Member1.addMember();
      } else if (command.equals("/member/list")) {
        Member1.listMember();
      } else if (command.equals("/board/add")) {
        Board1.addBoard(); // 같은 addBoard 메소드인데 이 메소드가 사용할 메모리를 앞에 보여줌.
      } else if (command.equals("/board/list")) {
        Board1.listBoard();
      } else if (command.equals("/board2/add")) {
        Board2.addBoard();
      } else if (command.equals("/board2/list")) {
        Board2.listBoard();
      }else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }
  static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}

