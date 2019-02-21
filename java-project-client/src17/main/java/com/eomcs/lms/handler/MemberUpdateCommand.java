package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {

  Scanner keyboard;
  MemberDao memberDao;

  public MemberUpdateCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {

    try {
      System.out.print("번호? ");
      Member member = new Member();
      String input = keyboard.nextLine();
      member.setNo(Integer.parseInt(input));

      System.out.printf("이름? ");
      if ((input = keyboard.nextLine()).length() > 0) 
        member.setName(input);

      System.out.printf("이메일? ");
      if ((input = keyboard.nextLine()).length() > 0)
        member.setEmail(input);

      System.out.printf("암호? ");
      if ((input = keyboard.nextLine()).length() > 0)
        member.setPassword(input);

      System.out.printf("사진? ");
      if ((input = keyboard.nextLine()).length() > 0)
        member.setPhoto(input);

      System.out.printf("전화? ");
      if ((input = keyboard.nextLine()).length() > 0)
        member.setTel(input);

      memberDao.update(member);

      System.out.println("데이터를 변경했습니다.");

    } catch (Exception e) {
      System.out.printf("데이터 저장 오류! : %s\n", e.getMessage());
    }
  }
}
