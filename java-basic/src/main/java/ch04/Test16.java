// 비트 이동 연산자 : >>, >>>, <<
package ch04;

public class Test16 {
  public static void main(String[] args) {
    // 비트 << x이동시마다 2**X배
    int a = 0xc9;
    System.out.println(Integer.toHexString(a << 1));
    System.out.println(a << 1);
    // 왼쪽으로 1개 이동 후 경계넘어가는 수는 짜름. 오른쪽 빈자리는 0로채움.

    System.out.println(Integer.toHexString(a << 2));
    System.out.println(a << 2);
  
    System.out.println(Integer.toHexString(a << 3));
    System.out.println(a << 3);
    
    System.out.println(Integer.toHexString(a << 4));
    System.out.println(a << 4);
    
    // 음수의 이동 
    // 0111_1111_1111_1111_1111_1111_1111_1010 = 21_4748_3642
    // 1000_0000_0000_0000_0000_0000_0000_0110 = -21_4748_3642
    
    // 음수를 왼쪽으로 이동할 때는 부호비트에 상관없이 무조건 이동.
    a = -0x7f_ff_ff_fa; // 
    System.out.println(a);
    System.out.println(a << 1);
    System.out.println(a << 2);
    System.out.println(a << 3);
    System.out.println(a << 4);
    System.out.println(Integer.MAX_VALUE);
  }
}
















