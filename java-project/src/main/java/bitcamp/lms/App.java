/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

public class App {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    System.out.print("번호? ");
    int no = keyboard.nextInt();
    
    keyboard.nextLine();
    
    System.out.print("수업명? ");
    String name = keyboard.nextLine();
    
    System.out.print("수업내용? ");
    String contents = keyboard.nextLine();
    
    System.out.print("시작일? ");
    String startday = keyboard.nextLine();
    
    System.out.print("종료일? ");
    String endday = keyboard.nextLine();
    
    System.out.print("총수업시간? ");
    int totalhours = keyboard.nextInt();
    
    System.out.println("일수업시간? ");
    int dayhours = keyboard.nextInt();
    
    System.out.printf("번호: %d\n", no);
    System.out.printf("수업명: %s\n", name);
    System.out.printf("수업내용: %s\n", contents);
    System.out.printf("기간: %s ~ %s\n", startday, endday);
    System.out.printf("총수업시간: %d\n", totalhours);
    System.out.printf("일수업시간: %d\n", dayhours);
    
    
    /*
        번호? 1
        수업명? 자바 프로젝트 실습
        수업내용? 자바 프로젝트를 통한 자바 언어 활용법 익히기
        시작일? 2019-01-02
        종료일? 2019-05-28
        총수업시간? 1000
        일수업시간? 8

        번호: 1
        수업명: 자바 프로젝트 실습
        수업내용: 자바 프로젝트를 통한 자바 언어 활용법 익히기
        기간: 2019-01-02 ~ 2019-05-28
        총수업시간: 1000 시간
        일수업시간: 8 시간
  */
    
  
    }
}
