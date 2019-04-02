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
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet {

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    // Spring IoC 컨테이너를 알아낸다.
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");
    MemberService memberService = 
        iocContainer.getBean(MemberService.class);
    
    int no = Integer.parseInt(request.getParameter("no"));
    Member member = memberService.get(no);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>회원 조회</title></head>");
    out.println("<body><h1>회원 조회</h1>");

    if (member == null) {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");
      return;
    }

    out.println("<form action='update' method='post' enctype='multipart/form-data'>");
    out.printf(String.format("<tr>"
        + "<th>번호</th>"
        + "<td><input type='number' name='no' value='%d' readonly></td>"
        + "</tr>", no));
    out.println("<table border='1'>");
    out.println(String.format(
        "<tr> <th>이름</th> "
            + "<td><input type='text' name='name' value='%s'></td> "
            + "</tr>", member.getName()));
    out.println(String.format(
        "<tr> <th>이메일</th> "
            + "<td><input type='email' name='email' value='%s'></td> "
            + "</tr>", member.getEmail()));
    out.println(String.format(
        "<tr> <th>암호</th> "
            + "<td><input type='password' name='password' value='%s'></td> "
            + "</tr>", member.getPassword()));
    
    out.println("<tr>");
    out.println(" <th>사진</th>");
    
    out.println("  <td>");
        if (member.getPhoto() == null) {
          out.printf(
              "<img src='../images/default.jpeg' style='height:80px'>"
              , member.getPhoto());
        } else {
        out.printf(
            "<img src='../upload/member/%s' style='height:80px'>"
            , member.getPhoto());
        }
        out.println(
            "<input type='file' name='photo'></td> "
            + "</tr>");
        
    out.println(String.format(
        "<tr> <th>전화</th> "
            + "<td><input type='text' name='tel' value='%s'></td> "
            + "</tr>", member.getTel()));
    out.println(String.format(
        "<tr> <th>가입일</th> <td>%s</td> </tr>", member.getRegisteredDate()));

    out.println("</table>");
    out.println("<p><a href='list'>목록</a>"
        + " <a href='delete?no=" + member.getNo() + "'>삭제</a>"
        + " <button type='submit'>변경</button>"
        + "</p>");
    out.println("</form>");
    out.println("</body></html>");
  }
}
