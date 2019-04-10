package com.eomcs.lms.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.context.RequestParam;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@Controller
public class BoardController {
  
  @Autowired BoardService boardService;
  
  @RequestMapping("/board/form")
  public String form() throws Exception {
    return "/board/form.jsp";
  }
  
  @RequestMapping("/board/add")
  public String add(
      @RequestParam("contents") String contents) throws Exception {
    Board board = new Board();
    board.setContents(contents);
    
    boardService.add(board);
    
    return "redirect:list";
  }
  
  @RequestMapping("/board/list")
  public String list(Map<String,Object> map) throws Exception {
    
    List<Board> boards = boardService.list();
    map.put("list", boards);
    
    // 뷰 컴포넌트의 URL을 이 메서드를 호출한 프론트 컨트롤러에게 리턴한다.
    return "/board/list.jsp";
  }
  // map 에 담는 이유
  // 기존의 기술(서블릿기술) 사용을 최소화 하기위함.
  // 서블릿 기술을 최소로해서 재사용을 더 용이하게 하기위함.
  // 다른 기술에서 재사용하려 할 때 최소한의 변경으로 재사용할 수 있다.
  @RequestMapping("/board/detail")
  public String detail(
      @RequestParam("no") int no,
      Map<String,Object> map) throws Exception {

    Board board = boardService.get(no);
    map.put("board", board);

    // 뷰 컴포넌트의 URL을 프론트 컨트롤러에게 리턴한다.
    return "/board/detail.jsp";
  }
  
  @RequestMapping("/board/update")
  public String update(
      @RequestParam("no") int no,
      @RequestParam("contents") String contents) throws Exception {

    Board board = new Board();
    board.setNo(no);
    board.setContents(contents);

    if (boardService.update(board) == 0) 
      throw new Exception("해당 번호의 게시물이 없습니다.");
    return "redirect:list";
  }
  
  @RequestMapping("/board/delete")
  public String delete(
      @RequestParam("no") int no,
      Map<String,Object> map) throws Exception {

    if (boardService.delete(no) == 0) 
      throw new Exception("해당 번호의 게시물이 없습니다.");
      return "redirect:list";
  }
}










