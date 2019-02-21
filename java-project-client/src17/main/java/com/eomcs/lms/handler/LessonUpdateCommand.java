package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {

  Scanner keyboard;
  LessonDao lessonDao;

  public LessonUpdateCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {

    try {

      System.out.print("번호? ");
      Lesson lesson = new Lesson();
      String input = keyboard.nextLine();
      lesson.setNo(Integer.parseInt(input));

      System.out.print("수업명? ");
      if (input.length() > 0) 
        lesson.setTitle(input);

      System.out.print("설명? ");
      if ((input = keyboard.nextLine()).length() > 0)
        lesson.setContents(input);

      System.out.print("시작일? ");
      if ((input = keyboard.nextLine()).length() > 0)
        lesson.setStartDate(Date.valueOf(input));

      System.out.print("종료일? ");
      if ((input = keyboard.nextLine()).length() > 0)
        lesson.setEndDate(Date.valueOf(input));

      System.out.print("총수업시간? ");
      if ((input = keyboard.nextLine()).length() > 0)
        lesson.setTotalHours(Integer.parseInt(input));

      System.out.print("일수업시간? ");
      if ((input = keyboard.nextLine()).length() > 0)
        lesson.setDayHours(Integer.parseInt(input));

      if (lessonDao.update(lesson) == 0) {
        System.out.println("해당 데이터가 없습니다.");
        return;
      }

      System.out.println("변경했습니다.");
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
