package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.agent.LessonAgent;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {

  LessonAgent lessonAgent;
  Scanner keyboard;
  
  public LessonListCommand(Scanner keyboard, LessonAgent lessonAgent) {
    this.lessonAgent = lessonAgent;
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {

    try {
      List<Lesson> lessons = lessonAgent.list();

      for (Lesson lesson : lessons) {
        System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
            lesson.getNo(), lesson.getTitle(), 
            lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
      }
    } catch (Exception e) {
      System.out.printf("수업정보 목록 출력 오류! : %s\n", e.getMessage());
    }
  }
}
