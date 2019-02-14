package com.eomcs.lms.agent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardAgent {

  String serverAddr;
  int port;
  String rootPath;

  public BoardAgent(String serverAddr, int port, String rootPath) {
    this.serverAddr = serverAddr;
    this.port = port;
    this.rootPath = rootPath;
  }

  @SuppressWarnings("unchecked")
  public List<Board> list() throws Exception {

    // catch 없는 이유 : 예외처리를 다른곳에서 하겠다.
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF(rootPath + "/list");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다."); 

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버에서 게시글 목록 가져오기 실패!");

      return (List<Board>) in.readObject();
    }
  }

  public void add(Board board) throws Exception {

    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF(rootPath + "/add");
      out.flush();
      if (!in.readUTF().equals("OK"))
        // 예외를 던져서 catch문으로 가서 처리
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다."); 

      out.writeObject(board);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK"))
        throw new Exception("서버에서 저장 가져오기 실패!");
    }
  }


  public Board get(int no) throws Exception {
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF(rootPath + "/detail");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다."); 

      out.writeInt(no);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버에서 게시글 가져오기 실패!");

      return (Board) in.readObject();
    }
  }

  public void update(Board board) throws Exception {
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF(rootPath + "/update");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다."); 

      out.writeObject(board);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK"))
        System.out.println("서버에서 게시글 가져오기 실패!");
    }
  }

  public void delete(int no) throws Exception {
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF(rootPath + "/delete");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다."); 

      out.writeInt(no);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK"))
        throw new Exception("서버에서 게시글을 삭제하는데 실패!");
    }
  }
}
