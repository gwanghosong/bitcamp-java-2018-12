package practice.lms.handler;

import java.util.List;
import java.util.Scanner;
import practice.lms.domain.Lesson;

public class LessonListCommand implements Command {
  
  Scanner keyboard;

  public LessonListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute() {
    Lesson[] lessons = list.toArray(new Lesson[] {});
    for (Lesson lesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
  }
}
