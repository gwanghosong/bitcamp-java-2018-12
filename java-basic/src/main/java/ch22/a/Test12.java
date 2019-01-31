// java.io.File 클래스 : 필터와 Lambda 표현식을 사용하여 디렉토리 이름만 추출하라.
package ch22.a;

import java.io.File;

public class Test12 {

  public static void main(String[] args) throws Exception {

    // 파일은 디렉토리와 파일을 통칭하는 용어다.
    File file = new File(".");

    // 하위 파일이나 디렉토리의 상세 정보 알아내기
    File[] files = file.listFiles(
        (File pathname) -> pathname.isDirectory() ? true : false);
    
    for (File f : files) {
      System.out.printf("%s %12d %s\n", 
          f.isDirectory() ? "d" : "-", 
              f.length(),
              f.getName());
    }

  }  
}
