package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  static final int DEFAULT_CAPACITY = 10;
  Lesson[] list; // Lesson 클래스타입으로 주소가 담길 레퍼런스 변수 list 선언
  int size = 0;
  
  public LessonList() {
    list = new Lesson[DEFAULT_CAPACITY];
  } // LessonList() default 생성자 사용시  list 레퍼런스 변수에 DEFAULT_CAPACITY 개수 만큼
  // Lesson클래스 형태의 인스턴스를 만들고 그 인스턴스 주소를 list 레퍼런스변수에 저장.
  // Lesson[] lessons = new Lesson[LENGTH]; 즉 이것을 생성자 형태로 변형.
  
  //잠깐 생성자는?
  // 생성자이름(파라미터값 or null) { ... }
  // 인스턴스 메서드?
  //  return없을시 void 메서드이름(데이터타입 파라미터값) { ...}
  // return있을시 데이터타입 메서드이름() { return ... }
  
  public LessonList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Lesson[initialCapacity];
    else 
      list = new Lesson[DEFAULT_CAPACITY];
  } // 만약 파라미터를 활용한 LessonList(int값)을 썼다면 \
  // 그 값이 스태틱 변수에 설정한 DEFAULT_CAPACITY값보다 크다면 \
  // 그 개수만큼 Lesson클래스 형태의 인스턴스만들고 그 인스턴스 주소를 list 레퍼런스 변수에 저장.
  // 만약 같거나 작다면 원래대로 DEFAULT_CAPACITY값만큼 생성해서 저장.
  

  public Lesson[] toArray() {
    return Arrays.copyOf(list, size);
}
// return값이 있는 인스턴스 메서드
  // Lesson[] 데이터타입을 toArray()란 메서드로 호출하면
  // Arrays.copyOf(list, size) 값을 리턴해준다.
  // Arrays.copyOf() 메소드는 전달받은 배열의 특정 길이만큼을 새로운 배열로 복사하여 반환합니다.
  // copyOf() 메소드는 첫 번째 매개변수로 원본 배열을 전달받고, 
  // 두 번째 매개변수로 원본 배열에서 새로운 배열로 복사할 요소의 개수를 전달받습니다.
  // 그리고 원본 배열과 같은 타입의 복사된 새로운 배열을 반환합니다.
  // 이때 새로운 배열의 길이가 원본 배열보다 길면, 
  // 나머지 요소는 배열 요소의 타입에 맞게 다음과 같은 기본값으로 채워집니다.
  /*
  Lesson[] list = new Lesson[size];
  
  for (int i = 0; i < size; i++) {
    list[i] = lessons[i];
  }
  return list;
  */
  public void add(Lesson lesson) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }
    
    list[size++] = lesson;
  }
  // return 값이 없는 인스턴스 메서드 add
  // 파라미터값은 Lesson데이터타입 즉 Lesson 클래스타입의 파라미터이다
  // lesson은 아래 메서드에 대입할 변수
  // 만약 size 값이 list.length 즉 list배열의 길이보다 크거나 같다면
  // { }안의 식 값을 실행하는데 
  // oldCapacity에 list배열의 length 정수 값을 넣고
  // newCapacity에 oldCapacity 값, 즉 list배열의 length정수 값에다가 값을 더하는데
  // 그 더하는 값은 oldCapcity값의 이진수 값을 오른쪽으로 한칸 움직인 것
  // 즉 기존 oldCapacity 값의 1/2만큼 더한 값을 newCapacity에 저장한다.
  // 그리고 list 원본 배열을 그 개수만큼 복사해서 늘려서 저장합니다.
  // if과정이 끝나면 기존 size값에 1을 더한 배열 크기를 가진 파라미터 lesson에 저장합니다.

}

/* public Board[] toArray() {
  // 전체 배열의 크기 100이라면,
  // 현재 들어있는 항목만 따로 배열을 만들어 리턴한다.
  return null;
}
public void add(Board board) {
  
}
*/
