// 연습 - 게시물 변경
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardUpdateApp {

  // 다음과 같이 게시물을 변경하는 프로그램을 작성하라!
  // ----------------------------------------
  // 번호? 1
  // 제목? xxx
  // 내용? xxxxx
  // 변경하였습니다.
  // (또는) 해당 번호의 게시물이 존재하지 않습니다.
  // ----------------------------------------
  public static void main(String[] args) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Scanner keyboard = new Scanner(System.in);
          Statement stmt = con.createStatement()) {

        System.out.printf("번호? ");
        int no = keyboard.nextInt();
        keyboard.nextLine();
        System.out.printf("제목? ");
        String title = keyboard.nextLine();
        System.out.printf("내용? ");
        String contents = keyboard.nextLine();


        stmt.executeUpdate("update x_board set title = '" 
            + title + "', contents = '" 
            + contents + "' where board_id = " + no);

        // sql 문장 삽입공백!
        // 사용자가 입력한 값을 가지고 sql문을 만드려고하면 
        // 그 값을 이용해서 해킹할 가능성이 있다.
        // ex) title 사이에 넣기

        System.out.println("변경하였습니다.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
