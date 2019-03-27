// 서블릿 만들기 - @WebServlet 애노테이션
package bitcamp.ex01;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// @WebServlet 애노테이션
// : web.xml 에 서블릿 정보를 설정하는 대신에
//   이 애노테이션을 사용하여 서블릿을 설정할 수 있다.
// : 이 애노테이션을 활성화 시키려면
//   web.xml의 <web-app> 태그에 다음 속성을 추가 해야 한다.
//      metadata-complete="false"
//   속성의 값은 false여야 한다.

@WebServlet("/ex01/s04")
public class Servlet04 extends GenericServlet { 
  
  // GenericServlet 추상 클래스는 java.io.Serialize 인터페이스를 구현하였다.
  // : serialVersionUID 변수 값을 설정해야 한다.
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    // 클라이언트가 이 서블릿의 실행을 요청할 때마다 호출된다.
    // 클라이언트가 요청한 작업을 수행한다.
    System.out.println("Servlet04.service(ServletRequest, ServletResponse)");
  }
}
