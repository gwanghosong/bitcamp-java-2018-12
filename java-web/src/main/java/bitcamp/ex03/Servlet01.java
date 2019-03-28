// 클라이언트로 출력하기
package bitcamp.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 하나의 이름에 여러 서블릿설정할 수 없음.
// 왜냐하면 클라이언트가 실행할 때 서버가 어느 서블릿을 실행하는지 알 수 없기 때문.
// 하나의 서블릿에 여러 이름은 설정할 수 있음.
@WebServlet("/ex03/s1")
public class Servlet01 extends GenericServlet { 
  
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    PrintWriter out = res.getWriter();
    
    // 출력 스트림을 꺼내기 전에 출력할 때 사용할 문자표(charset)를 지정하지 않으면
    // 기본이 영어문자로 간주하여 아스키 코드(ASCII)로 변환하여 출력한다.
    // 자바(Unicode2; UTF-16) ===> 출력문자(ASCII) 
    out.println("Hello!");
    out.println("안녕하세요!");
    out.println("こんにちは");
    out.println("你好");
    out.println("اَلسَّلامُ عَلَيْحْم ");
  }
}
