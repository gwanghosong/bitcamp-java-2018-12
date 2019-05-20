package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {

  public static Scanner keyboard;
  static final int LENGTH = 10;
  static Board[] boards = new Board[LENGTH]; 
  // Board 객체를 import를 하지않고,
  // 해당 클래스에서 클래스메서드와 클래스필드를 public으로 처리하는 것만으로는 부족한 이유
  // - 왜냐하면 여기에선 클래스 객체 자체가 필요하기 때문이다.
  // 그래서 import를 해줘야 그 클래스 정보를 이용해서 레퍼런스 배열을 만들고 인스턴스를 만들 수 있다.
  // 즉 다른 패키지의 메서드나 변수에 접근할 때는 그 패키지에서 public을 사용해서
  // import 없이 사용가능할지 몰라도
  // 다른 패키지의 클래스 자체를 접근해서 사용할 경우에는 
  // 반드시 import를 해야한다!
  static int boardIdx = 0;

  public static void listBoard() {
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n",
          boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
    }
  }

  public static void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("내용? ");
    board.contents = keyboard.nextLine();

    board.createdDate = new Date(System.currentTimeMillis());

    board.viewCount = 0;

    boards[boardIdx] = board;
    boardIdx++;

    System.out.println("저장하였습니다.");
  }

}
