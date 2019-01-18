// Object 클래스 - 사용자가 만든 클래스를 key로 사용하기 위해 hashCode()와 equals() 오버라이딩하기
package ch15;
  
import java.util.HashMap;

class Key2 {
  String contents;
  
  public Key2(String contents) {
    this.contents = contents;
  }

  @Override
  public String toString() {
    return "Key2 [contents=" + contents + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((contents == null) ? 0 : contents.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Key2 other = (Key2) obj;
    if (contents == null) {
      if (other.contents != null)
        return false;
    } else if (!contents.equals(other.contents))
      return false;
    return true;
  }
  
}


public class Test11 {

  public static void main(String[] args) {
    // hash 코드는 Map에서 값을 저장하기 위해 key로 사용한다.
    HashMap map = new HashMap();

    Key2 k1 = new Key2("ok");
    Key2 k2 = new Key2("no");
    Key2 k3 = new Key2("haha");
    Key2 k4 = new Key2("ohora");
    Key2 k5 = new Key2("hul");
    
    // String을 key로 사용해보자!
    map.put(k1, new Student("홍길동", 20, false));
    map.put(k2, new Student("임꺽정", 30, true));
    map.put(k3, new Student("유관순", 17, true));
    map.put(k4, new Student("안중근", 24, true));
    map.put(k5, new Student("윤봉길", 22, false));
    
    System.out.println(k3.hashCode());
    

    
    // key를 사용하여 값을 꺼내보자.
    Key2 k6 = new Key2("haha");
    
    System.out.println(k3 == k6); // 인스턴스는 다르다.
    System.out.println(k3.hashCode()); // hashCode는 같다.
    System.out.println(k6.hashCode()); // hashCode는 같다.
    System.out.println(k3.equals(k6)); // equals()의 비교 결과도 다르다.
    
    
    //k3와 k6는
    // hashCode()의 리턴 값이 같다
    // equals() 비교 결과도 true이기 때문에
    // HashMap 클래스에서는 서로 같은 key이기 때문이다.
   System.out.println(map.get(k6));
    
   // 자바는 문자열에 대해 대소문자를 구별하기 때문에  "haha"와 "Haha"는 다른 객체로 취급한다.
   // 당연히 hashCode()의 리턴 값이 다르고, equals()의 리턴값은 false이다.
    String k7 = new String("Haha");
    System.out.println(map.get(k7));
    // hashCode(), equals()를 오버라이딩하지않으면
    // 순수하게 인스턴스 자체로 비교하기 때문에
    // 인스턴스가 달라지면 달라진다.
    // 오버라이딩하면 인스턴스 안에 담긴 내용 자체로 비교하기때문에
    // 인스턴스가 달라도 값이 같다면 같은것으로 해석한다.
  }


}
