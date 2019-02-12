// URL 요청하기
package ch23.h;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Test04 {
  
  public static void main(String[] args) throws Exception {
    
    URL url = new URL("https://www.naver.com/"); // http, https 둘다 가능
    
    // 서버와 연결하고 HTTP 요청을 수행한다.
    // 그런 후에 웹서버의 데이터를 읽어 드릴 도구를 리턴한다.
    InputStream in = url.openStream(); // InputStream byte 스트림
    
    // 서버가 보낸 데이터를 한 줄씩 읽기 위해 데코레이터를 붙인다.
    // BufferedReader char 스트림
    BufferedReader in2 = new BufferedReader(new InputStreamReader(in));
    
    while(true) {
      String str = in2.readLine();
      if (str == null)
        break;
      
      System.out.println(str);
    }
    in2.close();
    in.close();
  }
}
