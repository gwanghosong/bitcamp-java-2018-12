package ch22.e;

import java.io.DataInputStream;

public class readScore {
  public readScore(DataInputStream in, Score s) throws Exception {
    String name = in.readUTF();
    int kor = in.readInt();
    int eng = in.readInt();
    int math = in.readInt();
    
    s.setName(name);
    s.setKor(kor);
    s.setEng(eng);
    s.setMath(math);
  }
}
