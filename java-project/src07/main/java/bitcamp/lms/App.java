/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.Lesson;

public class App {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    final int LENGTH = 10;
    /*
     * Lesson 인스턴스의 주소를 담을 레퍼런스를 먼저 100개 생성하고
     * Lesson 형태의 인스턴스 메모리를 저장할 메모리를 생성한다.
     * Lesson lesson1 = new Lesson[LENGTH];
     * Lesson lesson2 = new Lesson[LENGTH];
     * Lesson lesson3 = new Lesson[LENGTH];
     * Lesson lesson4 = new Lesson[LENGTH];
     * Lesson lesson5 = new Lesson[LENGTH];
      * .....
     * Lesson lesson100 = new Lesson[LENGTH];
     너무 힘들어
     
     */
    // Lesson 인스턴스의 주소를 담을 레퍼런스를 먼저 100개 생성한다.
    // 레퍼런스들을 저장할 레퍼런스배열을 만들자
    Lesson[] lessons = new Lesson[LENGTH];
    
    // for (int = 0; size < lessons.length; size++)
   //   lessons[size] = new Lesson();
    // 이런 형태도 가능
    // 미리 메모리를 만들면 메모리 손해가 생겨
    // 안좋은방식이야
    
    int size = 0; // 인덱스 0부터시작
    while (size < LENGTH) {
      Lesson lesson = new Lesson(); // l1 안하는 이유? 직관적이지 않아서
      // lesson 레퍼런스를 만들고 거기에 이어진 인스턴스 메모리를 생성.
      System.out.print("번호? ");
      lesson.no = Integer.parseInt(keyboard.nextLine());
    // lesson객체에 no에 값을 넣어.
      // lesson이 가리키는 객체, 저장된 주소, 인스턴스로 찾아가서
      // no, 즉 no이라는 인스턴스의 한 변수인 인스턴스 필드에 들어가는 값을 넣어라. 
      System.out.print("수업명? ");
      lesson.name = keyboard.nextLine();
    
      System.out.print("수업내용? ");
      lesson.contents = keyboard.nextLine();
    
      System.out.print("시작일? ");
      lesson.startDate = Date.valueOf(keyboard.nextLine());
    
      System.out.print("종료일? ");
      lesson.endDate = Date.valueOf(keyboard.nextLine());
    
      System.out.print("총수업시간? ");
      lesson.totalHours = Integer.parseInt(keyboard.nextLine());
    
      System.out.println("일수업시간? ");
      lesson.dayHours = Integer.parseInt(keyboard.nextLine());

      // lesson객체의 인스턴스필드 값을 다 저장했으면
      // lesson 객체의 레퍼런스주소 값을 lessons라는 레퍼런스배열에
      // 입력함으로써 주소를 통해 인스턴스메모리를 lessons와 연결
      // 그리고  두 문장을 합쳐서 하나로 가능
      // lessons 레퍼런스배열의 i라는 인덱스 메모리에 lesson의 주소를 저장하고
      // i변수증가
      // lessons[size] = lesson; 
      // size++;
      lessons[size++] = lesson;
    
      System.out.print("\n계속 하시겠습니까?(Y/N) ");
      String answer = keyboard.nextLine().toLowerCase();
    
      if (!answer.equals("y") && answer.length() > 0) {
        break;
    }
   
    System.out.println();
  }
   
 
    keyboard.close(); 
    
    
    System.out.println();
    // 배열에 입력한 개수만큼 출력한다.
    for (int i = 0; i < size; i++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n",
          lessons[i].no, lessons[i].name, 
          lessons[i].startDate, lessons[i].endDate, 
          lessons[i].totalHours);
    }
  }
}    
