package com.eomcs.lms.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@Controller
@RequestMapping("/photoboard")
public class PhotoBoardController {

  @Autowired PhotoBoardService photoBoardService;
  @Autowired LessonService lessonService;
  @Autowired ServletContext servletContext;

  @GetMapping("form")
  public void form(Model model) throws Exception {
    List<Lesson> lessons = lessonService.list(0, 0);//임시
    model.addAttribute("lessons", lessons);
  }

  @PostMapping("add")
  public String add(PhotoBoard board, Part [] photo) throws Exception {

    String uploadDir = 
        servletContext.getRealPath("/upload/photoboard"); 

    ArrayList<PhotoFile> files = new ArrayList<>();

    for (Part part : photo) {
      if (part.getSize() == 0) 
        continue;

      String filename = UUID.randomUUID().toString();
      part.write(uploadDir + "/" + filename);

      PhotoFile file = new PhotoFile();
      file.setFilePath(filename);
      files.add(file);
    }
    board.setFiles(files);

    if (board.getLessonNo() == 0) {
      throw new RuntimeException("사진 또는 파일을 등록할 수업을 선택하세요.");

    } else if (files.size() == 0) {
      throw new RuntimeException("최소 한 개의 사진 파일을 등록해야 합니다.");

    } else if (board.getTitle().length() == 0) {
      throw new RuntimeException("사진 게시물 제목을 입력하세요.");

    }
    photoBoardService.add(board);
    return "redirect:.";
  }

  @GetMapping
  public String list(
      @RequestParam(defaultValue = "1") int pageNo,
      @RequestParam(defaultValue = "3") int pageSize,
      Model model) {
    
    if (pageSize < 3 || pageSize > 8)
      pageSize = 3;
    
    int rowCount = photoBoardService.size();
    int totalPage = rowCount / pageSize;
    if (rowCount % pageSize > 0)
      totalPage++;
    
    if (pageNo < 1)
      pageNo = 1;
    else if (pageNo > totalPage)
      pageNo = totalPage;
    
    List<PhotoBoard> boards = photoBoardService.list(0, null, pageNo, pageSize);
    model.addAttribute("list", boards);
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPage", totalPage);
    
    return "photoboard/list";
  }

  @GetMapping("{no}")
  public String detail(@PathVariable int no, Model model) {
        
    PhotoBoard board = photoBoardService.get(no);
    List<Lesson> lessons = lessonService.list(0, lessonService.size());
    model.addAttribute("board", board);
    model.addAttribute("lessons", lessons);
    
    return "photoboard/detail";
  }

  @GetMapping("search")
  public void search(int lessonNo, String keyword, Model model) {
    String searchWord = null;
    if (keyword.length() > 0)
      searchWord = keyword;
    List<PhotoBoard> boards = photoBoardService.list(lessonNo, searchWord, 0, 0);
    model.addAttribute("list", boards);
  }

  @PostMapping("update")
  public String update(PhotoBoard board, @RequestParam("photo") Part[] photos
      ) throws Exception {

    String uploadDir = 
        servletContext.getRealPath("/upload/photoboard");

    ArrayList<PhotoFile> files = new ArrayList<>();

    for (Part photo : photos) {
      if (photo.getSize() == 0) 
        continue;

      String filename = UUID.randomUUID().toString();
      photo.write(uploadDir + "/" + filename);

      PhotoFile file = new PhotoFile();
      file.setFilePath(filename);
      file.setPhotoBoardNo(board.getNo());
      files.add(file);
    }
    board.setFiles(files);

    if (files.size() == 0) 
      throw new RuntimeException("최소 한 개의 사진 파일을 등록해야 합니다.");
    photoBoardService.update(board);
    return "redirect:.";
  }

  @GetMapping("delete/{no}")
  public String delete(@PathVariable int no) throws Exception {
    if (photoBoardService.delete(no) == 0)
      throw new RuntimeException("해당 번호의 사진이 없습니다.");
    return "redirect:../";
  }
}