// JSON 콘텐트 입력받기 - @RestController
package bitcamp.app2;

import java.net.URLDecoder;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c05_3")
public class Controller05_3 {
  
  // 1) 요청 파라미터 값을 낱개로 입력 받기
  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/app2/c05_3/h1?no=1&title=ok&writer=kim&viewCount=100
  @RequestMapping(value="h1", produces="text/plain;charset=UTF-8")
  public Object handler1(
      int no,
      String title,
      String writer,
      int viewCount) {
    
    return String.format("%d,%s,%s,%d", no, title, writer, viewCount);
  }
 
  // 2) 요청 파라미터 값을 객체로 입력 받기
  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/app2/c05_3/h2?no=1&title=ok&writer=kim&viewCount=100
  @RequestMapping(value="h2", produces="text/plain;charset=UTF-8")
  public Object handler2(Board board) {
    
    return board.toString();
  }
 
  // 3) JSON 형식의 요청 파라미터 값을 통째로 문자열로 받기 
  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/html/app2/c05_3.html
  // 웹 환경에서 라우터 경로마다 설정된 유니코드가 달라지면 값이 깨질 수있다.
  // 따라서 보낼 때는 인코딩, 받을 때는 디코딩을 설정해서 값을 전송하라.
  @RequestMapping(value="h3", produces="text/plain;charset=UTF-8")
  public Object handler3(@RequestBody String content) throws Exception {
    // System.out.println(content); // 이렇게 직접 받지 말고 디코딩해라.
    System.out.println(URLDecoder.decode(content, "UTF-8"));
    return "OK!";
  }
  
  // 4) JSON 형식의 요청 파라미터 값을 맵 객체로 받기
  // => HttpMessageConverter 구현체(예:MappingJackson2HttpMessageConverter)가
  //      클라이언트가 보낸 데이터를 Map 객체에 담아준다. 따로 변환할 필요 없다.
  // => 이 기능을 쓰고 싶다면 Jackson 또는 GSON 라이브러리를 반드시 포함해야 한다.
  //      그래야 스프링의 DispatcherServlet에서 찾는다.
  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/html/app2/c05_3.html
  // 주의! Date 객체인 경우 String 문자열로 넘어온다.
  @RequestMapping(value="h4", produces="text/plain;charset=UTF-8")
  public Object handler4(@RequestBody Map<String,Object> content) throws Exception {
    System.out.println(content);
    return "OK!";
  }
  
  // 5) JSON 형식의 요청 파라미터 값을 도메인 객체로 받기
  // => HttpMessageConverter 구현체(예:MappingJackson2HttpMessageConverter)가
  //      클라이언트가 보낸 데이터를 도메인 객체(예:Board, Member, Lesson)에 담아준다.
  // => JSON 데이터의 프로퍼티명과 도메인 객체의 프로퍼티명이 일치해야 한다.
  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/html/app2/c05_3.html
  // 기본 타입이 아닌 타입은 변환이 안되서 에러가 뜬다.
  // 참고 : JSON 형태로 오는 경우 initBinder는 안 먹는다. 변수=값 형태로 올때만 된다.
  // 해결책 : 
  @RequestMapping(value="h5", produces="text/plain;charset=UTF-8")
  public Object handler5(@RequestBody Board content) throws Exception {
    System.out.println(content);
    
    // 주의!
    // => 클라이언트에서 보낸 날짜 데이터의 문자열 형식이 yyyy-MM-dd 형태여야 한다.
    //      그래야 java.util.Date 타입의 값으로 변환해 준다.
    //      예) 2019-05-01 ===> java.util.Date 객체 변환 성공
    // => 만약 이 형태가 아니면 변환할 수 없어 실행 오류가 발생한다.
    //      예) 2019-5-1 ===> 변환 오류!
    //
    // @JsonFormat 애노테이션 사용
    // => 이 애노테이션은 MappingJackson2HttpMessageConverter를 위한 것이다.
    //      GsonHttpMessageConverter는 이 애노테이션을 인식하지 않는다.
    // => 도메인 객체의 프로퍼티에(set프로퍼티, 필드) 이 애노테이션을 붙이면
    //      2019-05-01 이나 2019-5-1 모두 처리할 수 있다.
    // => 뿐만 아니라, 도메인 객체를 JSON 문자열로 변환할 때도 
    //      해당 형식으로 변환된다.
    //
    
    return "OK!";
  }
  
}
