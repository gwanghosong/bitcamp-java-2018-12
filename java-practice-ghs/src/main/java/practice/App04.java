/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package practice;

public class App04 {
    public static void main(String[] args) {
      for (int i = 1; i <= 10; i++) { // 반복문이라는 사실을 잊지말자.
        for (int j = 1; j <= i; j++) {
          if (j % 2 == 0)
            continue; // 다음 줄로 가지 않고 변수증가문으로 이동
          System.out.print(j + " ");
         }
        System.out.println();
      }
      System.out.println("-----------------------");
      
  }
}