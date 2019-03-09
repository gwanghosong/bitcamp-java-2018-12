// 12단계: 커넥션풀(Flyweight 디자인 패턴 응용)을 이용하여 커넥션 객체를 재활용하기
// => 클라이언트 요청을 처리할 때마다 매번 DB 커넥션을 생성한다면 
//    DB 커넥션 생성에 비용(실행시간, 메모리)이 많이 든다.
// => 해결책?
//    DB 커넥션을 생성한 다음에 버리지 말고 보관했다가 다시 사용하는 것이다.
// 
// 작업:
// 1) ConnectionFactory 클래스의 이름을 DataSource로 변경한다.
//    - 생성된 커넥션들을 관리하도록 코드를 변경한다.
//    - 커넥션을 반납하는 returnConnection() 메서드를 추가한다.
// 2) DAO 구현체를 변경한다.
//    - DataSource 객체를 의존 객체로 지정한다.
//    - 생성자에서 DataSource 객체를 받는다.
//    - 각 메서드는 DataSource 객체를 통해 커넥션을 받는다.
// 3) ApplicationInitializer 변경
//    - DataSource 객체 생성
//    - DAO에 DataSource 객체 주입
// 
package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.handler.Command;

public class ServerApp {

  // ApplicationContextListener(옵저버) 목록을 보관할 객체
  ArrayList<ApplicationContextListener> listeners = new ArrayList<>();

  // 인스턴스 필드를 공통으로 공용하는 저장소
  HashMap<String,Object> context = new HashMap<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void service() throws Exception {

    try (ServerSocket ss = new ServerSocket(8888)) {

      // 애플리케이션을 시작할 때, 등록된 리스너에게 알려준다.
      for (ApplicationContextListener listener : listeners) {
        listener.contextInitialized(context);
      }

      System.out.println("서버 실행 중...");

      while (true) {

        new RequestHandlerThread(ss.accept()).start();

      } // while

      // 애플리케이션을 종료할 때, 등록된 리스너에게 알려준다.
      // 현재 while문은 종료 조건이 없기 때문에 다음 문장을 실행할 수 없다.
      // 따라서 주석으로 처리한다.
      //      for (ApplicationContextListener listener : listeners) {
      //        listener.contextDestroyed(context);
      //      }

    } catch (Exception e) {
      e.printStackTrace();
    } // try(ServerSocket)

  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp();

    // App이 실행되거나 종료될 때 보고를 받을 옵저버를 등록한다.
    app.addApplicationContextListener(new ApplicationInitializer());

    // App 을 실행한다.
    app.service();
  }

  // 바깥 클래스(ServerApp)의 인스턴스 필드(context)를 사용해야 한다면 
  // Inner 클래스(non-static nested class)로 정의하라!
  // 메서드가 static 필드를 사용하면 static 붙이고
  // 인스턴스 필드 사용하면 안 붙이는 거랑 비슷
  // static 붙이면 context 오류남 
  class RequestHandlerThread extends Thread {

    Socket socket;

    public RequestHandlerThread(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {

      try (Socket socket = this.socket;
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream())) {

        // 클라이언트의 요청 읽기
        String request = in.readLine();

        // 클라이언트에게 응답하기
        Command commandHandler = (Command) context.get(request);


        if (commandHandler == null) {
          out.println("실행할 수 없는 명령입니다.");
          out.println("!end!");
          out.flush();
          return;
        }

        try {
          commandHandler.execute(in, out);
          // 클라이언트 요청을 처리한 후 커넥션을 통해 작업한 것을 최종 완료한다.
        } catch (Exception e) {
          out.printf("실행 오류! : %s\n", e.getMessage());
        }

        out.println("!end!");
        out.flush();

      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        e.printStackTrace();

      }
    }
  }
}









