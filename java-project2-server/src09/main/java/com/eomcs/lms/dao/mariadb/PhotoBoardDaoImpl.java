package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDaoImpl implements PhotoBoardDao{
  Connection con;

  public PhotoBoardDaoImpl(Connection con) {
    this.con = con;
  }
  @Override
  public List<PhotoBoard> findAll() {
    try (PreparedStatement stmt = con.prepareStatement(
        "select photo_id, lesson_id, titl, cdt, vw_cnt"
            + " from lms_photo"
            + " order by photo_id desc")) {

      try (ResultSet rs = stmt.executeQuery()) {

        ArrayList<PhotoBoard> list = new ArrayList<>();
        while (rs.next()) {
          PhotoBoard board = new PhotoBoard();
          board.setNo(rs.getInt("photo_id"));
          board.setLessonNo(rs.getInt("lesson_id"));
          board.setTitle(rs.getString("titl"));
          board.setCreatedDate(rs.getDate("cdt"));
          board.setViewCount(rs.getInt("vw_cnt"));

          list.add(board);
        }
        return list;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void insert(PhotoBoard photoBoard) {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into lms_photo(titl, lesson_id) values(?, ?)",
        Statement.RETURN_GENERATED_KEYS)) {

      stmt.setString(1, photoBoard.getTitle());
      stmt.setInt(2, photoBoard.getLessonNo());
      stmt.executeUpdate();
      
      try (ResultSet rs = stmt.getGeneratedKeys()) {
        rs.next();
        photoBoard.setNo(rs.getInt(1));
      }
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public PhotoBoard findByNo(int no) {
    try {
      // 조회수 증가시키기
      try (PreparedStatement stmt = con.prepareStatement(
          "update lms_photo set vw_cnt = vw_cnt + 1 where photo_id = ?")) {
        stmt.setInt(1, no);
        stmt.executeUpdate();
      }

      try (PreparedStatement stmt = con.prepareStatement(
          " select photo_id, lesson_id, titl, cdt, vw_cnt from lms_photo where photo_id = ?")) {

        stmt.setInt(1, no);

        try (ResultSet rs = stmt.executeQuery()) {

          if (rs.next()) {
            PhotoBoard board = new PhotoBoard();
            board.setNo(rs.getInt("photo_id"));
            board.setNo(rs.getInt("lesson_id"));
            board.setTitle(rs.getString("titl"));
            board.setCreatedDate(rs.getDate("cdt"));
            board.setViewCount(rs.getInt("vw_cnt"));
            return board;
          } else {
            return null;
          }
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int update(PhotoBoard photoBoard) {
    try (PreparedStatement stmt = con.prepareStatement(
        "update lms_photo set titl = ? where photo_id = ?")) {

      stmt.setString(1, photoBoard.getTitle());
      stmt.setInt(2, photoBoard.getNo());

      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement stmt = con.prepareStatement(
        " delete from lms_photo where photo_id = ?")) {

      stmt.setInt(1, no);

      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
