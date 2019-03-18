// 스프링 IoC 컨테이너 사용
package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    // IoC(Inversion of Control) 컨테이너(Container)
    // : bean Container 라고도 부른다.
    //  인스턴스의 생성과 관리를 담당한다.
    //  각 객체가 의존하는 객체(dependency)를 주입한다.
    //  "의존 객체 주입(dependency injection; DI)"이라 부른다.
    //  그래서 "DI 컨테이너"라고도 부른다.
    //
    // IoC (Inversion of Control)
    // => 제어의 역전, 제어의 역행, 역제어 등으로 표현한다.
    //
    // IoC의 대표적인 예:
    // 1) DI(Dependency Injection)
    //     - 의존 객체 주입 
    //     - 사용할 객체를 직접 만들지 않고 외부에서 주입 받아 사용하는 방식
    //     - 외부에서 객체를 주입하기 때문에 주입하는 객체를 쉽게 교체할 수 있다.
    //     - 예를 들어 Command 구현체를 테스트할 때 진짜 DAO를 주입하지 않고 
    //       테스트용 DAO를 주입할 수 있다. 
    //       그래서 단위 테스트하기가 쉽다.
    // 2) event listener
    //     - 보통 코드를 실행할 때 작성된 순서대로 위에서 아래로 실행한다. 
    //       메서드 호출 코드가 있다면 해당 메서드를 호출한다.
    //       그리고 호출이 끝나면 원래 위치로 이동하여 다음 코드를 실행한다.
    //     - 어떤 메서드는 "키보드 클릭", "마우스 클릭" 등 특정 상태에 놓여지면  
    //       자동으로 호출된다. 
    //     - 이런 메서드를 보통 리스너(listener)라 부르고, 
    //       이렇게 순차적으로 실행되지 않고
    //       특정 상황에 놓일 때 흐름에 역행하여 호출된다.
    //     - 이런 메서드(리스너)도 IoC의 한 예이다.
    //     - 직접 호출하는 것이 아니라 내부에 의해 호출되는 메서드라는 의미로 
    //       "콜백 메서드(callback method)"라 부르기도 한다.
    //       보통 줄여서 cb(특히 JavaScript에서 함수 레퍼런스를 선언할 때) 라고 할 때가 있다.
    //
    // 스프링 IoC 컨테이너
    // : spring.io 사이트에서 제공하는 프레임워크(framework)이다.
    //  : 프로젝트에 Spring IoC 컨테이너 포함하기
    //  mvnrepository.com에서 spring-context로 라이브러리를 검색한다.
    //  build.gradle에 의존 라이브러리 정보를 추가한다.
    // '$ gradle eclipse'를 실행하여 라이브러리 파일을 다운로드 받고 이클립스 설정 파일을 갱신한다.
    //  이클립스에서 프로젝트 정보를 갱신한다.
    // ApplicationContext 인터페이스
    // : 스프링 IoC 컨테이너의 사용 규칙을 정의한 인터페이스이다.
    //  모든 스프링 IoC 컨테이너는 이 규칙에 따라 IoC 컨테이너가 정의되어 있다.
    //
    // ApplicationContext 구현체(implements, 인터페이스를 구현한 클래스 또는 그 클래스의 인스턴스)의 종류
    // : XML 파일에서 설정 정보를 읽어드리는 IoC 컨테이너
    //    : ClassPathXmlApplicationContext - 설정 파일을 자바 CLASSPATH 경로에서 찾는다.
    //    FileSystemXmlApplicationContext - 설정 파일을 OS 경로에서 찾는다.
    //   자바 클래스 파일의 애노테이션에서 설정 정보를 읽어 들이는 IoC 컨테이너
    //    :AnnotationConfigApplicationContext -설정 정보를 자바 클래스에서 찾는다.
    
    // 1) 자바 CLASSPATH에서 설정 파일을 찾는 IoC 컨테이너
    // : 자바 CLASSPATH
    //    : 예를 들면 /Users/eomjinyoung/git/bitcamp-2018-12/java-project/bin/main
    //    즉, JVM이 자바 클래스 파일(.class)을 로딩하기 위해 찾는 경로이다.
    //    보통 JVM을 실행할 때 - classpath 옵션이나 -cp 옵션으로 경로를 지정한다.
    //    물론 JVM이 클래스 파일을 찾을 JVM의 기본 경로($JAVA_HOME/lib)를 가장 먼저 뒤진다.
    //    : 설정 파일 경로를 지정할 때 자바 패키지 경로를 지정한다.
    //    파일 경로이기 때문에 패키지와 패지키 사이에는 . 대신에 /를 사용해야 한다.
    ApplicationContext iocContainer1 = 
        new ClassPathXmlApplicationContext("ch29/a/application-context.xml");
    
    // 2) 운영체제의 파일 시스템에서 설정 파일을 찾는 IoC 컨테이너
    // : 설정 파일 경로를 지정할 때 직접 파일 경로를 지정해야 한다.
    //  파일 경로 내의 정보가 단 하나라도 바뀌면 전체 경로를 수정해줘야한다. => 귀찮고 리스크가 크다. 1)을 쓰자.
    // : 주의!
    //  설정 파일 경로를 지정할 때 URL 형식으로 지정해야 한다.
    //  URL 형식에서는 파일 시스템을 가리킬 때 다음의 접두어를 붙인다.
    //  file://
    ApplicationContext iocContainer2 = 
        new FileSystemXmlApplicationContext(
            "file:///home/bitcamp/git/bitcamp-java-2018-12/java-basic/bin/main/ch29/a/application-context.xml");
    
    // 3) 자바 클래스 파일의 애노테이션으로부터 설정 정보를 추출한다.
    // : 생성자에 설정 정보를 갖고 있는 클래스의 타입 정보를 넘긴다.
    ApplicationContext iocContainer3 =
        new AnnotationConfigApplicationContext(AppConfig.class);
    
    
    System.out.println("실행 완료!");
    
  }
}
