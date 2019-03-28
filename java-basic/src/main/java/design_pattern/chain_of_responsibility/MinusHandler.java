package design_pattern.chain_of_responsibility;

public class MinusHandler extends AbstractHandler {

  @Override
  public void handle(int a, int b, String op) {
    System.out.println("마이너스");
    if (op.equals("-")) {
      System.out.printf("%d - %d = %d\n", a, b, (a - b));
      return;
    }

    next.handle(a, b, op);
  }

}
