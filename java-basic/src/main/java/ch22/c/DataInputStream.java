package ch22.c;

import java.io.IOException;
import java.io.InputStream;

// 바이트를 읽어 primitive type의 값은 리턴하는 데코레이터 클래스이다.
//
public class DataInputStream extends InputStream {

  InputStream in;

  public DataInputStream(InputStream in) {
    this.in = in;
  }

  @Override
  public int read() throws IOException {
    return in.read();
  }

  public short readShort() throws IOException {
    int value = 0;
// 연산자 | 의미 
// A | B
// A와 B, 즉 피연산자 중 한쪽의 값이 1이면 1을 결과로 얻는다.
// 그 외에는 0을 얻는다.
// A,B의 비트를 비교해서 해당 자릿수의 비트가 하나라도 1이라면 1
// 하나도 1이 아니라면(둘다 0이면) 0
// 보통 특정 자리의 비트값을 변경할 때 사용
    value |= (in.read() << 8);
    value |= in.read();

    return (short) value;

  }

  public int readInt() throws IOException {
    int value = 0;

    value |= (in.read() << 24);
    value |= (in.read() << 16);
    value |= (in.read() << 8);
    value |= in.read();

    return value;

  }

  public String readUTF() throws IOException {
    // 먼저 문자열의 바이트 수를 읽는다.
    int len = 0;
    len |= in.read() << 8;  // a |= b a와 b를 연산하여 연산값을 a에 넣는다.
    len |= in.read();

    // 문자열의 바이트를 읽어 배열에 저장한다.
    byte[] bytes = new byte[len];
    in.read(bytes);

    // UTF-8로 저장된 바이트 배열을 String객체로 만든다.
    return new String(bytes, "UTF-8");
  }

}
