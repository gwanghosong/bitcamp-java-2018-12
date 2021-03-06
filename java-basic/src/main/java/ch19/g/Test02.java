// 파일 필터 적용 후
package ch19.g;

import java.io.File;

public class Test02 {

  public static void main(String[] args) {
    // File 클래스: 파일이나 디렉토리 정보를 다루는 도구
    File dir = new File("./"); // 이클립스에서 실행하면 ./는 프로젝트 디렉토리를 가리킨다.
    
    // 프로젝트 디렉토리에 있는 모든 파일이나 디렉토리를 검색하여 이름을 출력한다.
    // list() 메서드의 파라미터 값으로 파일이름을 걸러주는 필터를 제공한다면 
    // 필터의 승인 여부에 따라 리턴 배열에 포함될 이름이 결정된다. 
    // 필터를 주지 않은 상태에서 list()를 호출하면 모든 파일과 디렉토리 이름을 리턴하지만
    // 특정 조건에 해당되는 이름만 통과시키는 필터를 준 상태에서 list()를 호출하면
    // 리턴 값은 해당 조건에 만족되는 이름만 포함할 것이다. 
    // 필터의 타입은?
    //  FilenameFilter 인터페이스이다.
    // 이 인터페이스에 따라 동작하는 클래스를 만들고, 
    // 그 클래스의 인스턴스를 생성한 후 
    // list()메서드에 전달하면 된다.
    String[] names = dir.list(new MyFilenameFilter());
    // list(); 찾아보면 true값이여야만 값 리턴하도록 되있음.
    
    // 몇 일, 몇 달, 몇 년이 지난 후 
    // 도대체 저 필터가 무엇을 걸러내는지 알려면 
    // 해당 클래스의 소스 코드를 봐야 한다.
    // 문제는 다른파일로 떨어져 있어 보기 불편하다.
    
    for(String name : names) {
      System.out.println(name);
    }
  }
}
