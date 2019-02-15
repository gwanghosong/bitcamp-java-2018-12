// RMI 기술 사용하기 - 원격 객체를 RMI 레지스트리 서버에 등록하기
package design_pattern.proxy.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObjectServer {

  public static void main(String[] args) {
    // [실행 방법] 
    // 1) 먼저 RMI regestry 서버를 실행하라!
    //     > rmiregistry
    // 주의! RMI Registry 서버가 클래스를 찾을 수 있도록 .class 파일이 있는 디렉토리에서 실행하라.
    // java-basic/bin/main> rmiregistry
    // 2) 그리고 이 클래스를 실행한다!
    
    // [원격 객체를 사용할 수 있도록 RMI registry 서버에 등록하는 방법]
    // 1) 보안 관리자 등록
    // : 원격에서 접속할 때 사용할 수 있는 자원의 범위를 통제하는 객체
    // 로컬에서 테스트를 위해 주석을 막는다.
//    if (System.getSecurityManager() == null) {
//      System.setSecurityManager(new SecurityManager());
//    }

    try {
      // 2) 원격 객체(실제 일을하는 객체) 생성
      Calculator calcObj = new CalculatorImpl();

      // 3) 원격 객체와 통신을 담당할 프록시(클라이언트측 ORB)를 생성한다.
      // 첫번째 파라미터: 원격 객체
      // 두번째 파라미터: 포트 번호, 0으로 지정하면 임의의 유효한 포트번호가 지정된다.
      // 이렇게 RMI 기술을 사용하면 개발자가 skeleton(서버측 ORB)이나 
      // stub(클라이언트측 ORB)을 작성할 필요가 없다. 
      Calculator stub = (Calculator) UnicastRemoteObject.exportObject(calcObj, 0);

      // 4) RMI Registry 서버를 다룰 도구를 준비한다. registry : 등록기
      Registry registry = LocateRegistry.getRegistry("study.bitcamp.co.kr");

      // 5) Registry 도구를 사용하여 RMI registry 서버에 stub을 등록한다.
      // rebind() : 해당 이름으로 스텁 객체를 등록한다.
      //                 만약 그 이름으로 등록된 스텁이 있다면 기존에 등록된 스텁 객체를 대체한다.
      // bind() : 해당 이름으로 스텁 객체를 등록한다.
      //              만약 그 이름으로 등록된 스텁이 있다면 예외가 발생한다.
      //
      registry.rebind("calc", stub);

      System.out.println("Calculator 객체의 프록시(stub)가 RMI Registry 서버에 등록되었다.");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}

/*
 Calculator stub = (Calculator) UnicastRemoteObject.exportObject(calcObj, 0);
 stub 자체를 생성할 때 calcobj 즉 server의 인터페이스를 구현한 객체를 원격 객체로하고
 그 원격 객체가 있는 포트번호를 지정해서 생성한다.
 따라서 그 stub 객체는 lookup으로 풀릴 때 원격 객체로 향하게하는 인스턴스를 리턴하는데
 그 인스턴스가 server의 인터페이스를 구현한 객체를 향하게 하기 때문에
 만약 client.App에 있는 stub을 받는 것을 client에서 동일 규칙으로 인스턴스를 만들어
 받으려고하면 컴파일러는 속이지만, JVM은 못 속이는 형변환 오류가 발생하는 것이다.
 */
