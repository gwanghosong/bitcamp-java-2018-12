// 레퍼런스와 인스턴스의 관계

package ch07;

import ch07.Test06.Score;

public class Test05 {
  static class Score {
    String name; // 설계 도면이기 때문에 변수가 존재하는 상태가 아니다.
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }
  
  public static void main(String[] args) {
    
    Score s1 = new Score(); 
    
    // s1에 저장된 주소로 찾아가서 그 메모리의 각 항목 값을 설정한다.
    // s1에 저장된 주소로 찾아가서 그 인스턴스의 각 변수에 값을 설정한다.
    // s1이 가리키는 인스턴스의 각 변수에 값을 설정한다.
    // s1이 가리키는 인스턴스의 각 필드 값을 설정한다.
    // s1 인스턴스의 필드 값을 설정한다.
    // s1 객체의 필드 값을 설정한다.
    s1.name = "홍길동"; // 표현 : s1 객체의 name에 "홍길동"을 저장한다.
    s1.kor = 100;
    s1.eng = 100;
    s1.math = 100;
    
    Score s2 = s1; // s1에 저장된 인스턴스 주소를 s2에 복사한다.
    
    System.out.println(s2.name);
    s1.name = "임꺽정";
    System.out.println(s2.name);
    
    // 메서드가 생성한 인스턴스의 주소를 받을 수 있다.
    Score s3 = createScore("유관순", 90, 90, 90);
    Score s4 = createScore("유관순2", 91,91,91);
    
    System.out.println(s3.name);
    System.out.println(s3.kor);
    
    System.out.println(s4.name);
    System.out.println(s4.kor);
  }
  
  // createScore() 성적 데이터를 가지고 Score 객체를 생성하여 리턴한다.
  // Score 인스턴스를 생성하여 리턴한다.
  // Score 인스턴스를 생성한 후 그 주소를 리턴한다.
  static Score createScore(String name, int kor, int eng, int math) {
    Score s = new Score();
    s.name = name;
    s.kor = kor;
    s.eng = eng;
    s.math = math;
    s.sum = kor + eng + math;
    s.aver = s.sum / 3f;
    
    return s; // s에 저장된 인스턴스의 주소를 리턴한다.
    // 로컬변수는 메서드 호출끝난다음삭제
    // 인스턴스는 힙(heap) 메모리에 생성
    // 어떤 메서드에서 인스턴스를 생성하든지 간에 힙에 생성된 것은 메서드 호출이 끝나더라도
    // 삭제되지 않습니다.
    // 오직 stack 메모리에 생성된 로컬 변수만이 삭제됩니다.
  }
}












