// 세션(session)의 타임아웃 설정
package bitcamp.ex11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/s21")
@SuppressWarnings("serial")
public class Servlet21 extends HttpServlet {

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response)
          throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    
    // 세션의 유효시간(분)을 설정한다. 톰캣은 30분이 디폴트
    session.setMaxInactiveInterval(10);
    
    session.setAttribute("v1", "aaa");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("/ex11/s21 실행함!");
  }
}


