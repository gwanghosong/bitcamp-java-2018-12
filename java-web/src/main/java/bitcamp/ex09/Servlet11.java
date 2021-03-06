// 보관소에 값 넣기 - forward/include 서블릿끼리 ServletRequest 공유하는 것 테스트
package bitcamp.ex09;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex09/s11")
@SuppressWarnings("serial")
public class Servlet11 extends HttpServlet { 

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
          throws ServletException, IOException {

    // 테스트 방법
    //  : http://localhost:8080/java-web/ex09/s11
    //
    ServletContext sc = this. getServletContext();
    sc.setAttribute("v1", "xxx");

    HttpSession session = request.getSession();
    session.setAttribute("v2", "yyy");

    request.setAttribute("v3", "zzz");

    // 주목!
    //  : 포워드(인클루드 포함)할 때 이 서블릿이 파라미터로 받은
    //    ServletRequest와 ServletResponse를 전달한다.
    //    따라서 포워드/인클루드 서블릿들은 응답이 완료할 때까지 이 객체들을 공유하는 것이다.

    request.getRequestDispatcher("s12").forward(request, response);
  }
}

