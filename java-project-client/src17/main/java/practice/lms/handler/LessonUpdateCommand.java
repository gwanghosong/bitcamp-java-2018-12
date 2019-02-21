package practice.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.Scanner;
import practice.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {

  Scanner keyboard;

  public LessonUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      out.writeUTF("/lesson/detail");
      out.flush();
      if (!in.readUTF().equals("OK"))
        return;

      out.writeInt(no);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK")) {
        System.out.println("데이터 가져오기 실패!");
        return;
      }

      Lesson lesson = (Lesson) in.readObject();
      // 일단 기존 값을 복제한다.
      Lesson temp = lesson.clone();

      System.out.printf("수업명(%s)? ", lesson.getTitle());
      String input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setTitle(input);

      System.out.printf("설명(%s)? ", lesson.getContents());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setContents(input);

      System.out.printf("시작일(%s)? ", lesson.getStartDate());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setStartDate(Date.valueOf(input));

      System.out.printf("종료일(%s)? ", lesson.getEndDate());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setEndDate(Date.valueOf(input));

      System.out.printf("총수업시간(%d)? ", lesson.getTotalHours());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setTotalHours(Integer.parseInt(input));

      System.out.printf("일수업시간(%d)? ", lesson.getDayHours());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setDayHours(Integer.parseInt(input));

      out.writeUTF("/lesson/update");
      out.flush();
      if (!in.readUTF().equals("OK"))
        return;

      out.writeObject(lesson);
      out.flush();

      status = in.readUTF();

      if (!status.equals("OK"))
        System.out.println("데이터 변경 실패!");

      System.out.println("수업을 변경했습니다.");

    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }

}
