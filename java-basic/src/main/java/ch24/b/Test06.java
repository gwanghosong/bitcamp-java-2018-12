// JVM의 전체 스레드 계층도
package ch24.b;

public class Test06 {

  public static void main(String[] args) {

    // JVM의 최상위 스레드 그룹인 system의 계층도 출력하기

    Thread mainThread = Thread.currentThread();
    ThreadGroup mainGroup = mainThread.getThreadGroup();
    ThreadGroup systemGroup = mainGroup.getParent();

    printThread(systemGroup, "");
  }

  static void printThread(ThreadGroup tg, String indent) {
    System.out.println(indent + tg.getName() + "(TG)");
    // 현재 스레드 그룹에 소속된 스레드들 출력하기
    Thread[] threads = new Thread[10];
    int size = tg.enumerate(threads, false); 
    // false로 하면 그 쓰레드 그룹에 속한 쓰레드 또는 하위 쓰레드 그룹의 목록을 지정된 배열에 담는다.
    // true로 하면 하위에 속한 모든 쓰레드 그룹의 쓰레드 또는 쓰레드그룹까지 배열에 담는다.
    for (int i = 0; i < size; i++) {
      System.out.println(indent + "  ==>" + threads[i].getName() + "(T)");
    }

    // 현재 스레드 그룹에 소속된 하위 스레드 그룹들 출력하기
    ThreadGroup[] groups = new ThreadGroup[10];
    size = tg.enumerate(groups, false);
    for (int i = 0; i < size; i++) {
      printThread(groups[i], indent + " ");
    }
  }
}

//JVM의 스레드 계층도
// system(TG)
//    ==>Reference Handler(T) 레퍼런스 다루는 스레드
//    ==>Finalizer(T) 가비지 작업 마무리하는 스레드
//    ==>Signal Dispatcher(T)
//    main(TG)
//        ==>main(T) main() 메서드를 호출한다.
//    InnocuousThreadGroup(TG)
//        ==>Common-Cleaner(T)



