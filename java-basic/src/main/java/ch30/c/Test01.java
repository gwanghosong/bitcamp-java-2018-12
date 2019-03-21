// AOP 사용 후 - AOP 설정 다루기
package ch30.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    
    // ClassNotFoundException
    // : 클래스로더가 클래스패스에서 해당 클래스를 못찾으면 발생.
    //  이 에러가 발생하면 기본적으로 클래스패스와 그 패스(bin폴더)에 해당 클래스가 존재하는지 확인해야한다.
    //  또한 이 에러는 프로그램 실행에 필요한 라이브러리가 없을시 이 에러가 발생할 수 있다.
    
    // AOP(Aspect-Oriened Programming, 관점 지향 프로그래밍) 사용
    // 1) 프로젝트에 의존 라이브러리를 추가한다.
    //      - mvnrepository.com에서 aspectjweaver 라이브러리 검색
    //      - build.gradle에 추가
    //      - '$ gradle eclipse' 실행
    //      - eclipse project refresh
    // 2) Advice 생성
    //    : 메서드를 호출할 때 호출 전/후에 삽입될 기능을 가리킨다.
    //    : 예) MyAdvice
    // 3) Join Point
    //    : Advice가 삽입될 메서드를 가리킨다.
    //    : 예) X.m1() 메서드
    // 4) Pointcut
    //    : Join Point를 가리키는 패턴 정보
    //    즉 Join Point 메서드를 가리키게 하는 정보를 포인트컷이라부른다.
    //    : 예) execute(* ch30.c.X.m1(..))
    // 5) Target Object
    //    : Advice를 삽입할 대상 객체
    //    : 예) X 클래스
    // 6) Aspect
    //    :  어떤 pointcut에 어떤 advice를 삽입할 것인지를 알려주는 설정정보이다.
    //
    // AOP 사용시 이점
    // : AOP는 기존 코드를 손대지 않고 기능을 추가하고 빼는 기술이다.
    // : 패턴을 이용하여 여러 클래스나 메서드에 집단적으로 기능을 추가하거나 뺄 수 있다.
    //
    // AOP 구동 원리
    // : AOP는 "proxy 디자인 패턴"을 사용한다.
    // : 즉 AOP를 설정하면, 
    //  Spring IoC 컨테이너는 point-cut에 지정된 클래스에 대해 Proxy 클래스를 생성한다.
    //  그리고 그 Proxy 객체를 IoC 컨테이너에 저장한다.
    // : IoC 컨테이너에서 point-cut에 지정한 객체를 꺼내면 
    //  원래의 객체 대신 프록시 객체가 리턴된다.
    // : 프록시객체에 대해 메서드를 호출하면 ,
    //  AOP에 설정한 대로 Advice 메서드를 호출한 후 원래의 메서드를 호출한다.
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch30/c/application-context-01.xml");
    
    System.out.println("---------------------------------------");
    
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      System.out.printf("%s ==> %s\n", 
          name, iocContainer.getBean(name).getClass().getName());
    }
    
    System.out.println("---------------------------------------");
    
    X x = (X) iocContainer.getBean("x");
    x.m1();
    
  }
}
