// 멀티파트 파일 업로드 처리하기 - apache 라이브러리 사용
package bitcamp.ex04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/ex04/s4")
public class Servlet04 extends GenericServlet { 

  private static final long serialVersionUID = 1L;
  private String uploadDir;

  @Override
  public void init() throws ServletException {
    // init(ServletConfig)가 호출될 때 이 메서드를 호출한다. 
    // 1) 파일을 저장할 디렉토리경로를 준비한다.
    //  : 주의! 빈폴더는 배치가 안됨. 따라서 README.md 파일을 하나 생성해준다.
    // 환경정보를 다루는 ServletContext를 이용해서 구한다.
     this.uploadDir = this.getServletContext().getRealPath("/upload");
    // 여기서 첫번째 "/"는 context root 현재 web-application이 존재하는 경로이다.
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    // 멀티파트 형식으로 보낸 첨부 파일 데이터를 읽는 방법
    //  : Content-Type 헤더에 지정한 구분자를 사용하여 각 파트를 분리한 다음
    //    데이터를 읽는다.
    //  : 문제는 기존에 제공하는 getParameter()로는 멀티파트 형식으로 전송된
    //    데이터를 읽을 수 없다.
    //  : 방법?
    //    1) 개발자가 직접 멀티파트 형식을 분석하여 데이터를 추출한다.(X)
    //    2) 외부 라이브러리를 사용한다.
    //        - apache.org 사이트에서 제공하는 멀티파트 데이터 분석기를 사용한다.
    //        - 실무에서 예전에 많이 사용했다. 
    //    3) Servlet 3.0 부터 제공하는 기능을 이용한다.
    //        - 실무에서 사용하던 그대로 계속 사용하는 바람에 
    //          서블릿에서 제공하는 방법을 개발자들이 잘 사용하지 않는다.
    //        - 그것이 문제다!
    //    4) Spring WebMVC를 사용한다면 해당 프레임워크에서 제공하는 기능을 이용한다.
    //        - Spring WebMVC를 설명할 때 실습하겠다.
    //
    // 테스트
    // : http://localhost:8080/java-web/ex04/test04.html 실행
    //

    // 멀티 파트 데이터를 처리할 때는 다음의 인코딩 설정이 적용되지 않는다.
    // req.setCharacterEncoding("UTF-8");

    // getParameter()로 값을 받으면 null을 리턴한다는 것을 확인하기 위해
    // 파라미터 모두 String으로 받는다.
    //  : 멀티 파트 형식으로 전송된 데이터는 getParameter()로 꺼낼 수 없다.
    /*
    String age = req.getParameter("age");
    String name= req.getParameter("name");
    String photo = req.getParameter("photo");
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.printf("이름=%s\n", name);
    out.printf("나이=%s\n", age);
    out.printf("사진=%s\n", photo);
     */

    // 멀티파트 형식의 데이터 처리하기
    //  1) Apache 라이브러리 가져온다.
    //    - mvnrepository.com에서 apache fileupload 라이브러리 검색한다.
    //    - build.gradle에 라이브러리 정보 추가한다.
    //    - '$ gradle eclipse' 실행해서 이클립스 설정 파일을 갱신한다.
    //    - 이클립스 IDE에서 프로젝트 정보를 갱신한다.
    //  2) Apache commons-fileupload 문서에 따라 코딩한다.

    //  : 멀티파트 데이터를 분석하여 FileItem 객체에 담아 줄 공장을 준비한다.
    DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();

    //  : 공장 객체를 사용하여 클라이언트가 보낸 데이터를 처리할 객체 준비
    ServletFileUpload multipartDataHandler = 
        new ServletFileUpload(fileItemFactory);

    //  : 분석할 데이터를 보관할 맵 객체를 준비한다.
    HashMap<String,String> paramMap = new HashMap<>();

    try {
      //  : 멀티파트 데이터 처리기를 이용하여 클라이언트 요청을 분석하기
      List<FileItem> parts = multipartDataHandler.parseRequest(
          (HttpServletRequest)req);
      for (FileItem part : parts) {
        if (part.isFormField()) {
          // 파트의 데이터가 일반 데이터라면
          paramMap.put(
              part.getFieldName(),  // 클라이언트가 보낸 파라미터 이름
              part.getString("UTF-8")  // 파라미터의 값. 값 꺼낼 때 인코딩을 지정해야 한다.)
              );

        } else {
          // 파트의 데이터가 파일 이라면
          //  : upload/디렉토리에 파일을 저장한다.
          
          // 업로드 파일을 저장할 때 사용할 파일명을 준비한다.
          //  : 원래의 파일명을 사용하지 않는다.
          //  : 다른 클라이언트가 같은 이름의 파일을 업로드 하면 기존 파일을 덮어쓸 수 있기 때문이다.
          //  : 유니크(유일한)아이디를 만들어주는 UUID 클래스 이용
          String filename = UUID.randomUUID().toString();
          
          // 전체 파일 경로를 준비한다.
          // : /java-web/upload/파일명
          File file = new File(this.uploadDir + "/" + filename);
          
          // 파일 경로에 업로드 파일을 저장한다.
          part.write(file);
          
          paramMap.put(
              part.getFieldName(),  // 클라이언트가 보낸 파라미터 이름
              filename  // 파일 이름
              );
        }
      }
      // html <br> break태그 삽입시 html 출력할 때 엔터키기능을한다.
      // \n은 소스코드를 구분하기 쉽게 소스코드에서 엔터를 치는것이다.
      res.setContentType("text/html;charset=UTF-8");
      PrintWriter out = res.getWriter();
      out.println("<html>");
      out.println("<head><title>servlet04</title></head>");
      out.println("<body><h1>파일 업로드 결과</h1>");
      out.printf("이름=%s<br>\n", paramMap.get("name"));
      out.printf("나이=%s<br>\n", paramMap.get("age"));
      out.printf("사진=%s<br>\n", paramMap.get("photo"));
      out.printf("<img src='../upload/%s'><br>\n", paramMap.get("photo"));
      out.println("</body></html>");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

// <form> 태그의 enctype을 "multipart/form-data"로 설정하면,
// 웹 브라우저가 데이터를 전송할 때 다음과 같은 형식으로 보낸다.
// 요청 프로토콜에서 Content-Type을 확인하라.
//
/*
POST /java-web/ex04/s4 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 5304
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary4ipIMwJrBHngw95J
User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng
Referer: http://localhost:8080/java-web/ex04/test04.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
빈 줄
----WebKitFormBoundary4ipIMwJrBHngw95J
Content-Disposition: form-data; name="name"

홍길동
----WebKitFormBoundary4ipIMwJrBHngw95J
Content-Disposition: form-data; name="age"

20
----WebKitFormBoundary4ipIMwJrBHngw95J
Content-Disposition: form-data; name="photo"; filename="images.jpeg"
Content-Type: image/jpeg

바이너리 데이터....
------WebKitFormBoundary4ipIMwJrBHngw95J--
 */





