// 패키지를 탐색하여 빈을 자동 생성하기
package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test03_j {

  public static void main(String[] args) {
    // 빈을 자동으로 생성하고 싶은 클래스에 
    // @Component 등의 애노테이션을 붙인다.
    //
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig03.class);
    
    // 스프링 IoC 컨테이너가 생성한 객체 꺼내기
    Student2 obj1 = (Student2) iocContainer.getBean("student2");
    System.out.println(obj1);
    
    // @Component가 붙지 않는 클래스는 자동으로 객체를 생성하지 않는다.
    Student obj2 = (Student) iocContainer.getBean("student");
    System.out.println(obj2); // 예외발생
    
    System.out.println("실행 완료!");
    
  }
}
