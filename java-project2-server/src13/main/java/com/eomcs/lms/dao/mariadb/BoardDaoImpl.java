// DBMS 적용
package com.eomcs.lms.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao {

  SqlSessionFactory sqlSessionFactory;

  public BoardDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Board> findAll() {
    try (SqlSession sqlsession = sqlSessionFactory.openSession()) {
      return sqlsession.selectList("BoardMapper.findAll");
    }
  }

  public void insert(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      sqlSession.insert("BoardMapper.insert", board);
      sqlSession.commit();
    }
  }

  public Board findByNo(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      Board board = sqlSession.selectOne("BoardMapper.findByNo", no);
      if (board != null) {
        sqlSession.update("BoardMapper.increaseCount", no);
        sqlSession.commit();
      }
      return board;
    }
  }

  public int update(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.update("BoardMapper.update", board);
      sqlSession.commit();
      return count;
    }
  }

  public int delete(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.delete("BoardMapper.delete", no);
      sqlSession.commit();
      return count;
    }
  }
}

