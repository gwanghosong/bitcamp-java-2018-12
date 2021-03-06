package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/photoboard/delete")
public class PhotoBoardDeleteServlet extends HttpServlet {

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    // Spring IoC 컨테이너를 알아낸다.
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");
    PhotoBoardService photoBoardService = 
        iocContainer.getBean(PhotoBoardService.class);

    int no = Integer.parseInt(request.getParameter("no"));
    if (photoBoardService.delete(no) > 0) {
      response.sendRedirect("list");
      return;
    }
    
    request.setAttribute("error.title", "사진 삭제(JSP)");
    request.setAttribute("error.content", "해당 번호의 사진이 없습니다.");
    
    request.getRequestDispatcher("/error.jsp").forward(request, response);
  }
}
