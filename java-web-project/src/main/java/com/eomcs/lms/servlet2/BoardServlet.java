package com.eomcs.lms.servlet2;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board2")
public class BoardServlet extends HttpServlet {
  
  // GET/POST 요청을 모두 처리하기 위해 service()를 오버라이딩 하였다.
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    // 뒤에부분 먼저 복붙하고 앞에거 복붙하자
    out.println("<html>");
    out.println("<head><title>게시물 관리</title><head>");
    out.println("<body>");
    
    out.println("<header>");
    out.println("<img src='http://bitcamp.co.kr/img/logo.jpg' style='height:50px'>");
    out.println("</header>");
    
    String command = request.getParameter("command");
    RequestDispatcher rd = null;
    
    if (command == null)
      command = "list";
    
    switch (command) {
      case "form": rd = request.getRequestDispatcher("/board2/form"); break;
      case "add":
        response.setHeader("Refresh", "1;url=board2?command=list");
        rd = request.getRequestDispatcher("/board2/add"); break;
      case "detail": rd = request.getRequestDispatcher("/board2/detail"); break;
      case "update": 
        response.setHeader("Refresh", "1;url=board2?command=list");
        rd = request.getRequestDispatcher("/board2/update"); break;
      case "delete": 
        response.setHeader("Refresh", "1;url=board2?command=list");
        rd = request.getRequestDispatcher("/board2/delete"); break;
      default: rd = request.getRequestDispatcher("/board2/list"); break;
    }
    // 페이지의 가운데에는 다른 서블릿의 출력을 인클루딩 한다.
    rd.include(request, response);
    
    out.println("<footer>");
    out.println("<hr>");
    out.println("  비트캠프, <adress>서울시 서초구 서초동 1327-15 비트아카데미빌딩</address>");
    out.println("</footer>");
    
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    // Spring IoC 컨테이너를 알아낸다.
    BoardService boardService = 
        InitServlet.iocContainer.getBean(BoardService.class);
    
    Board board = new Board();
    board.setContents(request.getParameter("contents")
        + ":" + request.getRemoteAddr());
    
    boardService.add(board);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head>"
        + "<title>게시물 등록</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "</head>");
    out.println("<body><h1>게시물 등록</h1>");
    out.println("<p>저장하였습니다.</p>");
    out.println("</body></html>");

  }
}
