// select 결과 값을 Map 객체에 받기
package ch26.d;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {

  public static void main(String[] args) throws Exception {

    String resource = "ch26/d/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

    // select 결과를 맵 객체로 받을 수 있다.
    // 컬럼의 이름이 맵 객체의 key로 사용된다.
    Map<?,?> map = sqlSession.selectOne("board.select6"); 
    System.out.println(map);
    System.out.println(map.get("board_id"));
    System.out.println(map.get("title"));
    System.out.println(map.get("contents"));
    System.out.println(map.get("created_date"));
    System.out.println(map.get("view_count"));
    
    System.out.println("--------------------------------------");

    List<Map<?,?>> list = sqlSession.selectList("board.select7");
    for (Map<?,?> m : list) {
      System.out.println(m);
    }
  }
}