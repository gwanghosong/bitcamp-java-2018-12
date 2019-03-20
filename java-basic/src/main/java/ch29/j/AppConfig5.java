package ch29.j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

// .properties 파일을 로딩할 때 @PropertySource 애노테이션을 사용한다.
@PropertySource({
  "classpath:ch29/j/jdbc.properties", 
  "classpath:ch29/j/jdbc2.properties"})
public class AppConfig5 {
  
  // 두가지 방법으로 @PropertySource를 통해 로딩된 값을 사용 가능하다.
  // 첫번째 방법은 Environment 타입의 객체를 주입받고,
  // 그 객체에서 해당 이름의 프로퍼티값을 얻어서 사용하는 방법이다.
  // 두번째 방법은 @Value 애노테이션을 사용하는 방법으로,
  // 로딩된 프로퍼티 값 중에서 특정 값만 필드로 주입 받는 것으로
  // @Value("${특정프로퍼티이름}") 프로퍼티타입 설정할프로퍼티명;으로 받아서
  // 설정한프로퍼티명으로 사용하는 것이다.
  
  // @PropertySource를 통해 로딩된 프로퍼티 값을 사용하고 싶다면 
  // Environment 타입의 객체를 주입받아라!
  @Autowired
  Environment env;
  
  // @PropertySource를 통해 로딩된 프로퍼티 값 중에서 특정 값만 필드로 주입 받을 수 있다.
  // : 필드에 @Value 애노테이션을 붙인다.
  // : @Value("${프로퍼티이름}")
  @Value("${jdbc.url}")
  String jdbcUrl;
  
  @Value("${jdbc2.url}")
  String jdbc2Url;
  
  @Bean
  public Car car1() {
    System.out.println("car1() 호출 :");
    System.out.println("  " + env.getProperty("jdbc.url"));
    System.out.println("  " + env.getProperty("jdbc2.url"));
    return new Car();
  }
  
  @Bean
  public Car car2() {
    System.out.println("car2() 호출 :");
    System.out.println("  " + this.jdbcUrl);
    System.out.println("  " + this.jdbc2Url);
    return new Car();
  }
  
  // @Value를 사용할 수 있다면 파라미터에도 적용할 수 있다.
  
  @Bean
  public Car car3(
      @Value("${jdbc.username}") String username,
      @Value("${jdbc.password}") String password) {
    System.out.println("car1() 호출 :");
    System.out.println("  " + username);
    System.out.println("  " + password);
    return new Car();
  }
}
