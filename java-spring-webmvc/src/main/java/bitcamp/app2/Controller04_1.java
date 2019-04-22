// 스프링 인터셉터 다루기
package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/c04_1")
public class Controller04_1 {

  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/app2/c04_1/h1
  @GetMapping(value="h1")
  public String handler1() {
    System.out.println("c04_1.handler1() 호출");
    return "c04_1";
  }
  
  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/app2/c04_1/a/h2
  @GetMapping(value="a/h2")
  public String handler2() {
    System.out.println("c04_1.handler2() 호출");
    return "c04_1";
  }
  
  // 테스트:
  //      http://localhost:8080/java-spring-webmvc/app2/c04_1/b/h3
  @GetMapping(value="b/h3")
  public String handler3() {
    System.out.println("c04_1.handler3() 호출");
    return "c04_1";
  }
}
