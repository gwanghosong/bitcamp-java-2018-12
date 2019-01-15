package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  static final int LENGTH = 10;
  
  public Scanner keyboard;
  Board[] boards = new Board[LENGTH]; // 레퍼런스 배열에 Board인스턴스를 담을 레퍼런스를 LENGTH개 까지 만들어라
  int boardIdx = 0;
  // board[]를 만들때마다 이 세가지가 인스턴스로 만들어짐. 
  
  public void listBoard() {
    
    for (int j = 0; j < this.boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          this.boards[j].no, this.boards[j].contents, 
          this.boards[j].createdDate, this.boards[j].viewCount);
    } // 자동으로 this가 붙어있음 this.boards
  }
  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("내용? ");
    board.contents = keyboard.nextLine();

    board.createdDate = new Date(System.currentTimeMillis()); 

    board.viewCount = 0;

    this.boards[this.boardIdx] = board; 
    this.boardIdx++;
    // int[] arr = new int[100]
    //int i = 0;
    //arr[i++]=100
    //arr[i] = 200
    //arr이 저장된 "주소"를 찾아가서 i번째 배열에 200값을 넣어라
    // this. this. 에 저장된 "주소"를 찾아가서
    // 그 인스턴스필드중 boards를 찾아가서
    // boards에 저장된 "주소"를 찾아가서
    // this.에 저장된 주소를 찾아가서 boardIdx에 저장된 값을 불러와서
    // this.boardIdx 값번째 배열에 
    // board에 저장된 "주소" 값을 넣어라.
    

    System.out.println("저장하였습니다.");
  }

}
