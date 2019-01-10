/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package practice;

import java.util.Scanner;
import java.sql.Date;
import practice.Lesson;

public class App06 {
    public static void main(String[] args) {

      Scanner keyboard = new Scanner(System.in);
      
      Lesson[] lessons = new Lesson[100]; // Lesson 클래스로 만들 예정인 인스턴스들을
      //가리키는 레퍼런스들의 주소를 가리키는 lessons라는 레퍼런스배열생성

      int index = 0;


      while (index < 100) {
        
        Lesson l1; // lesson 클래스의 레퍼런스를 l1이라 선언하고
        l1 = new Lesson(); // lesson 클래스 레퍼런스의 인스턴스를 만들고 그 주소를 
        // l1 레퍼런스에 저장한다.
        
      System.out.print("번호? ");
      l1.no = Integer.parseInt(keyboard.nextLine()); // l1클래스의 no인스턴스변수에 값저장
      
      System.out.print("수업명? ");
      l1.title = keyboard.nextLine();
      
      System.out.print("설명? ");
      l1.contents = keyboard.nextLine();
      
      System.out.print("시작일? ");
      l1.startDate = Date.valueOf(keyboard.nextLine());
      
      System.out.print("종료일? ");
      l1.endDate = Date.valueOf(keyboard.nextLine());
      
      System.out.print("총수업시간? ");
      l1.totalHours = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("일수업시간? ");
      l1.dayHours = Integer.parseInt(keyboard.nextLine());

      System.out.print("\n계속 입력하시겠습니까?(Y/n)? ");
      String input = keyboard.nextLine();
      
      lessons[index] = l1; // l1레퍼런스주소에 저장된 인스턴스 주소값을 lessons[지금 해당하는 index]
      // 레퍼런스 배열의 레퍼런스에 저장.

      index++; //그리고 index를 index++해줌.

      System.out.println();

      if (!input.equalsIgnoreCase("y"))
        break;
      }
      keyboard.close();
      
      System.out.println(); 

      int count = 0;
      
      while (count < index) {
      System.out.printf("%d, %-15s, %s ~ %s, %d\n",
          lessons[count].no, lessons[count].title, lessons[count].startDate, 
          lessons[count].endDate, lessons[count].totalHours);
          count++;
      }
    }
  }