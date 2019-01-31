package design_pattern.composite;

public class File extends Node {

  String type;
  int length;
  
  public File(String title, String type, int length) { // 세가지 변수를 파라미터로 받아서 생성자 구현
    this.title = title;
    this.type = type;
    this.length = length;
  }
  
  @Override
  public void getFileInfo() { // Node에서 추상 메서드 오버라이딩해서 구현
    System.out.printf("파일명: %s\n", this.title);
    System.out.printf("타입: %s\n", this.type);
    System.out.printf("크기: %d\n", this.length);
  }
  
}
