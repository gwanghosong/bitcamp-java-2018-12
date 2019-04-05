package com.eomcs.lms.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/photoboard/detail")
public class PhotoBoardDetailServlet extends HttpServlet {

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
    LessonService lessonService = 
        iocContainer.getBean(LessonService.class);

    int no = Integer.parseInt(request.getParameter("no"));
    PhotoBoard board = photoBoardService.get(no);
    
    List<Lesson> lessons = lessonService.list();
    List<PhotoFile> files = (List<PhotoFile>) board.getFiles();
    
    request.setAttribute("photoBoard", board);
    request.setAttribute("list", lessons);
    request.setAttribute("File", files);

    response.setContentType("text/html;charset=UTF-8");
    
    request.getRequestDispatcher("/photoboard/detail.jsp").include(request, response);
  }
}
