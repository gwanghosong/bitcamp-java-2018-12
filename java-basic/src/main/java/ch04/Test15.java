// 비트 이동 연산자 : >>, >>>, <<
package ch04;

public class Test15 {
  public static void main(String[] args) {
    int a = 0xca;
    System.out.println(Integer.toHexString(a >>> 4));
    System.out.println(a >>> 4);
    // 오른쪽으로 4개 이동 후 경계넘어가는 수는 짜름. 왼쪽 빈자리는 0로채움.

    System.out.println(Integer.toHexString(a >>> 3));
    System.out.println(a >>> 3);
    // 오른쪽으로 3개 이동 후 경계넘어가는 수는 짜름. 왼쪽 빈자리는 0로채움.

    
    System.out.println(Integer.toHexString(a >>> 2));
    System.out.println(a >>> 2);
    
    System.out.println(Integer.toHexString(a >>> 1));
    System.out.println(a >>> 1);
    
    // 음수의 이동 0으로채움
    a = -202; //
    System.out.println(a >>> 1);
    System.out.println(a >>> 2);
    System.out.println(a >>> 3);
    System.out.println(a >>> 4);
    System.out.println(Integer.MAX_VALUE);
  }
}
















