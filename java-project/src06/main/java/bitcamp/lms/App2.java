/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

import java.util.Scanner;
import java.sql.Date;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new java.util.Scanner(System.in);
    
    final int LENGTH = 10;
    
    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    int[] password = new int[LENGTH];
    String[] picture = new String[LENGTH];
    String[] phoneNumber = new String[LENGTH];
    Date[] enterDate = new Date[LENGTH];
    
    int i = 0;
    
    while (i < LENGTH) {
    System.out.print("번호? ");
    no[i] = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("이름? ");
    name[i] = keyboard.nextLine();
    
    System.out.print("이메일? ");
    email[i] = keyboard.nextLine();
    
    System.out.print("암호? ");
    password[i] = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("사진? ");
    picture[i] = keyboard.nextLine();
    
    System.out.print("전화? ");
    phoneNumber[i] = keyboard.nextLine();
    
    System.out.print("가입일? ");
    enterDate[i] = Date.valueOf(keyboard.nextLine());
    
    i++;
    
    System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
    String answer = keyboard.nextLine().toLowerCase();
    
    if (!answer.equals("y") && answer.length() > 0) {
      break;
    }
    
    System.out.println();
    
    }
    keyboard.close();
    
    System.out.println();
    
    for (int j = 0; j < i; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          no[j], name[j], email[j], phoneNumber[j], enterDate[j]);
    }
    
/*
번호? 1
이름? 홍길동
이메일? hong@test.com
암호? 1111
사진? hong.png
전화? 1111-2222

번호: 1
이름: 홍길동
이메일: hong@test.com
암호: 1111
사진: hong.png
전화: 1111-2222
가입일: 2019-01-01
 */
    }
}
