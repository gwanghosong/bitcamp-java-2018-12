package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;

    Board[] boards = new Board[LENGTH];

    int i = 0;
    while (i < LENGTH) {

      System.out.print("명령> ");
      String command = keyboard.nextLine();

      if (command.equals("/board/add")) {
        Board board = new Board();

        System.out.print("번호? ");
        board.no = Integer.parseInt(keyboard.nextLine());

        System.out.print("내용? ");
        board.contents = keyboard.nextLine();

        board.createdDate = new Date(System.currentTimeMillis()); 

        board.viewCount = 0;

        boards[i++] = board;

        System.out.println("저장하였습니다.");
      } else if (command.equals("/board/list")) {
        for (int j = 0; j < i; j++) {
          System.out.printf("%3d, %-20s, %s, %d\n", 
              boards[j].no, boards[j].contents, 
              boards[j].createdDate, boards[j].viewCount);
        }
      }

      System.out.println();
    }

    keyboard.close();
  }
}
