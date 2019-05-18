package com.eomcs.lms.web.json;

import java.util.ArrayList;
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
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@RestController("json/PhotoBoardController")
@RequestMapping("/json/photoboard")
public class PhotoBoardController {

  @Autowired PhotoBoardService photoBoardService;
  @Autowired LessonService lessonService;
  @Autowired ServletContext servletContext;

//  @GetMapping("form")
//  public void form(Model model) throws Exception {
//    List<Lesson> lessons = lessonService.list(0, lessonService.size());
//    model.addAttribute("lessons", lessons);
//  }

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

  @GetMapping("list")
  public Object list(
      @RequestParam(defaultValue = "1") int pageNo,
      @RequestParam(defaultValue = "3") int pageSize) {

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
    HashMap<String,Object> content = new HashMap<>();
    content.put("list", boards);
    content.put("pageNo", pageNo);
    content.put("pageSize", pageSize);
    content.put("totalPage", totalPage);

    return content;
  }

  @GetMapping("detail")
  public Object detail(int no) {

    PhotoBoard board = photoBoardService.get(no);
    List<Lesson> lessons = lessonService.list(0, lessonService.size());
    HashMap<String,Object> content = new HashMap<>();
    content.put("board", board);
    content.put("lessons", lessons);

    return content;
  }

  @GetMapping("search")
  public Object search(
      @RequestParam(defaultValue = "0") int lessonNo, 
      @RequestParam(defaultValue = "1") int pageNo,
      @RequestParam(defaultValue = "3") int pageSize,
      String keyword) {

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

    String searchWord = null;
    if (keyword.length() > 0)
      searchWord = keyword;
    List<PhotoBoard> boards = photoBoardService.list(lessonNo, searchWord, pageNo, pageSize);
    HashMap<String,Object> content = new HashMap<>();
    content.put("list", boards);
    content.put("pageSize", pageSize);
    content.put("lessonNo", lessonNo);
    content.put("keyword", searchWord);
    content.put("pageNo", pageNo);

    List<PhotoBoard> searchBoards = photoBoardService.list(lessonNo, searchWord, 1, photoBoardService.size());

    int count = searchBoards.size() / pageSize;
    if (searchBoards.size() % pageSize > 0) 
      count++;
    if (totalPage > count)
      totalPage = count;
    content.put("totalPage", totalPage);
    
    return content;
  }

  @PostMapping("update")
  public String update(PhotoBoard board, Part[] photo
      ) throws Exception {

    String uploadDir = 
        servletContext.getRealPath("/upload/photoboard");

    ArrayList<PhotoFile> files = new ArrayList<>();

    for (Part pht : photo) {
      if (pht.getSize() == 0) 
        continue;

      String filename = UUID.randomUUID().toString();
      pht.write(uploadDir + "/" + filename);

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

  @GetMapping("delete")
  public Object delete(int no) throws Exception {
    HashMap<String,Object> content = new HashMap<>();
    try {
      if (photoBoardService.delete(no) == 0)
        throw new RuntimeException("해당 번호의 사진이 없습니다.");
      content.put("status", "success");
    } catch (Exception e) {
      content.put("status", "fail");
      content.put("message", e.getMessage());
    }
    return content; 
  }
}