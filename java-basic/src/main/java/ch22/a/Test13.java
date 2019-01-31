// java.io.File 클래스 : 연습 과제 - bin 폴더를 삭제하라!
package ch22.a;

import java.io.File;
import ch22.a.Test11_1.TextFileFilter;

public class Test13 {

  public static void main(String[] args) throws Exception {
    // bin의 하위 폴더와 파일을 모두 삭제해야만 bin 폴더를 삭제할 수 있다.
    // 재귀호출을 이용할것.
    // 파일은 디렉토리와 파일을 통칭하는 용어다.

    File dir = new File("bin");


    delete(dir);
  }

  static void delete(File dir) {
    // 파일의 하위 디렉토리와 파일 목록을 얻는다. pseudo code
    File[] files = dir.listFiles();

    for (File file : files) {
      if (file.isFile()) {
        file.delete();
      } else {
        delete(file);
      }
    }
    dir.delete();
  }

  // 파일 목록에서 파일을 하나 꺼낸다.

  // 만약 파일이면 삭제한다.

  // 디렉토리면 delete()을 호출하여 삭제한다.
}


