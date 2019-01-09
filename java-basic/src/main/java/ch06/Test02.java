// 메서드 - 메서드와 파라미터
package ch06;

public class Test02 {
  public static void main(String[] args) {
    //m1(); 파라미터 값 지정해 컴파일오류!
    
    //m1(20, "홍길동"); 순서 지켜 컴파일 오류!
    
    //m1(20, 30) 파라미터타입과 맞춰서 값 입력해 컴파일오류!
    
    // m1("홍길동", 20, 20); 파라미터와 값 개수도 일치시켜 컴파일오류!
    
    m1("홍길동", 20);
    m1("임꺽정", 
        30);
    m1(
        "유관순", 
        17
        );
    
    // "홍길동", 20 같은 값을 아규먼트(argument)라 부른다.
  }
  
  
  static void m1(String name, int age) { //String name, int age 이 부분이 파라미터
    System.out.printf("이름: %s\n", name);
    System.out.printf("나이: %s\n", age);
  }
}
















