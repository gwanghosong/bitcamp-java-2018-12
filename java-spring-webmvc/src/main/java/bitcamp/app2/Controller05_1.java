// JSON 콘텐트 출력하기
package bitcamp.app2;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

@Controller 
@RequestMapping("/c05_1")
public class Controller05_1 {
  
  ArrayList<Board> list = new ArrayList<>();

  public Controller05_1() {
    list.add(new Board(1, "제목입니다1", "내용1", "홍길동1", 10, Date.valueOf("2019-5-1")));
    list.add(new Board(2, "제목입니다2", "내용2", "홍길동2", 11, Date.valueOf("2019-5-2")));
    list.add(new Board(3, "제목입니다3", "내용3", "홍길동3", 12, Date.valueOf("2019-5-3")));
    list.add(new Board(4, "제목입니다4", "내용4", "홍길동4", 13, Date.valueOf("2019-5-4")));
    list.add(new Board(5, "제목입니다5", "내용5", "홍길동5", 14, Date.valueOf("2019-5-5")));
    list.add(new Board(6, "제목입니다6", "내용6", "홍길동6", 15, Date.valueOf("2019-5-6")));
    list.add(new Board(7, "제목입니다7", "내용7", "홍길동7", 16, Date.valueOf("2019-5-7")));
    list.add(new Board(8, "제목입니다8", "내용8", "홍길동8", 17, Date.valueOf("2019-5-8")));
    list.add(new Board(9, "제목입니다9", "내용9", "홍길동9", 18, Date.valueOf("2019-5-9")));
    list.add(new Board(10, "제목입니다10", "내용10", "홍길동10", 19, Date.valueOf("2019-5-10")));
    list.add(new Board(11, "제목입니다11", "내용11", "홍길동11", 20, Date.valueOf("2019-5-11")));
    list.add(new Board(12, "제목입니다12", "내용12", "홍길동12", 21, Date.valueOf("2019-5-12")));
    list.add(new Board(13, "제목입니다13", "내용13", "홍길동13", 22, Date.valueOf("2019-5-13")));
  }
  
  // 1) JSP에서 JSON 형식의 콘텐트 출력하기 I
  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/app2/c05_1/h1
  @GetMapping("h1")
  public void handler1(Model model) {
    model.addAttribute("list", this.list);
  }
  
  // 2) Google GSON 라이브러리 사용하여 JSON 형식의 콘텐트 출력하기
  // => mvnrepository.com에서 GSON 검색하여 라이브러리 정보를 가져온다.
  // => build.gradle에 추가한다.
  // => '$ gradle eclipse' 실행한다.
  // => 이클립스에서 프로젝트를 리프레시 한다.
  // => Referenced Libraries에 정상적으로 들어왔는지 확인한다.
  //
  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/app2/c05_1/h2
  @GetMapping(value="h2", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2() {
    return new Gson().toJson(this.list);
  }
  
  // 3) Google GSON 라이브러리 사용하여 JSON 형식의 콘텐트 출력하기 II
  // => 페이지 컨트롤러의 리턴 값이 String이 아니면
  //      프론트 컨트롤러는 Google GSON 라이브러리나 Jackson 라이브러리를 사용하여
  //      자동으로 JSON 형식의 문자열로 만들어 클라이언트로 출력한다.
  // => 단 GSON 또는 Jackson 라이브러리가 있어야 한다.
  //      둘 다 있다면 Jackson 라이브러리가 사용된다.
  // => 아래 주석을 참고하라!
  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/app2/c05_1/h3
  // 테스트할 때는 이 Jackson Databind라이브러리는 주석 처리하고 이 라이브러리만 gradle eclipse해서 테스트하라.
  @GetMapping("h3") // JSON 형식의 문자열은 자동으로 UTF-8로 인코딩된다.
  @ResponseBody
  public Object handler3() {
    return this.list;
  }
  
  // 4) Jackson Databind 라이브러리 사용하여 JSON 형식의 콘텐트 출력하기
  // => 페이지 컨트롤러의 리턴 값이 String이 아니면
  //      프론트 컨트롤러는 Google GSON 라이브러리나 Jackson 라이브러리를 사용하여
  //      자동으로 JSON 형식의 문자열로 만들어 클라이언트로 출력한다.
  // => 단 GSON 또는 Jackson 라이브러리가 있어야 한다.
  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/app2/c05_1/h4
  // 테스트할 때는 이 GSON라이브러리는 주석 처리하고 이 라이브러리만 gradle eclipse해서 테스트하라.
  // 이 라이브러리는 Date 타입이 밀리세컨드로 표현된다.
  // 이 밀리세컨드를 자바스크립트를 이용하여 변환해서 사용하라.
  @GetMapping("h4") // JSON 형식의 문자열은 자동으로 UTF-8로 인코딩된다.
  @ResponseBody
  public Object handler4() {
    return this.list;
  }
  
  // JSON 형식을 다루는 라이브러리
  // @Controller가 붙은 일반적인 페이지 컨트롤러의 요청 핸들러를 실행할 때
  // 요청 파라미터의 문자열을 int나 boolean 등으로 바꾸기 위해
  // 기본으로 장착된 변환기를 사용한다.
  // 그 변환기는 HttpMessageConverter 규칙에 따라 만든 변환기이다.
  // 
  // 그런데 어떤 타입의 리턴 값을 문자열로 만들어 클라이언트로 출력할 때도 
  // 이 HttpMessageConverter를 사용한다.
  // 즉 클라인트가 보낸 파라미터 값을 핸들러의 아규먼트 타입으로 바꿀 때도 이 변환기를 사용하고
  // 핸들러의 리턴 값을 클라이언트로 보내기 위해 문자열로 바꿀 때도 이 변환기를 사용한다. 
  // 
  // spring-web-5.1.6.RELEASE.jar/org.springframwork.http/converter/json/...
  // 스프링이 사용하는 기본 데이터 변환기는 MappingJackson2HttpMessageConverter이다.
  // 만약 이 변환기가 없다면 Google의 GSON 변환기를 사용한다.
  // Google의 GSON 변환기 마저 없다면 컨버터가 없다는 예외를 발생시킨다.
  // 이 컨버터가 하는 일은 JSON 데이터로 변환하는 것이다.
  //      클라이언트가 보낸 JSON 요청 파라미터 ==> 자바 객체
  //      핸들러의 리턴하는 자바 객체 ==> JSON 형식의 문자열
  // MappingJackson2HttpMessageConverter를 사용하려면
  // Jackson Databind 의존 라이브러리를 추가해야 한다.
  // GsonHttpMessageConverter를 사용하려면 
  // Google GSON 의존 라이브러리를 추가해야 한다.
  // 만약 동시에 추가한다면 기본으로 Jackson Databind 라이브러리를 사용해야 한다.
  //
  // MappingJackson2HttpMessageConverter?
  // => 요청 파라미터로 JSON 문자열을 받으면 요청 핸들러를 호출할 때 자바 객체로 변환시킨다.
  // => 요청 핸들러가 자바 객체를 리턴할 때 JSON 문자열로 변환한다.
  //
  // 주의!
  // => MappingJackson2HttpMessageConverter를 사용하려면 
  //    다음과 같이 의존하는 라이브러리를 추가해야 한다.
  // 
  // compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.9.8'
  
  // => 그런데 JSON 데이터를 처리할 때
  //    MappingJackson2HttpMessageConverter 대신 GsonHttpMessageConverter 를 사용할 수 있다.
  //    단 GsonHttpMessageConverter를 사용하려면 
  //    다음과 같이 이 클래스가 들어있는 의존 라이브러리를 추가해야 한다.
  // => 만약 동시에 추가한다면 기본으로 Jackson 라이브러리를 사용한다. 
  // 
  // Jackson Databind 라이브러리 추천.
}
