package design_pattern.decorator.before;

public class Hybrid extends Sedan {

  @Override
  public void run() {
    if (this.speed <= 60) {
      System.out.println("모터로 달린다.");
    } else {
      System.out.println("달린다!");
    }
  }
}
