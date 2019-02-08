package ch22.c;

import java.io.IOException;
import java.io.InputStream;
// InputStream에 기능을 덧붙이는 플러그인 역할을 수행하는 클래스이다.
// 이런 클래스를 데코레이터(Decorator)라 한다.
// 데코레이터는 기능을 덧붙이는 대상 클래스와 같은 조상을 가져야 한다.
// 그리고 생성자에게 대상 객체 주소를 받아야 한다.
// 작업을 수행할 때 대상 객체를 사용한다.
// 그리고 자신만의 기능을 덧붙인다.
public class BufferedInputStream extends InputStream {

  InputStream in;
  byte[] buf = new byte[1024];
  int size = 0;
  int cursor = 0;

  public BufferedInputStream(InputStream in) {
    this.in = in;
  }

  public int read() throws IOException {
    // cursor는 buf의 인덱스, 즉 0 ~ 1023까지만 가능하므로 1024가되는순간
    // in.read(buf)를 실행해 다시 데이터 바이트를 읽어와서 byte값을 하나하나 리턴한다.
    if (cursor >= size) {
      size = in.read(buf); // buf 인덱스만큼 데이터 바이트 수를 읽은 다음 size에 입력
      if (size == -1)
        return -1;
      cursor = 0;
    }

    // 바이트의 값을 온전히 4바이트 int 값으로 변환하기 위해
    // 0x 000000ff값을 & 비트 연산한다.
    // 0xff 상수값은 0x000000ff를 의미한다.
    // byte형과 int형계산이므로 int형으로 둘다 계산된다.
    // 이 때 0xff = 00000000 00000000 00000000 11111111과 & 연산을하면
    // 앞에 부분을 0으로바꿔서 마이너스부분을 플러스로 처리할 수 있게 된다.
    return (byte)buf[cursor++] & 0xff; // buf[cursor]가 가리키는 byte 1개를 리턴
  }
}
