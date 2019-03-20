package ch29.k1;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration : 이 클래스가 스프링 IoC 컨테이너를 설정하는 클래스임을 표시한다.
@Configuration
// Mybatis와 스프링 IoC 컨테이너를 연동하는 설정
// : Mybatis 관련 빈 설정

// Mybatis DAO 구현체 자동 생성하기
// : @MapperScan(DAO 인터페이스가 들어있는 패키지)
@MapperScan("ch29.k1.dao")
public class MybatisConfig {
  
  // Mybatis의 SqlSessionFactory 객체 준비
  // Spring Framework의 IoC 컨테이너의 근원 패키지는
  // org.springframework.beans 와 org.springframework.context이다.
  // BeanFactory 인터페이스는 어떤 타입의 객체도 다룰 수 있는 
  // 고급의 설정 기술(an advanced configuration mechanism)을 제공한다.
  // ApplicationContext는 BeanFactory의 sub-interface이다.
  // 따라서 BeanFactory 인터페이스의 모든 기술을 사용할 수 있을뿐 아니라
  // Spring's AOP 기능과 더 쉽게 통합하게한다. 
  // : Spring MVC 의 internationalization을 사용해서 메시지 자원을 다루는 기능,
  //    이벤트를 발표, 덧붙이는 기능(event poplation),
  //    웹 어플리케이션을 사용하기 위한 어플리케이션 계층별 contexts를 제공해준다.
  // 요약하면, BeanFactory는 configuration framework와 basic functionality를 제공하고,
  // ApplicationContext는 그 기능을 포함하고 거기다 더해서 더 많은 엔터프라이즈별 기능을 제공한다.
  
  /*
  5.15.1 BeanFactory or ApplicationContext?

  Use an ApplicationContext unless you have a good reason for not doing so.

  Because the ApplicationContext includes all functionality of the BeanFactory, 
  it is generally recommended over the BeanFactory, 
  except for a few situations such as in an Applet 
  where memory consumption might be critical 
  and a few extra kilobytes might make a difference. 
  
  However, for most typical enterprise applications and systems, 
  the ApplicationContext is what you will want to use. 
  
  Spring 2.0 and later makes heavy use of the BeanPostProcessor extension point 
  (to effect proxying and so on). 
  
  If you use only a plain BeanFactory, 
  a fair amount of support such as transactions and AOP will not take effect, 
  at least not without some extra steps on your part. 
  
  This situation could be confusing 
  because nothing is actually wrong with the configuration.

  The following table lists features provided 
  by the BeanFactory and ApplicationContext interfaces and implementations.
   */
  @Bean
  public SqlSessionFactory sqlSessionFatory(
      DataSource dataSource, ApplicationContext appCtx) throws Exception {
    
    // SqlSessionFactoryBean 클래스는 FactoryBean 인터페이스를 구현한 클래스이다.
    // 보통 FactoryBean 구현체의 이름을 정의할 때는
    // "생성하는 객체 + FactoryBean" 이름으로 짓는다. 예) CarFactoryBean
    // 그런데 Mybatis-spring 라이브러리에서는
    // SqlSessionFactoryFactoryBean 이라는 이름으로 짓지 않고 
    // 중간에 Factory가 두 번 들어가서 보기 싫다고 한 개를 빼버렸다. 
    // 그래서 SqlSessionFactoryBean이라는 이름이 되었다.
    // 주의하라! 
    // 기존의 이름 관행에 따라 SqlSessionFactoryBean이 SqlSession 객체를 생성한다고 생각하기 쉬운데,
    // 아니다! SqlSessionFactoryBean은 SqlSessionFactory 객체를 생성해준다.
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    
    // DataSource를 주입한다.
    sqlSessionFactoryBean.setDataSource(dataSource);
    
    // SQL 매퍼 파일에서 사용할 클래스에 대한 별명을 지정하기
    // : 별명을 자동으로 생성하고 싶은 클래스들이 들어있는 패키지를 지정한다.
    // : 그러면 패키지 안의 클래스 이름의 앞글자를 소문자로 한 이름을 별명으로 매퍼에서 쓸 수 있다.
    // ex) ch29.k1.vo.Board ==> board
    sqlSessionFactoryBean.setTypeAliasesPackage("ch29.k1.vo");
    
    // SQL 매퍼 파일의 위치를 지정하기
    // : SQL Mapper 파일의 경로는 Resource 객체 배열에 담아 넘긴다.
    // : Resource 객체는 스프링 IoC 컨테이너를 통해 얻을 수 있다.
    sqlSessionFactoryBean.setMapperLocations(
        appCtx.getResources("classpath:ch29/k1/mapper/*.xml"));
    
    return sqlSessionFactoryBean.getObject();
  }
  
}
