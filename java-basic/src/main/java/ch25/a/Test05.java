// java.sql.Connection 객체
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test05 {

  public static void main(String[] args) {
    // DriverManager.getConnection()을 호출하면
    // org.mariadb.jdbc.Driver.connect()를 호출한다.
    //
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS에 연결됨!");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
