// 비트 이동 연산자 : >>, >>>, <<
package ch04;

public class Test14 {
  public static void main(String[] args) {
    int a = 0xca;
    System.out.println(Integer.toHexString(a >> 4));
    System.out.println(a >> 4);
    // 오른쪽으로 4개 이동 후 경계넘어가는 수는 짜름. 왼쪽 빈자리는 부호비트로채움.
    // 00000000_00000000_00000000_11001010
    //     0000_00000000_00000000_00001100_1010
    // 00000000_00000000_00000000_00001100
    System.out.println(Integer.toHexString(a >> 3));
    System.out.println(a >> 3);
    // 오른쪽으로 3개 이동 후 경계넘어가는 수는 짜름. 왼쪽 빈자리는 부호비트로채움.
    // 00000000_00000000_00000000_11001010
    //    00000_00000000_00000000_00011001_010
    // 00000000_00000000_00000000_00011001
    
    System.out.println(Integer.toHexString(a >> 2));
    System.out.println(a >> 2);
    
    System.out.println(Integer.toHexString(a >> 1));
    System.out.println(a >> 1);
    
    // 음수의 이동
    a = -202; // 11111111_11111111_11111111_00110110 =0xff_ff_ff_36
    System.out.println(a >> 1);
    System.out.println(a >> 2);
    System.out.println(a >> 3);
    System.out.println(a >> 4);
  }
}
















