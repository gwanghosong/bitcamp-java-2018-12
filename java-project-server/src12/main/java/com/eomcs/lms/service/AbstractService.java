// 11단계: 서비스 클래스의 일반화(상속)를 수행한다. generalization
// 제네릭도 적용
package com.eomcs.lms.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// 추상 메서드를 가짐으로써 추상클래스로 반드시 선언.
// 그리고 인스턴스를 이 클래스로 만들지 않고 상속받은 클래스가 인스턴스를 만들게 하려고 추상 클래스로 선언.
public abstract class AbstractService<E> {

  ObjectInputStream in;
  ObjectOutputStream out;

  public void init(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  public abstract void execute(String request) throws Exception;
}
