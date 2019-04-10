package com.eomcs.lms.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

// 페이지 컨트롤러는 Spring IoC 컨테이너에서 관리할 것이다.
// 따라서 클래스에 @Controller 애노테이션을 붙여라!
// @Controller에 ("/board/list")을 붙이지 않으면 기본적으로 boardListController로
// 객체를 생성한다. 즉 클래스 이름에 맨 앞글자를 소문자로하여 객체를 생성한다.
@Controller
public class BoardListController {
  
  @Autowired BoardService boardService;
  
  // 이제는 클래스가 아니라 메서드로 찾을거라 여기다 ("/board/list")을 붙인다.
  @RequestMapping("/board/list")
  public String execute(
      HttpServletRequest request, 
      HttpServletResponse response) throws Exception {
    
    List<Board> boards = boardService.list();
    request.setAttribute("list", boards);
    
    // 뷰 컴포넌트의 URL을 이 메서드를 호출한 프론트 컨트롤러에게 리턴한다.
    return "/board/list.jsp";
  }
}










