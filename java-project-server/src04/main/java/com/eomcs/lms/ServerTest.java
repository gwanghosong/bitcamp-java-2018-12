// 4단계
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.lms.domain.Member;

public class ServerTest {

  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      
      System.out.println("서버와 연결되었음.");
      
      Member member = new Member();
      member.setNo(1);
      member.setName("홍길동");
      member.setEmail("hong@test.com");
      member.setPassword("1111");
      member.setPhoto("hong.gif");
      member.setTel("1111-1111");
      
      // Member 객체를 서버로 serialize 하라!
      // writeObject 클래스 정보와 함께 인스턴스 필드값을 바이트 배열로 만들어 출력
      // serializable 선언되어있어야 한다.
      // serialVersionUID 클래스가 같은지(종류, 버전) 확인하기 위한 인식표
      // transient 출력하기 싫을 때 사용하는 modifier(한정자, 제어자)
      out.writeObject(member);
      out.flush();
      
      // 또한 서버에서 serialize한 Member 객체를 받아라.
      System.out.println(in.readObject());
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음.");
  }
}
