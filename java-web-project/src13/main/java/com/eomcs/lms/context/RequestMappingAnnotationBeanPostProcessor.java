package com.eomcs.lms.context;

import java.lang.reflect.Method;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

// BeanPostProcessor 객체는 스프링 IoC 컨테이너가 인스턴스를 생성할 때마다 보고 받는다.
// 스프링 IoC 컨테이너로부터 인스턴스가 생성되었다고 보고를 받으면,
// 생성된 인스턴스의 클래스를 조사하여 @RequestMapping이 붙은 메서드를 찾는다.
// 그리고 RequestMappingHandlerMapping 객체에 기록한다.
// 이렇게 기록된 메서드는 클라이언트로부터 명령어가 들어 왔을 때 호출될 것이다.
// 보고 받고 싶으면 Spring IoC 컨테이너에 BeanPostProcessor 인터페이스를 구현한 클래스의 객체를 등록하라!
@Component 
public class RequestMappingAnnotationBeanPostProcessor implements BeanPostProcessor {

  RequestMappingHandlerMapping handlerMapping;

  // Spring IoC 컨테이너에 등록된 객체라면 생성자 만들 때 파라미터를 선언한 값을 자동 주입받는다.
  // @Autowired 안붙여도 주입해줌.
  public RequestMappingAnnotationBeanPostProcessor(
      RequestMappingHandlerMapping handlerMapping) {
    this.handlerMapping = handlerMapping;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    // 각 객체에 대해 @RequestMapping 메서드를 찾는다.
    Method[] methods = bean.getClass().getMethods();
    for (Method m : methods) {
      RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
      if (requestMapping == null)
        continue;

      // RequestMapping이 붙은 메서드를 찾았으면 그 정보를 RequestMappingHandler에 담는다.
      RequestMappingHandler handler = new RequestMappingHandler(bean,m);

      // 그리고 이 요청 핸들러(RequestMapping 애노테이션이 붙은 메서드)를 저장한다.
      handlerMapping.add(requestMapping.value(), handler);
      //System.out.println(requestMapping.value());
    }
    return bean;
  }
}
