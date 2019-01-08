// 조건 연산자 => 조건 ? 표현식1 : 표현식2
// cond(ition)? expr(ession)1 : expr(ession)2;
// 조건이 참 expr1 리턴값
// 조건이 거짓 expr2 리턴값
package ch04;

public class Test17 {
  public static void main(String[] args) {
    int age = 20;
    
    String result = (age >= 19) ? "성인" : "미성년";
    System.out.println(result);
    System.out.println((age >= 19) ? "성인" : "미성년");
    System.out.println((age >= 19) ? "성인" : false);
    System.out.println((age >= 65) ? "성인" : false);
  }
}
















