package practice.lms.handler;
import java.util.List;
import java.util.Scanner;
import practice.lms.domain.Member;

public class MemberListCommand implements Command {
  
  Scanner keyboard;
  
  public MemberListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute() {
    Member[] members = list.toArray(new Member[] {});
    for (Member member : members) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          member.getNo(), member.getName(), 
          member.getEmail(), member.getTel(), member.getRegisteredDate());
    }
  }
}
