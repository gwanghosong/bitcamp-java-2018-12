package practice.lms.handler;
import java.util.List;
import java.util.Scanner;
import practice.lms.domain.Board;

public class BoardListCommand implements Command {
  
  Scanner keyboard;
  
  public BoardListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute() {
    Board[] boards = list.toArray(new Board[] {});
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
    }
  }

}
