// 상속 specialization
package ch13.g;

// 기존의 Car 클래스를 상속받아 '특별한 기능'을 덧붙인다.
// specialization
public class Converitible extends Car {
  boolean open;
  
  public void openRoof() {
    open = true;
  }
  
  public void closeRoof() {
    open = false;
  }

}
