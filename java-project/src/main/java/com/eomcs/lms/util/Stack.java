package com.eomcs.lms.util;

public class Stack {
  
  public static final int DEFAULT_SIZE = 5;
  Object[] list;
  int size;
  
  public Stack() {
    list = new Object[DEFAULT_SIZE];
  }
  
  public void push(Object value) {
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
  
  public Object pop() {
    // 맨 마지막 값을 꺼내 리턴한다.
    // 꺼낸 값은 배열에서 제거되어야 한다.
    // 값을 어떻게 꺼내???
    if (size == 0)
      return null;
    
    return list[--size];
    
   /* Object old = list[this.size];
    list[this.size] = null;
    return old;*/
  }
  
  public boolean empty() {
    // return false;
    return size == 0;
  }
  
  public int size() {
    return this.size;
  }
}
