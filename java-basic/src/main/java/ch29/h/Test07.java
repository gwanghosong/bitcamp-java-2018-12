// BeanPostProcessor - @Autowired 사용법 : 같은 타입의 객체가 여러개가 있을 경우
package ch29.h;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {

  public static void main(String[] args) {
    
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/h/application-context-07.xml");
    
    // @Qualifier("객체이름")를 사용하여 여러 개의 객체 중에서 어떤 것을 주입할지 지정한다.
    System.out.println("---------------------------------------");
    
    System.out.println(iocContainer.getBean("c1"));
    
    
  }
}
