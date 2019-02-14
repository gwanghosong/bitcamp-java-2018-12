package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Command {
  // 그냥 기존 규칙, 인터페이스 메서드를 손대는 순간 관련된 모든 파일 컴파일 오류남.
  // void execute(ObjectInputStream in, ObjectOutputStream out);
  // 그렇다고 그냥 새 규칙을 적용하면 새 규칙을 적용 안해서 모든 파일 컴파일 오류남.
  // void.execute();
  // void execute(ObjectInputStream in, ObjectOutputStream out);
  // 따라서 default 생성자를 쓴다.
  // 하지만 default 생성자를 쓴 규칙을 구현하지 않아도 컴파일 오류가 안나기 때문에
  // default 생성자를 쓰면 규칙이 느슨해진다.
  // 하지만 기존 규칙을 수정하면서 이 인터페이스의 영향을 받은 다른 파일에 영향을 주지 않기 위해
  // default를 쓴 것일뿐이지, 새로운 규칙을 추가하는 것이기 때문에 구현하지 않으면 안된다고 생각하자.
  default void execute() {
    // 이 인터페이스를 새로 구현하는 클래스가
    // 과거의 규칙을 따르지 않아도 되도록
    // 기존 규칙도 default로 선언한다.
  }
  default void execute(ObjectInputStream in, ObjectOutputStream out) {
    // 이 규칙은 새로 추가한 규칙이다.
    // 그러나 기존 클래스에 영향을 끼지지 않기 위해 default로 선언한다.
  }
}
