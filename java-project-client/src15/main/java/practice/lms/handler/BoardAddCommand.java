package practice.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.Scanner;
import practice.lms.domain.Board;

public class BoardAddCommand implements Command {

  Scanner keyboard;

  public BoardAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis())); 

    board.setViewCount(0);

    try {
      out.writeUTF("/board/add"); 
      out.flush();
      if (!in.readUTF().equals("OK"))
        return;

      out.writeObject(board);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK"))
        System.out.println("서버에서 저장 실패!");

      System.out.println("저장하였습니다.");
    } catch (Exception e) {
      System.out.printf("데이터 저장 오류! : %s\n", e.getMessage());
    }

    System.out.println("저장하였습니다.");
  }
}
