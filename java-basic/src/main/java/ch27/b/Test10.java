// reflection API - 배열 항목의 타입 알아내기
package ch27.b;

import java.sql.Date;

public class Test10 {

  public static void main(String[] args) throws Exception {
    // 배열 타입이 아닌 경우 항목이 없기 때문에 getComponentType() 의 리턴 값은 null이다.
    System.out.println(byte.class.getComponentType());
    System.out.println();
    
    System.out.println(byte.class.getName()); // ==> byte
    System.out.println(new byte[] {}.getClass().getName()); //  ==> [B
    System.out.println(new byte[] {}.getClass().getComponentType().getName());// ==> byte
    System.out.println();
    
    System.out.println(short.class.getName());// ==> short
    System.out.println(new short[] {}.getClass().getName());//  ==> [S
    System.out.println(new short[] {}.getClass().getComponentType().getName());// ==> short
    System.out.println();
    
    System.out.println(int.class.getName());// ==> int
    System.out.println(new int[] {}.getClass().getName());//  ==> [I
    System.out.println(new int[] {}.getClass().getComponentType().getName());//  ==> int
    System.out.println();
    
    System.out.println(long.class.getName());// ==> long
    System.out.println(new long[] {}.getClass().getName());//  ==> [J
    System.out.println(new long[] {}.getClass().getComponentType().getName());//  ==> long
    System.out.println();
    
    System.out.println(float.class.getName());// ==> short
    System.out.println(new float[] {}.getClass().getName());//  ==> [F
    System.out.println(new float[] {}.getClass().getComponentType().getName());//  ==> [F
    System.out.println();
    
    System.out.println(double.class.getName());// ==> double
    System.out.println(new double[] {}.getClass().getName());//  ==> [D
    System.out.println(new double[] {}.getClass().getComponentType().getName());//  ==> double
    System.out.println();
    
    System.out.println(boolean.class.getName());// ==> boolean
    System.out.println(new boolean[] {}.getClass().getName());//  ==> [Z
    System.out.println(new boolean[] {}.getClass().getComponentType().getName());//  ==> boolean
    System.out.println();
    
    System.out.println(char.class.getName());// ==> char
    System.out.println(new char[] {}.getClass().getName());//  ==> [C
    System.out.println(new char[] {}.getClass().getComponentType().getName());//  ==> char
    System.out.println();
    
    System.out.println(String.class.getName());// ==> java.lang.String
    System.out.println(new String[] {}.getClass().getName());//  ==> [Ljava.lang.String;
    System.out.println(new String[] {}.getClass().getComponentType().getName());//  ==> java.lang.String;
    System.out.println();
    
    System.out.println(Date.class.getName());// ==> java.sql.Date
    System.out.println(new Date[] {}.getClass().getName());//  ==> [Ljava.sql.Date;
    System.out.println(new Date[] {}.getClass().getComponentType().getName());//  ==> java.sql.Date;
    System.out.println();
  }
}
