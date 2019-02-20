// 연습 - 게시물 삭제
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDeleteApp {

  // 다음과 같이 게시물을 삭제하는 프로그램을 작성하라!
  // ----------------------------------------
  // 번호? 1
  // 삭제하였습니다.
  // (또는)
  // 해당 번호의 게시물이 존재하지 않습니다.
  // ----------------------------------------
  public static void main(String[] args) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Scanner keyboard = new Scanner(System.in);
          Statement stmt = con.createStatement()) {

        System.out.printf("번호? ");
        int no = keyboard.nextInt();
        keyboard.nextLine();

        stmt.executeUpdate("delete from x_board where board_id = " + no);

        System.out.println("삭제하였습니다.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
