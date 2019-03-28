// Base64 인코딩
package ch23.i;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Test01 {

  public static void main(String[] args) throws Exception {
    String str = "ABC012가각간";
    
    byte[] bytes = str.getBytes("UTF-8");
    
    // Base64 인코딩
    //
    //  사용이유: 보통 바이너리 데이터를 텍스트로 전송할 때 많이 사용한다.
    //              즉, 바이너리 데이터를 전송해야 하는데 텍스트로밖에 전송하지 못할 때 사용한다.
    //
    //  프로그램과 상관없는 인코딩 기술.
    //  : 바이너리 데이터를 문자화 시킨다.
    //  : 바이너리 값을 6비트씩 잘라서 (2의 6승) 
    //  : 64진수로 만든 후 Base64 표에 정의된 대로
    //    해당 값을 문자로 변환한다.
    //  : "ABC012가각간" 문자열
    //    41 42 43 30 31 32 EAB080 EAB081 EAB082 (UTF-8 코드)
    //    4142 ==> 0100 0001 0100 0010 (2진수)
    //    010000 010100 0010 (6비트씩 자른 것)
    //    6비트로 자른 것을 다시 10진수로 표현하면 16 20
    //    16을 Base64 코드 표에 따라 문자로 표현하면 ==> Q
    //    20을 Base64 코드 표에 따라 문자로 표현하면 ==> U
    //    ...
    //    이런 식으로 문자열을 Base64로 바꾸면 결과는 다음과 같다.
    //    QUJDMDEy6rCA6rCB6rCE
    //
    Encoder encoder = Base64.getEncoder();
    byte[] base64Bytes = encoder.encode(bytes);
    
    System.out.println(new String(base64Bytes));
    
    // Base64 디코딩
    // : Base64 코드를 원래의 바이너리 값으로 변환한다.
    //
    Decoder decoder = Base64.getDecoder();
    byte[] bytes2 = decoder.decode(base64Bytes);
    
    System.out.println(new String(bytes2, "UTF-8"));
    
  }
}
