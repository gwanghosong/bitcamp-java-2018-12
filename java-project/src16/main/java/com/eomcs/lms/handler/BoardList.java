package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class BoardList {
   //데이터관련 변수
  static final int LENGTH = 3;
  Board[] arr = new Board[LENGTH]; // 보드배열 이름 arr
  int size = 0;//인덱스를 사이즈로바꿈
  
  public Board[] toArray() {
    Board[] a = new Board[size];
    for (int i = 0; i < size; i++) {
      a[i] = this.arr[i];
    }
    return a;
  }
  
  public void add(Board board) {
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));
      /*
      Board[] a = new Board[arr.length + (arr.length >> 1)];
          // 전체 배열의 크기 100이라면,
    // 현재 들어있는 항목만 따로 배열을 만들어 리턴한다.
      for (int i = 0; i < arr.length; i++) {
        a[i] = arr[i];
      }
      arr = a;
      */
      System.out.printf("배열 증가 함: %d\n", arr.length);
    }
    arr[size++] = board;
  }
}





