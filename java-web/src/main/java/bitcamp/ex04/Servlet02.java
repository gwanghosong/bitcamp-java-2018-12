// 클라이언트가 보낸 데이터 읽기 - POST 요청 데이터 읽기
package bitcamp.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex04/s2")
public class Servlet02 extends GenericServlet { 
  
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    // POST 요청
    // : 웹 페이지의 폼(method='POST' 일때)에서 전송 버튼을 클릭하면 POST 요청을 보낸다. 
    //
    // 테스트
    // : http://localhost:8080/java-web/ex04/test02.html 실행
    //
    
    // 웹 브라우저가 보낸 데이터 읽기
    // : 데이터를 읽을 때는 GET 요청과 POST 요청이 같다.
    //      ServletRequest.getParameter("파라미터이름")
    // : POST 요청으로 보낸 데이터는 기본으로 영어(ISO-8859-1)라고 간주한다.
    //  그래서 영어 코드를 자바에서 사용하는 UTF-8로 변환한다.
    //
    //  예) :"ABC가각"을 보낸다고 가정하자.
    //  실제 웹 브라우저가 "ABC가각" 문자열을 보낼 때 다음과 같이 UTF-8 코드를 보낸다.
    //    "41 42 43 EAB080 EAB081"
    //  그런데 서블릿에서는 이 코드 값을 ISO-8859-1 코드라고 간주한다.
    //  그러면 getParameter()를 호출하여 값을 꺼내면
    //  위의 코드를 UTF-16으로 바꾼 값을 리턴한다.
    //  즉 각 바이트에 그냥 00을 붙여 문자열을 만든 후 리턴한다.
    //  왜? 영어를 2바이트 유니코드를 만드는 것은 그냥 앞에 00 1바이트를 붙이면 되기 때문이다.
    //  위의 코드를 UTF-16으로 바꾸면 다음과 같다.
    //  "0041(A) 0042(B) 0043(C) 00EA(ê) 00B0(°) 0080(€) 00EA(ê) 00B0(°) 0081(네모)"
    //  http://www.fileformat.info/info/charset/UTF-16/list.htm <= utf-16 code table
    //  이렇게 변환된 코드를 화면에 출력하면 다음 폰트로 보인다.
    //  ABCê°ê°
    //  이미 UTF-16으로 변환할 때 ISO-8859-1로 오판하여 문자들을 변환하였기 때문에
    //  response로 UTF-8로 변환하더라도 이미 잘못변환된 값들을 변환하여 출력하기 때문에
    //  잘못된 값들이 출력된다.
    // cf) 웹브라우저가 사용하는 폰트는 OS에서 사용하는 폰트를 끌고와서 사용함.
    // cf) 해당 폰트에 해당코드에 해당하는 이미지가 없거나 다르면 문자가 출력되지 않거나 다르게 나옴.
    // 클라이언트가 보낸 한글이 깨지는 문제 해결책?
    //  : 다음 코드의 주석을 풀고 테스트 해보라!
    //    정상적으로 잘 출력될 것이다.

//    req.setCharacterEncoding("UTF-8");

    //  : 원리
    //    getParameter()를 최초로 호출하기 전에 먼저
    //    클라이언트가 보낸 데이터의 인코딩 형식이 어떤 문자표로 되어 있는지 알려줘라.
    //  : 주의!
    //    반드시 getParameter()를 최초로 호출하기 전이어야 한다.
    //    한 번 getParameter()를 호출한 후에는 소용 없다.
    
    // GET 요청이 정상적으로 수행되지 않을 경우
    // : 톰캣 7버전 이하인 경우 GET 요청시 값이 ????로 리턴될 수 있다.
    //  이런 경우 이클립스에서 Servers/해당폴더-config/server.xml 부분에서
    //  필요한 곳에 URIEncoding="UTF-8" 추가해준다.
    
    String name= req.getParameter("name");
    int age = Integer.parseInt(req.getParameter("age"));
    System.out.println(name);
    System.out.println(age);
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.printf("이름=%s\n", name);
    out.printf("나이=%d\n", age);
    
  }
}

// HTTP 요청형식
//     method sp request-URI http_version CRLF
//    *(general header | request header | entity header) CRLF
//    CRLF
//    message-body
//
// POST 요청 HTTP 프로토콜 예)
// : POST 요청은 데이터를 message-body에 붙여서 보낸다.
// : 데이터 형식과 URL 인코딩은 GET 요청과 같다.

// : 예)
/*
POST /java-web/ex04/s2 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 33
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng
Referer: http://localhost:8080/java-web/ex04/Test02.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
빈줄
name=ABC%EA%B0%80%EA%B0%81&age=20
 */

// GET 요청 vs POST 요청 (차이점)
//
// 1) 전송 데이터 용량
//
// : GET
//      - 대부분의 웹서버가 request-line과 헤더의 크기를 8KB로 제한하고 있다.
//      - 따라서 긴 게시글과 같은 큰 용량의 데이터를 GET 방식으로 전송할 수 없다.
// : POST
//      - HTTP 요청 헤더 다음에 오는 message-body 부분에 데이터를 두기 때문에
//        용량의 제한 없이 웹 서버에 전송할 수 있다.
//      - 즉 웹 서버가 제한하지 않는 한 전송 데이터의 크기에 제한이 없다.
//      - 웹 서버가 제한한다?
//        특정 사이트에서는 게시글의 크기나 첨부 파일의 크기에 제한을 둔다.
// : 용도
//      게시글 조회나 검색어 입력 같은 간단한 데이터 전송에는 GET 요청으로 보내고,
//      게시글 등록이나 첨부파일 같은 큰 데이터 전송에는 POST 요청으로 보낸다.
//
// 2) 바이너리 데이터 전송
//
// : GET
//      - request-URI가 텍스트로 되어 있다.
//        따라서 바이너리 데이터를 request-URI에 붙여서 전송할 수 없다.
//      - 그럼에도 꼭 GET 요청으로 바이너리 데이터를 보내고자 한다면?
//        바이너리 데이터를 텍스트로 변환하면 된다.
//        예를 들어 바이너리 데이터를 Base64로 인코딩하여 텍스트를 만든 후에
//        GET 요청 방식대로 이름=값 으로 보내면 된다.
//        Base64 : 바이너리 데이터를 텍스트화 할때 사용하는 인코딩 방식
//        java-basic.ch23을 참고하라.
//      - 그래도 결국 용량 제한 때문에 바이너리 데이터를 GET 요청으로 전송하는 것은 바람직하지 않다.
//
// : POST
//      - 이 방식에서도 이름=값 형태로는 바이너리 값을 전송할 수 없다.
//      - multipart 형식을 사용하면 바이너리 데이터를 보낼 수 있다.
//      - 보통 파일 업로드를 구현할 때 이 multipart 전송 방식으로 사용한다.
//
// 3) 보안
//
// : GET
//      - GET 요청은 URL에 전송 데이터가 포함되어 있기 때문에
//        사용자 아이디나 암호 같은 데이터를 GET 방식으로 전송하는 것은 위험하다.
//      - 웹 브라우저는 주소 창에 입력한 값을 내부 캐시에 보관해 두기 때문이다.
//      - 그러나 게시물 번호 같은 데이터는 URL에 포함되어야 한다.
//        그래야 다른 사람에게 URL과 함께 데이터를 보낼 수 있다.
//
// : POST
//      - message-body 부분에 데이터가 있기 때문에
//        웹 브라우저는 캐시에 보관하지 않는다.
//      - 또한 주소 창에도 보이지 않는다.
//      - 사용자 암호 같은 데이터를 전송할 때는 특히 이 방식으로 보내는 것이 바람직하다.
//      - 거꾸로 특정 페이지를 조회하는 URL일 경우 POST 방식을 사용하면
//        URL에 조회하려는 정보의 번호나 키를 포함할 수 없기 때문에
//        이런 상황에서는 POST 방식이 적절하지 않다.
//        오히려 GET 방식이 적합하다.









