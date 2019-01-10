// 로컬 변수와 인스턴스 필드(변수)의 초기화

package ch07;

public class Test07 {
  static class Score {
    String name; // 설계 도면이기 때문에 변수가 존재하는 상태가 아니다.
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }
  
  public static void main(String[] args) {
    
    // 로컬 변수는 자동으로 초기화되지 않는다.
    // 반드시 직접 초기화 시켜야 한다.
    // 초기화 하지 않은 로컬 변수는 사용할 수 없다.
    // 초기화? 값을 한 번이라도 저장하는 것!
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
    // 다음과 같이 초기화시키지 않은 로컬 변수를 사용하려고 하면 컴파일 오류가 발생한다!
    //System.out.println(name); 컴파일 오류
    
    // 힙에 생성되는 인스턴스 필드(변수)는 자동으로 초기화된다.
    // 레퍼런스 = null
    // byte, short, int, long = 0
    // char = '\u0000' = 0
    // float, double = 0.0 = 0
    // boolean = false = 0
    
    // 그래서 인스턴스 필드(변수) 생성되는 즉시 0으로 초기화된다.
    Score s = new Score();
    System.out.println(s.name);
    System.out.println(s.kor);
    System.out.println(s.aver);
    
    
   }
}








