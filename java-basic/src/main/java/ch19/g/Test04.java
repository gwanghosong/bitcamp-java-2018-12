// 파일 필터 클래스를 로컬 클래스로 만든다.
package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class Test04 {



  public static void main(String[] args) {

    // 이렇게 main() 안에서 사용할 클래스라면 이렇게 로컬 클래스로 만든다.
    //
    class MyFilenameFilter implements FilenameFilter {

      @Override
      public boolean accept(File dir, String name) {
        if (name.endsWith(".txt"))
          return true;
        else
          return false;
      }
    }
    File dir = new File("./"); 

    // 이전의 경우 보다 훨씬 더 중첩 클래스가 가까이 있어 소스보기가 편하다.
    
    String[] names = dir.list(new MyFilenameFilter());

    // 문제는 list()를 호출하는 코드와 필터 클래스를 정의하는 코드 사이에
    // 많은 다른 코드가 있다면 이전과 마찬가지로 소스 보기가 불편할 것이다.

    for(String name : names) {
      System.out.println(name);
    }
  }
}
