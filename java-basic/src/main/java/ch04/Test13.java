// 비트 연산자 : &, |, ^, ~
package ch04;

public class Test13 {
  public static void main(String[] args) {
    int a = 0xca; // 0000 0000 0000 0000 0000 0000 1100 1010
    int b = 0x66; // 0000 0000 0000 0000 0000 0000 0110 0110
    System.out.println(a & b); // 0000 0000 0000 0000 0000 0000 0100 0010
    //0x42 = 66
    
    System.out.println(a | b); // 0000 0000 0000 0000 0000 0000 1110 1110
    //0xee = 16 * 14 + 14 = 238  
    System.out.println(a ^ b); // 0000 0000 0000 0000 000  0000 1010 1100
    //0xac = 16 * 10 + 12 = 172
    System.out.println(a);
    System.out.println(~a); // 1111 1111 1111 1111 1111 1111 0011 0101
    //0xffffff35
    // 0000 0000 0000 0000 0000 0000 1100 1011 = 203
    // 0xc9
    
    // 특정값차단하고 특정값만 통과시키는활용
    int data = 0b1111_1001_0111_1111;
    System.out.println(Integer.toBinaryString(data & 0b0000_1111_1100_0000));
    // 1111_1001_0111_1111
    //&0000_1111_1100_0000
    // 0000_1001_0100_0000
    
    // 빨간색 제거
    int pixel = 0x003f4478; // 각 바이트의 값이 '00RRGGBB' 가정
    System.out.println(pixel & 0x0000ffff);
    // pixel = 00000000_00111111_01000100_01111000
    //            00000000_00000000_11111111_11111111
    //            00000000_00000000_01000100_01111000
    
    //파란색 강화
    System.out.println(pixel | 0x00000055);
 // pixel = 00000000_00111111_01000100_01111000
    //            00000000_00000000_00000000_01010111
    //            00000000_00111111_01000100_01111111
  }
}
















