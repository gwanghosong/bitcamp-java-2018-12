// JVM 아규먼트
package ch06;

public class Test16 {
  public static void main(String[] args) {
    String value1 = System.getProperty("a"); //JVM아규먼트에 저장된 이름으로 값을꺼낸다.
    String value2 = System.getProperty("b");
    String value3 = System.getProperty("c");
    
    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);
  }
}


 













