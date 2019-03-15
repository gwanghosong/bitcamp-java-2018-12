package com.eomcs.lms;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.mybatis.DaoFactory;
import com.eomcs.mybatis.SqlSessionFactoryProxy;
import com.eomcs.mybatis.TransactionManager;

@ComponentScan(basePackages= "com.eomcs.lms") // 배열의 값이 한개이기때문에 중괄호를 생략했다.
public class AppConfig {
  // Spring 프레임워크는 순서에 상관없이 재귀호출을 통해서 필요한 순서대로 알아서 객체를 만들어준다.
  // 메서드의 이름으로 객체를 만들기 때문에 메서드의 이름은 명사형태(객체 이름)로 만들어준다.
  
  // BoardDao 객체를 만들어 주는 메서드
  @Bean
  public BoardDao boardDao(DaoFactory daoFactory) {
    return daoFactory.create(BoardDao.class);
  }
  // MemberDao 객체를 만들어 주는 메서드
  @Bean
  public MemberDao memberDao(DaoFactory daoFactory) {
    return daoFactory.create(MemberDao.class);
  }
  // LessonDao 객체를 만들어 주는 메서드
  @Bean
  public LessonDao lessonDao(DaoFactory daoFactory) {
    return daoFactory.create(LessonDao.class);
  }
  // PhotoBoardDao 객체를 만들어 주는 메서드
  @Bean
  public PhotoBoardDao photoBoardDao(DaoFactory daoFactory) {
    return daoFactory.create(PhotoBoardDao.class);
  }
  // PhotoFileDao 객체를 만들어 주는 메서드
  @Bean
  public PhotoFileDao photoFileDao(DaoFactory daoFactory) {
    return daoFactory.create(PhotoFileDao.class);
  }
  
  // SqlSessionFactoryProxy 객체를 만들어 주는 메서드
  @Bean
  public SqlSessionFactoryProxy sqlSessionFactoryProxy() throws Exception {
    return new SqlSessionFactoryProxy(
        new SqlSessionFactoryBuilder().build(
            Resources.getResourceAsStream(
        "com/eomcs/lms/conf/mybatis-config.xml")));
  }
  
  // TransactionManager 객체를 만들어 주는 메서드
  @Bean
  public TransactionManager transactionManager(SqlSessionFactoryProxy sqlSessionFactoryProxy) {
    return new TransactionManager(sqlSessionFactoryProxy);
  }
  
  // DaoFactory 객체를 만들어 주는 메서드
  // : Dao구현체를 생성함.
  @Bean
  public DaoFactory daoFactory(SqlSessionFactoryProxy sqlSessionFactoryProxy) {
    return new DaoFactory(sqlSessionFactoryProxy);
  }

}
