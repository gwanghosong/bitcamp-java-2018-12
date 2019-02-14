package com.eomcs.lms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

// 추상 메서드를 가짐으로써 추상클래스로 반드시 선언.
// 그리고 인스턴스를 이 클래스로 만들지 않고 상속받은 클래스가 인스턴스를 만들게 하려고 추상 클래스로 선언.
public abstract class AbstractDao<E> {

  protected List<E> list;
  protected String filepath;

  @SuppressWarnings("unchecked")
  public void loadData() {

    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream(this.filepath)))){
      list = (List<E>) in.readObject();

    } catch (Exception e) {
      list = new ArrayList<E>();
      throw new RuntimeException ("데이터 파일 로딩 오류! ", e);
    }
  }

  public void saveData() throws Exception {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream(this.filepath)))) {

      out.writeObject(list);

    } catch (Exception e) {
      throw new Exception ("데이터 파일 저장 오류! ", e);
    }
  }
}
