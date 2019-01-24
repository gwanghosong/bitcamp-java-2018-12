// Object 클래스 - getClass()와 배열의 항목 이름
package ch15;
  
public class Test14 {
  public static void main(String[] args) {
    // 배열의 클래스 정보
    String[] obj2 = new String[10];
    Class classInfo = obj2.getClass();
    System.out.println(classInfo.getName()); //[Ljava.lang.String;
    
    // 배열항목의 타입정보를 가져온다.
    Class comTypeInfo = classInfo.getComponentType();
    System.out.println(comTypeInfo.getName()); //java.lang.String;
    
    // 값을 한 번 밖에 사용하지 않을 것이라면 
    // 위의 경우처럼 한번씩 호출하고, 리턴 값을 가지고 또 호출하는 방식으로 값을 꺼내지 않는다.
    // 체인(chain) 방식으로 호출한다.
    // 메서드 호출하고 리턴값으로 다시 메서드 호출하고 또 다시 그 리턴값으로 메서드 호출하는방식
    System.out.println(obj2.getClass().getComponentType().getName()); //java.lang.String;
    
    int[] obj3 = new int[10];
    classInfo = obj3.getClass();
    System.out.println(classInfo.getName()); //[I
    
    float[] obj4 = new float[10];
    classInfo = obj4.getClass();
    System.out.println(classInfo.getName()); //[F
    
    double[] obj5 = new double[10];
    classInfo = obj5.getClass();
    System.out.println(classInfo.getName()); //[D
  }
}
