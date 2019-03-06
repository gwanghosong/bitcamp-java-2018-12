// select 결과 값을 자바 인스턴스에 담는 규칙
package ch26.d;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {

  public static void main(String[] args) throws Exception {
    
    String resource = "ch26/d/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

    // Mybatis의 sqlSession이 "board.select3" SQL문을 실행한 후 
    // 그 결과는 SQL 매퍼 파일에 지정된 대로 ch26.d.Board2 인스턴스에 담아 리턴한다.
    // 그런데 다음과 같이 전혀 다른 타입의 레퍼런스로 받으려하면 오류가 발생한다.
//    Board board = sqlSession.selectOne("board.select3"); // 실행 오류!
    Board2 board = sqlSession.selectOne("board.select3"); // OK!
    System.out.println(board);
    
    // Mybatis에서 select 결과를 자바 인스턴스에 담을 때 규칙
    //: 컬럼 이름과 같은 프로퍼티를 찾아서 값을 담는다.
    //  자바에서 '프로퍼티(property)'란?
    //  setter/getter를 가리키는 용어다.
    // ex) setNo()/getNo()
    // 프로퍼티 이름?
    // setter/getter 이름에서 set/get 이름을 제거한 후, 나머지 이름이다.
    // 단, 첫 알파벳을 소문자로 바꾼 이름이다.
    // ex) setNo()/getNo() => no
    // ex) setCreatedDate()/getCreatedDate() => createdDate
    // 주의!
    // 필드 이름이 프로퍼티 이름이 아니다!
    
    // 결론!
    //: Board2 클래스의 프로퍼티 이름을 보면 no, title, contents, cratedDate, viewCount가 있다.
    // 이 프로퍼티 중에서 컬럼 이름과 같은 프로퍼티는 title, contents이다.
    // Mybatis는 컬럼 이름과 같은 이름을 가진 프로퍼티(title, contents)에 대해서만 결과 값을 넣어 준 것이다.
    // 그래서 Board2 객체를 출력해보면 title과 contents 값만 정상적으로 출력된다.
    //
    // 해결책?
    //: 컬럼 이름과 프로퍼티 명을 같게 하면 되지 않겠는가?
    // DB의 이름 짓는 규칙과 자바의 이름 짓는 규칙은 다르다.
    // DBMS마다 또 이름 짓는 규칙이 다르다.
    // 그래서 자바에서 프로퍼티 이름을 지을 때 특정 DBMS에 종속되게 지어서는 안된다.
    // 자바는 자바의 명명 규칙을 따르고 DB는 DBMS의 명명 규칙을 따르면된다.
    // 그러면 어떻게 하자는 것인가?
    // select할 때 컬럼의 별명을 자바 프로퍼티 이름과 같게하라!
    
  }
}
