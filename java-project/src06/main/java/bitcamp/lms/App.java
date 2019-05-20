/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    final int LENGTH = 10;
    // 왜 변수가 바깥에 while문 블록 바깥으로 나왔을까?
    // 변수를 while문 블록 바깥에 선언한 이유
    // => 변수가 블록을 벗어나는 순간, 블록 바깥에서 그 변수를 사용할 수 없다.
    //    따라서 바깥쪽에서 변수를 선언하고 쓴다.
    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] contents = new String[LENGTH];
    Date[] startDate = new Date[LENGTH];
    Date[] endDate = new Date[LENGTH];
    int[] totalhours = new int[LENGTH];
    int[] dayhours = new int[LENGTH];
    
    int i = 0; // 인덱스 0부터시작
    while (i < LENGTH) {
    System.out.print("번호? ");
    no[i] = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("수업명? ");
    name[i] = keyboard.nextLine();
    
    System.out.print("수업내용? ");
    contents[i] = keyboard.nextLine();
    
    System.out.print("시작일? ");
    startDate[i] = Date.valueOf(keyboard.nextLine());
    
    System.out.print("종료일? ");
    endDate[i] = Date.valueOf(keyboard.nextLine());
    
    System.out.print("총수업시간? ");
    totalhours[i] = Integer.parseInt(keyboard.nextLine());
    
    System.out.println("일수업시간? ");
    dayhours[i] = Integer.parseInt(keyboard.nextLine());
    
    i++;
    
    System.out.print("\n계속 하시겠습니까?(Y/N) ");
    String answer = keyboard.nextLine().toLowerCase();
    // toLowerCase() 문자열을 소문자로 변환
    // answer 변수는 여기서 선언해도 바깥에서 쓸 이유가 없기 때문에
    // 안쪽에서 선언함으로써 다른곳에서 쓰지 않도록 코드 제약을 걸어줘도 무방.
    
    if (!answer.equals("y") && answer.length() > 0) {
      break;
      // if (!input.equalsIgnoreCase("Y") && !input.equals(""))
      //   break;
    }
   
    System.out.println();
  }
   
 
    keyboard.close(); // close는 마지막이니 바깥으로 빼준다.
    
    
    System.out.println();
    
    for (int j = 0; j < i; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n",
          no[j], name[j], startDate[j], endDate[j], totalhours[j]);
    // system.out.printf("%d, %s, %s ~ %s, %d\n",
    // no, name, startDate,endDate, totalHours);
      
    // int count = 0;
    // while (count < index) {
    //      system.out.printf("%d, %-20s, %s ~ %s, %4d\n",
    //          no[count],title[count], startDate[count], endDate[count], totalHours[count]);
    //      count++;
    // }
    }
  }
}    
/*
 1. 반복전 기존 문자열 조정
 2. 반복을 만드는 while문 조정
 3. 배열로 변경
 4. 세부사항 조정
 */
    /*
번호? 1
수업명? 자바 프로젝트 실습
수업내용? 자바 프로젝트를 통한 자바 언어 활용법 익히기
시작일? 2019-01-02
종료일? 2019-05-28
총수업시간? 1000
일수업시간? 8

계속 입력하시겠습니까?(Y/n) y

번호? 2
수업명? 자바 프로그래밍 기초
수업내용? 자바 언어 기초 문법을 학습하기
시작일? 2019-02-01
종료일? 2019-02-28
총수업시간? 160
일수업시간? 8

계속 입력하시겠습니까?(Y/n) y

번호? 3
수업명? 자바 프로그래밍 고급
수업내용? 디자인 패턴과 리랙토링 기법 학습하기
시작일? 2019-03-02
종료일? 2019-03-30
총수업시간? 160
일수업시간? 8

계속 입력하시겠습니까?(Y/n) n

1, 자바 프로젝트 실습     , 2019-01-02 ~ 2019-05-28, 1000
2, 자바 프로그래밍 기초    , 2019-02-01 ~ 2019-02-28,  160
3, 자바 프로그래밍 고급    , 2019-03-02 ~ 2019-03-30,  160
```
  */
    
  
   
