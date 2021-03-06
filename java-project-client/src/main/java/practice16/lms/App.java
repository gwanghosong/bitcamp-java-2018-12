// 15단계: 여러 클라이언트 요청을 처리할 때의 문제점과 해결책(멀티 스레드 적용)
package practice16.lms;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import practice16.lms.dao.mariadb.BoardDaoImpl;
import practice16.lms.dao.mariadb.LessonDaoImpl;
import practice16.lms.dao.mariadb.MemberDaoImpl;
import practice16.lms.handler.BoardAddCommand;
import practice16.lms.handler.BoardDeleteCommand;
import practice16.lms.handler.BoardDetailCommand;
import practice16.lms.handler.BoardListCommand;
import practice16.lms.handler.BoardUpdateCommand;
import practice16.lms.handler.Command;
import practice16.lms.handler.LessonAddCommand;
import practice16.lms.handler.LessonDeleteCommand;
import practice16.lms.handler.LessonDetailCommand;
import practice16.lms.handler.LessonListCommand;
import practice16.lms.handler.LessonUpdateCommand;
import practice16.lms.handler.MemberAddCommand;
import practice16.lms.handler.MemberDeleteCommand;
import practice16.lms.handler.MemberDetailCommand;
import practice16.lms.handler.MemberListCommand;
import practice16.lms.handler.MemberUpdateCommand;

public class App {

  Scanner keyboard = new Scanner(System.in);
  Stack<String> commandHistory = new Stack<>();
  Queue<String> commandHistory2 = new LinkedList<>();

  public void service() {

    Map<String,Command> commandMap = new HashMap<>();

    LessonDaoImpl lessonDao = new LessonDaoImpl("192.168.0.31", 8888, "/lesson");
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonDao));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonDao));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonDao));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonDao));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonDao));

    MemberDaoImpl memberDao = new MemberDaoImpl("192.168.0.31", 8888, "/member");
    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberDao));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberDao));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberDao));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberDao));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberDao));

    BoardDaoImpl boardDao = new BoardDaoImpl();
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardDao));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardDao));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardDao));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardDao));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardDao));

    while (true) {
      String command = prompt();
      
      commandHistory.push(command);
      commandHistory2.offer(command);

      if (command.equals("quit")) {
        System.out.println("종료합니다.");
        break;
        
      } else if (command.equals("history")) {
        printCommandHistory();
        continue;
        
      } else if (command.equals("history2")) {
        printCommandHistory2();
        continue;
      } 
      
      // 사용자가 입력한 명령으로 Command 객체를 찾는다.
      Command commandHandler = commandMap.get(command);
      if (commandHandler == null) {
        System.out.println("실행할 수 없는 명령입니다.");
        continue;
      }
      
      // stateful을 stateless로 전환할 때 주의할 점!
      // => 가능한 서버에 요청하는 시점에 서버와 연결하라!
      // => 이 클래스에서 서버와 연결하지 않고 
      //    데이터를 요청하는 일을 하는 객체(*Agent)에 서버 연결을 맡긴다. 
      try {
        commandHandler.execute();
        System.out.println(); 

      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
      }
    }
    
    keyboard.close();
  }
  
  @SuppressWarnings("unchecked")
  private void printCommandHistory() {
    Stack<String> temp = (Stack<String>) commandHistory.clone();

    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  }

  @SuppressWarnings("unchecked")
  private void printCommandHistory2() {
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  private String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }

  public static void main(String[] args) {
    App app = new App();

    // App 을 실행한다.
    app.service();
  }
}
