package practice16.lms.handler;
import java.util.List;
import java.util.Scanner;
import practice16.lms.dao.MemberDao;
import practice16.lms.domain.Member;

public class MemberListCommand implements Command {
  
  Scanner keyboard;
  MemberDao memberDao;
  
  public MemberListCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }
  
  @Override
  public void execute() {
    try {
      List<Member> members = memberDao.findAll();
      for (Member member : members) {
        System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
            member.getNo(), member.getName(), 
            member.getEmail(), member.getTel(), member.getRegisteredDate());
      }
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
