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
    
    // @Autowired 애노테이션
    // 빈 객체를 생성하고 나서 의존 객체를 주입 받아야 한다면,
    // 또는 새롭게 생성하는 것이 아니라 기존에 스프링 IoC 컨테이너에 보관한 객체를 사용하고 싶다면,
    // constructor, field, setter method or config method 
    // 생성자, 인스턴스필드(프로퍼티), 세터 메서드 or config메서드에 @Autowired를 붙여라.
    // 인스턴스 필드(프로퍼티)에 붙일 때 알아서 주입해주기 때문에 세터/게터가 있을 필요가 없다.
    // 세터 메서드에 붙여주면, 그 필요로 하는 객체가 생성되면 세터 메서드를 호출하여 그 객체를 주입해준다.
    // 생성자에 붙여주면, 그 필요로 하는 객체가 생성되면 그 생성자의 argument(실제 전달되는 값)으로
    // 그 객체를 주입해준다.
    // @Autowired 애노테이션의 기본 값은 true이기 때문에 의존 객체가 주입되지 않는다면
    // NoSuchBeanDefinitionException 에러가 뜬다. 이것을 피하고 싶으면 false로 설정하라.
    // : @Autowired(required=false)
    // @Autowired 애노테이션은 주입받는 객체를 타입으로 구분하기 때문에 
    // IoC 컨테이너에 같은 타입의 빈이 여러개 있으면 스프링 프레임워크는
    // NoUniqueBeanDefinitionException 에러를 던진다.
    // 이것을 피하고 싶다면 @Quailfier 애노테이션을 사용해 어떤 객체인지 지정하면된다.
    // : @Qualifier("객체이름")
    
    // 파라미터(parameter) : 매개 변수(formal parameter),
    //                  int over(int a, int b) {...}에서 int a, int b처럼
    //                       함수의 전달되는 값을 넘겨 받는데 쓰이는 변수.
    // 아규먼트(argument) : 실제 전달인자(actual argument)
    //                      실제 over(10, 30);에서 10, 30처럼
    //                      의미있는 실제 값을 전달하는 인자.
    
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/h/application-context-01.xml");
    
    System.out.println("---------------------------------------");
    
//    System.out.println(iocContainer.getBean("c1"));
  }
}
