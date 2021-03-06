package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@SuppressWarnings("serial")
@WebServlet("/lesson/detail")
public class LessonDetailServlet extends HttpServlet {

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LessonService lessonService = 
        InitServlet.iocContainer.getBean(LessonService.class);
    
    int no = Integer.parseInt(request.getParameter("no"));
    Lesson lesson = lessonService.get(no);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>수업 조회</title></head>");
    out.println("<body><h1>수업 조회</h1>");

    if (lesson == null) {
      out.println("<p>해당 번호의 수업이 없습니다.</p>");
      return;
    }

    out.println("<form action='update' method='post'>");
    out.println(String.format("<tr>"
        + "<th>번호</th>"
        + "<td><input type='number' name='no' readonly value='%d'></td>"
        + "</tr>", no));
    out.println("<table border='1'>");
    out.println(String.format("<tr>"
        + "<th>수업</th>"
        + "<td><input type='text' name='title' value='%s'></td>\n"
        + "</tr>", lesson.getTitle()));
    out.println(String.format("<tr>"
        + "<th>설명</th>"
        + "<td><textarea name='contents' rows='3' cols='50'>%s</textarea></td>"
        + "</tr>", lesson.getContents()));
    out.println(String.format("<tr>"
        + "<th>시작일</th>"
        + "<td><input type='date' name='startDate' value='%s'></td>"
        + "</tr>", lesson.getStartDate()));
    out.println(String.format("<tr>"
        + "<th>종료일</th>"
        + "<td><input type='date' name='endDate' value='%s'></td>"
        + "</tr>", lesson.getEndDate()));
    out.println(String.format("<tr>"
        + "<th>총수업시간</th>"
        + "<td><input type='number' name='totalHours' value='%d'></td>"
        + "</tr>", lesson.getTotalHours()));
    out.println(String.format("<tr>"
        + "<th>일수업시간</th>"
        + "<td><input type='number' name='dayHours' value='%d'></td>"
        + "</tr>", lesson.getDayHours()));

    out.println("</table>");
    out.println("<p><a href='list'>목록</a>"
        + " <a href='delete?no=" + lesson.getNo() + "'>삭제</a>"
        + "<button type='submit'>변경</button>"
        + "</p>");
    out.println("</form>");
    out.println("</body></html>");

  }
}
