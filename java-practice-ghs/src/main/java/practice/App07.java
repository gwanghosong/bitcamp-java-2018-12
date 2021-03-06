/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package practice;
//이렇게 통합
import java.sql.Date;
import java.util.Scanner;

public class App07 {
  static Scanner keyboard = new Scanner(System.in);
  //왜 static을 붙이냐? 여러 곳에 중복되서 실행할 거라 인스턴스 만들때마다 생기면
  // 메모리 낭비가 심해져서 static을 붙임.
  static final int LENGTH = 10;
  static Lesson[] lessons = new Lesson[LENGTH];
  static Member[] members = new Member[LENGTH];
  static Board[] boards = new Board[LENGTH];

  static int lessonIdx = 0;
  static int membersIdx = 0;
  static int boardIdx = 0;
  // main()메서드에서 한단계 위로 올린 이유?
  // public static void main(String[] args) { 안의 메서드는
  // 로컬 클래스이다.
  // 로컬 클래스는 특정 메서드 안에서만 사용가능하다.
  // 따라서 다른 메서드에서도 사용하기 위해 올린다.
  // static? 모든 인스턴스에서 같은 값을 유지되어야 하는 변수에 붙여준다. 이것때문
  // 또는 인스턴스 변수나 인스턴스 메서드를 사용하지 않는 메서드에 static을 붙일것을고려한다.

  public static void main(String[] args) {



    while (true) {
      // 가장 먼저해야 할 것 : 입력해야할 것 부터 입력
      String command = prompt();

      //입력 조건이 참일때만 이 명령을 실행
      if (command.equals("/lesson/add")) {
        addLesson();
      } else if (command.equals("/lesson/list")) {
        listLesson();
      } else if (command.equals("/member/add")) {
        addMember();
      } else if (command.equals("/lesson/list")) {
        listMember();
      } else if (command.equals("/board/add")) {
        addBoard();
      } else if (command.equals("/board/list")) {
        listBoard();
      } else if (command.contentEquals("quit")) {
        System.out.println("안녕!");
        break;
        // 조건에 맞는 것이 없는 경우, 그 밖의 경우 else { 출력문 }
      } else {
        System.out.println("실행할 수 없는 명령입니다");
      }

      System.out.println(); // 빈 줄 출력
    }

    keyboard.close();
  }
  static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine();
  }
  static void listBoard() {
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards[j].no, boards[j].contents, 
          boards[j].createdDate, boards[j].viewCount);
    }
  }
  static void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("내용? ");
    board.contents = keyboard.nextLine();

    board.createdDate = new Date(System.currentTimeMillis()); 

    board.viewCount = 0;

    boards[boardIdx++] = board;

    System.out.println("저장하였습니다.");
  }

  static void listMember() {
    for (int j = 0; j < membersIdx; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          members[j].no, members[j].name, 
          members[j].email, members[j].tel, 
          members[j].registeredDate);
    }
  }

  static void addMember() { 
    Member member = new Member();

    System.out.print("번호? ");
    member.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("이름? ");
    member.name = keyboard.nextLine();

    System.out.print("이메일? ");
    member.email = keyboard.nextLine();

    System.out.print("암호? ");
    member.password = keyboard.nextLine();

    System.out.print("사진? ");
    member.photo = keyboard.nextLine();

    System.out.print("전화? ");
    member.tel = keyboard.nextLine();

    member.registeredDate = new Date(System.currentTimeMillis()); 

    members[membersIdx++] = member;

    System.out.println("저장하였습니다.");
  }

  static void listLesson() {
    for (int j = 0; j < lessonIdx; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lessons[j].no, lessons[j].title, 
          lessons[j].startDate, lessons[j].endDate, 
          lessons[j].totalHours);
    }
  }

  static void addLesson() { //왜 class가 아닌가? 클래스 필드에 메서드타입의 변수를 만들기때문
    // void는 왜? 메서드의 리턴값이 int, byte 같은 리턴값이 아니기 때문에 void씀
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("수업명? ");
    lesson.title = keyboard.nextLine();

    System.out.print("설명? ");
    lesson.contents = keyboard.nextLine();

    System.out.print("시작일? ");
    lesson.startDate = Date.valueOf(keyboard.nextLine());

    System.out.print("종료일? ");
    lesson.endDate = Date.valueOf(keyboard.nextLine());

    System.out.print("총수업시간? ");
    lesson.totalHours = Integer.parseInt(keyboard.nextLine());

    System.out.print("일수업시간? ");
    lesson.dayHours = Integer.parseInt(keyboard.nextLine());

    lessons[lessonIdx++] = lesson;
    // 저장하였습니다.로 수정
    System.out.println("저장하였습니다.");

    // if가 아니라면 이 조건이 참일 때 이것을 실행. 즉 분기문!
  }
}
