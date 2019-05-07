package com.eomcs.lms.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
  
  @Autowired BoardService boardService;
  
  @GetMapping("form")
  public void form() {
  }
  
  @PostMapping("add")
  public String add(Board board) {
    boardService.add(board);    
    return "redirect:.";
  }
  
  @GetMapping
  public String list(
      // 숫자 안들어오면 에러떠서 디폴트 값 지정.
      @RequestParam(defaultValue = "1") int pageNo,
      @RequestParam(defaultValue = "3") int pageSize,
      Model model) {
    
    if (pageSize < 3 || pageSize > 8)
      pageSize = 3;
    
    int rowCount = boardService.size();
    int totalPage = rowCount / pageSize;
    if (rowCount % pageSize > 0)
      totalPage++;
    
    if (pageNo < 1)
      pageNo = 1;
    else if (pageNo > totalPage)
      pageNo = totalPage;
    
    List<Board> boards = boardService.list(pageNo, pageSize);
    model.addAttribute("list", boards);
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPage", totalPage);
    
    return "board/list";
  }

  @GetMapping("{no}")
  public String detail(@PathVariable int no, Model model) {
    // 생략할 수 있는 임시변수를 생략안하는 경우는 보통 디버깅을 위해서 남겨둔다.
    // 장점 : 디버깅이 쉽다.
    // 단점 : 코드 가독성이 떨어진다.
    Board board = boardService.get(no);
    model.addAttribute("board", board);
    
    return "board/detail";
  }
  
  @PostMapping("update")
  public String update(Board board) throws Exception {
    if (boardService.update(board) == 0) 
      throw new RuntimeException("해당 번호의 게시물이 없습니다.");
    return "redirect:.";
  }
  
  @GetMapping("delete/{no}")
  public String delete(@PathVariable int no) throws Exception {

    if (boardService.delete(no) == 0) 
      throw new RuntimeException("해당 번호의 게시물이 없습니다.");
    
      return "redirect:../";
  }
}










