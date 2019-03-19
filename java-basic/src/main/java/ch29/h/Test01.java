// BeanPostProcessor - 스프링 IoC 컨테이너가 빈을 생성한 후 보고하는 규칙
package ch29.h;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    
    // 근데 왜 생성자가 먼저 실행될까? 의문
    
    // postProcessBeforeInitialization
    //Apply this BeanPostProcessor to the given new bean instance 
    // before any beaninitialization callbacks 
    // (like InitializingBean's afterPropertiesSetor a custom init-method). 
    // The bean will already be populated with property values.
    // The returned bean instance may be a wrapper around the original. 
    // 스프링 IoC 컨테이너는 컨테이너는 빈을 생성하고(to the given new bean instance) 
    // 세터를 모두 호출한 후 (The bean will already be populated with property values.)
    // 이 구현체에게 보고한다. (The returned bean instance may be a wrapper around the original.)
    // 즉 빈을 생성할 때 생성자로 생성하기 때문에 Car 생성자에 있는 system.out.println("Car();")가 먼저 나온다.
    
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/h/application-context-01.xml");
    
    System.out.println("---------------------------------------");
    
//    System.out.println(iocContainer.getBean("c1"));
  }
}
