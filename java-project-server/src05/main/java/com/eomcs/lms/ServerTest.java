// 5단계
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class ServerTest {

  static ObjectOutputStream out;
  static ObjectInputStream in;

  public static void main(String[] args) {

    // OutputStream, InputStream을 사용하는 경우
    // 받는 명령을 먼저하는 경우 OutputStream을 먼저 선언하고,
    // 보내는 명령을 먼저하는 경우 InputStream을 그 다음에 선언하라.
    // 운영체제에 따라 이렇게 안하면 안돌아가는 경우가 있기 때문에
    // 안정성을 확보하기 위해서 이렇게 하는 것이 좋다.
    try (Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결되었음.");
      ServerTest.in = in;
      ServerTest.out = out;

      add(new Member(1, "홍길동"));

      add(new Member(2, "임꺽정"));

      list();

      out.writeUTF("okok");
      out.flush();
      System.out.println(in.readUTF());

      quit();

      /*
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
       */
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음.");
  }

  static void add(Member member) throws Exception {
    out.writeUTF("add");
    out.writeObject(member);
    out.flush();
    System.out.println(in.readUTF());
  }

  static void list() throws Exception {
    out.writeUTF("list");
    out.flush();
    @SuppressWarnings("unchecked")
    List<Member> members = (List<Member>) in.readObject();
    for (Member m : members) {
      System.out.println(m);
    }
  }

  static void quit() throws Exception {
    out.writeUTF("quit");
    out.flush();
    System.out.println(in.readUTF());
  }
}
