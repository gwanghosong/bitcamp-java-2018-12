package design_pattern.composite;

import java.util.ArrayList;

public class Directory extends Node {

  ArrayList<Node> childs = new ArrayList<>(); // Node 클래스 인스턴스를 파라미터로 받는 배열 childs준비

  public Directory(String title) { // title을 파라미터로 받아 생성하는 생성자 Directory
    this.title = title;
  }

  @Override
  public void getFileInfo() { // Node의 추상메서드를 받아서 오버라이딩해서 구현
    System.out.printf("디렉토리명: %s\n", this.title);
  }

  public void add(Node node) { // 배열 childs에 추가
    childs.add(node);
  }

  public Node remove(int index) { // 배열 childs에서 제거
    return childs.remove(index);
  }
  public Node get(int index) { // 배열 childs에서 값 꺼내기
    return childs.get(index);
  }
}
