// java.io.File 클래스 : 폴더 생성 후 파일 생성
package ch22.a;

import java.io.File;

public class Test07 {

  public static void main(String[] args) throws Exception {

    // 폴더와 파일을 한 번에 생성하는 방법
    File file = new File("temp2/a/b/c/test.jpg");
    
    // 파일의 디렉토리 경로를 가지로 File 객체 생성
    
   // File dir = new File(file.getParent());
    File dir = file.getParentFile();
    System.out.println(file); // file은 원래 경로
    System.out.println(dir); // dir은 getParentFile로 그 파일이 저장된 경로, 상위폴더경로
    // 즉 "temp2/a/b/c"
   
    // 먼저 디렉토리를 생성한다.
    if (dir.mkdirs()) {
      System.out.println("디렉토리를 생성하였음.");
    } else {
      System.out.println("디렉토리를 생성하지 못함.");
    }
    // 파일을 생성함.
    if (file.createNewFile()) {
      System.out.println("파일을 생성함.");
    } else {
      System.out.println("파일을 생성하지 못함.");
    }

  }  
}
