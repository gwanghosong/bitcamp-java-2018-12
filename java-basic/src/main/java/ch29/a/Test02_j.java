// 빈 생성과 꺼내기 : 자바 클래스 이용
package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test02_j {

  public static void main(String[] args) {
    // 객체 생성
    // @Bean public Student b1() { return new Student(); }
    //
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig02.class); // .class : 스태틱변수
    
    // 스프링 IoC 컨테이너가 생성한 객체 꺼내기
    Student b1 = (Student) iocContainer.getBean("b1");
    System.out.println(b1);
    
    // 존재하지 않는 객체(b2 bean)를 꺼내려하면 예외가 발생한다.
    Student b2 = (Student) iocContainer.getBean("b2");
    System.out.println(b2); // 예외발생
    
    System.out.println("실행 완료!");
    
  }
}
