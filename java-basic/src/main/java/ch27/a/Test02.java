// 여러 개의 인터페이스를 구현한 객체를 자동으로 생성하기
package ch27.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test02 {

  public static void main(String[] args) {

    // Calculator, Calculator2, Calculator3 인터페이스를 구현한 클래스를 만들고 그 인스턴스를 생성하여 리턴한다.
    Object proxy = (Calculator) Proxy.newProxyInstance(
        Test02.class.getClassLoader(), 
        // 엔터프라이즈용 프로그램, 복수의 서버로 이루어진 프로그램들은 디렉토리마다 클래스로더를 따로 만들 수 있다.
        // 이런 상황에서 인터페이스 정보를 읽어오는데 JVM에 내장된 클래스 로더가 아니라 다른 서버의 클래스정보를 읽어오는
        // 클래스로더는 Test02가 아닌 복수의 다른 클래스로더가 올 수도 있다.
        // 그런 상황이 있을 수도 있기 때문에 클래스로더를 설정해 놓는 것이다.
        // 평범한 자바 프로그램이 아닌 프레임워크, 대단위 프로그램 개발을 할때 사용하는 함수이다.
        // 단순 프로그램은 JVM이 가지고 있는 클래스 로더는 하나
        // 그 클래스 로더를 사용하기 위한 정보를 얻어내는 것
        // 따라서 Test02, Calculator 둘다 사용이 가능
        new Class[] {Calculator.class, Calculator2.class, Calculator3.class}, 
        new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            int a = (int) args[0]; // auto-unboxing ((Integer)args[0]).intValue();
            int b = (int) args[1];
            switch (method.getName()) {
              case "plus":
                return a + b;
              case "minus":
                return a - b;
              case "multiple":
                return a * b;
              case "divide" :
                return a / b;
              case "mod" :
                return a % b;
            }
            return 0; // Integer.valueOf(0); auto-boxing
          }
        });
    
    Calculator c1 = (Calculator) proxy;
    Calculator2 c2 = (Calculator2) proxy;
    Calculator3 c3 = (Calculator3) proxy;
    
    System.out.println(c1.plus(10, 20)); // c1 객체에 대해 plus를 호출하면 invoke 메서드가 호출되면서 실행.
    System.out.println(c1.minus(10, 20));
    System.out.println(c2.multiple(10, 20));
    System.out.println(c2.divide(10, 20));
    System.out.println(c3.mod(10, 20));
  }
}
