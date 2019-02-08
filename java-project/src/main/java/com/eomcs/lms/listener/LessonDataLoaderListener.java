package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import com.eomcs.lms.context.ApplicationListener;
import com.eomcs.lms.domain.Lesson;

public class LessonDataLoaderListener implements ApplicationListener{

  @Override
  public void startApplication(Map<String, Object> context) {
    System.out.println("애플리케이션이 시작할 때 준비작업을 수행한다.");

    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("lesson3.data")))) {
      context.put("lessonList", in.readObject());
      
    } catch (Exception e) {
      System.out.println("수업 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("lessonList", new ArrayList<Lesson>());
    }

  }

  @Override
  public void endApplication(Map<String, Object> context) {
    System.out.println("애플리케이션을 종료할 때 마무리 작업을 수행한다.");

    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("lesson3.data")))) {

      out.writeObject(context.get("lessonList"));

    } catch (Exception e) {
      System.out.println("수업 데이터를 출력하는 중 오류 발생: " + e.toString());
    }

  }

}