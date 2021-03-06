// HashMap과 HashTable
package ch20.d;

import java.util.HashMap;
import java.util.Hashtable;

public class Test02 {

  public static void main(String[] args) {

    class Student {
      String name;
      int age;

      public Student(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
      }
    }

    HashMap<String, Student> map = new HashMap<>();
    Hashtable<String, Student> table = new Hashtable<>();

    // HashMap과 Hashtable은 기본 사용법이 같다.
    // 차이점 해시맵은 키와 밸류에 null 허용, 해시테이블은 불허
    // 맵은 좌표 0.0 있음. 테이블은 1부터시작이라고 암기하자
    map.put("aaa", new Student("홍길동", 20));
    table.put("aaa", new Student("홍길동", 20));

    System.out.println(map.get("aaa"));
    System.out.println(table.get("aaa"));

    System.out.println("--------------------------------");

    map.put(null, new Student("임꺽정", 30));
    System.out.println(map.get(null));

    // Hashtable은 key로 null을 허용하지 않는다.
    //table.put(null, new Student("임꺽정", 30)); // Runtime 오류! NullPointerException
    //System.out.println(table.get(null));

    System.out.println("--------------------------------");

    map.put("ccc", null);
    System.out.println(map.get("ccc"));

    // Hashtable은 value에 null을 허용하지 않는다.
    //table.put("ccc", null); // Runtime 오류! NullPointerException
  }

}
