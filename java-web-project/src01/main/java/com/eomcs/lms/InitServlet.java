// 서블릿들이 사용할 객체를 준비하는 서블릿
//  : 서블릿이 작업을 수행하려면 XxxService 객체가 필요하다.
//  : 서비스 객체는 Spring IoC 컨테이너에 들어있다.
//  : 이 클래스에서 바로 그 Spring IoC 컨테이너를 준비한다.
//


// cf)
// $ gradle eclipse 실행 한 후에 디렉토리나 소스폴더를 추가한다면
// 그 추가한 폴더의 경로를 deploy하는 설정이 추가되지 않는다.
// Navigator view에서 /.settings/org.eclipse.wst.common.component 파일을 확인해보면
// deploy 설정 경로를 확인할 수 있다.

package com.eomcs.lms;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SuppressWarnings("serial")
@WebServlet(
    urlPatterns = "/init",
    loadOnStartup = 1)
public class InitServlet extends HttpServlet {
  // 보통 클래스에서 사용할 로그 출력 객체는 클래스의 스태틱 멤버로 선언한다.
  final static Logger logger = LogManager.getLogger(InitServlet.class);

  // Command객체와 그와 관련된 객체를 보관하고 있는 beanContainer
  public static ApplicationContext iocContainer;

  @Override
  public void init() throws ServletException {
    // 이 클래스의 인스턴스가 생성된 후 톰캣이 제일 처음으로 호출하는 메서드
    // : 보통 이 클래스가 작업하는데 필요한 객체를 준비한다.

    logger.info("Spring IoC 컨테이너 준비");
    iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    printBeans();

  }

  private void printBeans() {
    // 개발하는 동안 참고할 로그는 보통 debug 등급으로 출력한다.
    logger.debug("--------------------------------------------");
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      logger.debug(String.format("빈 생성됨 (객체명=%s, 클래스명=%s)", name, 
          iocContainer.getBean(name).getClass().getName()));
    }
    logger.debug("--------------------------------------------");
  }
}
