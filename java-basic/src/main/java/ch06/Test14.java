// main() 메서드의 파라미터 응용
package ch06;

public class Test14 {
  public static void main(String[] args) {
  // $ java -cp ./bin/main ch06.Test14 200 43 56
    
    int sum = 0;
    for (String arg : args)
      sum += Integer.parseInt(arg);
    System.out.printf("합계는 %d\n", sum);
  }
}


 













