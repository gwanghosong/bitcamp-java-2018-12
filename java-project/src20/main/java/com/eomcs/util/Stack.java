package com.eomcs.util;

// 스택에 복제 기능 활성화시키기
public class Stack<E> implements Cloneable {

  public static final int DEFAULT_SIZE = 5;
  Object[] list;
  int size;

  public Stack() {
    list = new Object[DEFAULT_SIZE];
  }

  public void push(E value) {
    // 맨 마지막에 추가한다.
    // 배열의 크기가 작다면 확장해야 한다.
    if (list.length == this.size) {
      /*int oldSize = list.length;
    int newSize = oldSize + (oldSize >> 1);*/
      Object[] arr = new Object[list.length + (list.length >> 1)];
      for (int i = 0; i < this.list.length; i++) {
        arr[i] = this.list[i];
      }
      list = arr;

    }

    list[this.size++] = value;

  }

  @SuppressWarnings("unchecked")
  public E pop() {
    // 맨 마지막 값을 꺼내 리턴한다.
    // 꺼낸 값은 배열에서 제거되어야 한다.
    // 값을 어떻게 꺼내???
    if (size == 0)
      return null;
    // 원래 list배열이 size크기로 있는데 여기서 마지막 size에 해당하는 인스턴스를 삭제하고
    // 하나 줄어든 배열을 리턴.
    return (E) list[--size];

  }

  public boolean empty() {
    // return false;
    return size == 0;
  }

  public int size() {
    return this.size;
  }
  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return (Stack<E>) super.clone();
  }
}
