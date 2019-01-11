package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;
    Member[] members = new Member[LENGTH];

    int i = 0;
    while (i < LENGTH) {
      System.out.print("명령> ");
      String command = keyboard.nextLine();

      if (command.equals("/member/add")) {
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

        members[i++] = member;

        System.out.println("저장하였습니다.");

      } else if (command.equals("/lesson/list")) {
        for (int j = 0; j < i; j++) {
          System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
              members[j].no, members[j].name, 
              members[j].email, members[j].tel, 
              members[j].registeredDate);
        }

      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println();
    }

    keyboard.close();
  }
}
