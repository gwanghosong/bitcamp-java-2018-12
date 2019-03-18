// 프로퍼티 값 설정 - 의존 객체 주입
package ch29.d;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

  public static void main(String[] args) {
    
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/d/application-context-02.xml");
    
    System.out.println("---------------------------------------");
    
    BlackBox bb1 = (BlackBox) iocContainer.getBean("bb1");
    Car c1 = (Car) iocContainer.getBean("c1");
    Car c2 = (Car) iocContainer.getBean("c2");
    Car c3 = (Car) iocContainer.getBean("c3");
    
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    
    // 확인!
    // : 객체는 기본으로 한 개만 생성된다.
    // : 기본 빈 생성 정책이 singleton이기 때문에 BlackBox bb1 객체가 한 번만 생성된다.
    // : 만약 scope="prototype"으로 xml에서 BlackBox를 설정한다면 객체가 다 다르게 생성된다.
    System.out.println(bb1 == c1.getBlackBox());
    System.out.println(bb1 == c2.getBlackBox());
    System.out.println(bb1 == c3.getBlackBox());
    
  }
}
