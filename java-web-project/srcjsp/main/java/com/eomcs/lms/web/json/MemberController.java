package com.eomcs.lms.web.json;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@RestController("json/MemberController")
@RequestMapping("/json/member")
public class MemberController {

  @Autowired MemberService memberService;
  @Autowired ServletContext servletContext;
  
  @PostMapping("add")
  public Object add(Member member, Part photo) throws Exception {
    if (photo.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath("/upload/member");
      photo.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }
    HashMap<String,Object> content = new HashMap<>();
    try {
      memberService.add(member);
      content.put("status", "success");
    } catch (Exception e) {
      content.put("status", "fail");
      content.put("message", e.getMessage());
    }
    return content;
  }
  
  @GetMapping("list")
  public Object list(
      @RequestParam(defaultValue = "1") int pageNo,
      @RequestParam(defaultValue = "3") int pageSize) {
    
    if (pageSize < 3 || pageSize > 8)
      pageSize = 3;
    
    int rowCount = memberService.size();
    int totalPage = rowCount / pageSize;
    if (rowCount % pageSize > 0)
      totalPage++;
    
    if (pageNo < 1)
      pageNo = 1;
    else if (pageNo > totalPage)
      pageNo = totalPage;
    
    List<Member> members = memberService.list(null, pageNo, pageSize);
    HashMap<String,Object> content = new HashMap<>();
    content.put("list", members);
    content.put("pageNo", pageNo);
    content.put("pageSize", pageSize);
    content.put("totalPage", totalPage);
    
    return content;
  }
  
  @GetMapping("detail")
  public Object detail(int no) {
    Member member = memberService.get(no);  
    return member;
  }
  
  @GetMapping("search")
  public Object search(String keyword) {
    List<Member> members = memberService.list(keyword, 0, 0);
    HashMap<String,Object> content = new HashMap<>();
    content.put("list", members);
    
    return content;
  }
  
  @PostMapping("update")
  public Object update(Member member, Part photo) throws Exception {

    if (photo.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath("/upload/member");
      photo.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }
    HashMap<String,Object> content = new HashMap<>();
    try {
      if (memberService.update(member) == 0) 
        throw new RuntimeException("해당 번호의 회원이 없습니다.");
        content.put("status", "success");
      } catch (Exception e) {
        content.put("status", "fail");
        content.put("message", e.getMessage());
      }
      return content; 
  }
  
  @GetMapping("delete")
  public Object delete(int no) throws Exception {
    HashMap<String,Object> content = new HashMap<>();
    try {
      if (memberService.delete(no) == 0) 
        throw new RuntimeException("해당 번호의 회원이 없습니다.");
      content.put("status", "success");
    } catch (Exception e) {
      content.put("status", "fail");
      content.put("message", e.getMessage());
    }
    return content; 
  }
}
