// 보관소에 값 넣기
package bitcamp.ex09;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex09/s1")
@SuppressWarnings("serial")
public class Servlet01 extends HttpServlet { 

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
          throws ServletException, IOException {

    // 테스트 방법
    //  : http://localhost:8080/java-web/ex09/s1
    //
    ServletContext sc = this. getServletContext();
    sc.setAttribute("v1", "aaa");

    HttpSession session = request.getSession();
    session.setAttribute("v2", "bbb");

    request.setAttribute("v3", "ccc");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("보관소에 값을 넣었습니다. /ex09/s1");

    // 응답 헤더에 Refresh 정보를 추가한다.
    // 위에서 벌써 클라이언트에게 응답을 했는데 어떻게 응답 헤더를 출력할 수 있나요?
    //  : 잊지 말자! out.println()이 출력한 것은 출력 스트림 버퍼에 보관되어있다.
    //    따라서 아직 클라이언트에게 응답한 상태가 아니다.
    //    그래서 다음과 같이 출력을 한 후에 응답 헤더 값을 추가하거나 변경할 수 있는 것이다.
    //    메서드 호출이 완료될 때 비로소 클라이언트로 응답헤더와 
    //    버퍼에 저장된 message-body가 출력된다.
    //
    // 만약 out.println()/out.printf()/out.print() 등에서 출력한 내용이
    // 버퍼를 꽉 채웠다면 어떻게 하나요?
    //  : 그러면 자동으로 클라이언트에게 응답한다.
    //    따라서 일단 클라이언트에게 응답을 하면 다음의 코드는 적용되지 않는다.
    //    즉 응답을 완료한 후에 헤더 값을 변경하거나 바꿀 수 없다.
    //    소용이 없다.
    //

    // 다음은 일부러 버퍼를 채우는 코드이다.
    // 버퍼가 꽉차면 자동으로 출력하는 것을 확인해보자!
    for (int i = 0;  i < 200;  i++ ) {
      // 약 50바이트씩 100번 출력하면 아직 버퍼에 차지 않았기 때문에
      // 클라이언트로 출력되지 않는다. 
      // 따라서 반복문 아래에 있는 응답 헤더 설정이 유효하다.
      // 그러나 200번 출력하면 8KB 버퍼가 꽉 차기 때문에
      // 반복문 다음에 헤더를 설정하기 전에 이미 버퍼 내용이 출력된다.
      // 즉 응답이 완료된다.
      // 응답을 완료한 다음에 응답 헤더의 값을 변경하거나 추가해봐야 소용없다.
      out.println(i + "  ===> 1234567890123456789012345678901234567890");
    }
    response.setHeader("Refresh", "3;url=s100");
  }
}
