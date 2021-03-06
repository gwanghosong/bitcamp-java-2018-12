package ch22.c;

import java.io.IOException;
import java.io.OutputStream;

// primitive type의 데이터를 출력하는 플러그인 객체
// OutputStream의 데코레이터이다.
public class DataOutputStream extends OutputStream {

  OutputStream out;
  
  public DataOutputStream(OutputStream out) {
    this.out = out;
  }
  
  @Override
  public void write(int b) throws IOException {
    out.write(b);
    
  }
// 자바에서 비트이동연산자는 맨끝의 쉬프트된 비트가 없어지는 결과를 가져온다.
  // 즉 밀린다는이야기
  public void writeShort(Short value) throws IOException {
    out.write(value >> 8);
    out.write(value);
  } // - 32768 ~ 32767까지임
  
  public void writeInt(int value) throws IOException {
    out.write(value >> 24);
    out.write(value >> 16);
    out.write(value >> 8);
    out.write(value);
  }
  // String 클래스는 기본적으로 UTF-16으로 갖고있음.
  public void writeUTF(String value) throws IOException {
    // 문자열 바이트 배열로 출력하는 형식
    // 바이트수(2byte) + 문자열의 바이트 배열
    byte[] bytes = value.getBytes("UTF-8");
    out.write(bytes.length >> 8);
    out.write(bytes.length);
    out.write(bytes);
  }
  
@Override
  public void flush() throws IOException {
    out.flush();
  }  
}
