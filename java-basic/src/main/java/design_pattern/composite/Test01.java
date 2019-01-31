package design_pattern.composite;

public class Test01 {

  public static void main(String[] args) {

    // Composite 디자인 패턴
    // tree 구조로 전체-부분 관계의 객체를 표현할 때 사용한다.
    // 보통 조직도를 표현할 때 적합한 설계 기법이다.
    // OS의 파일시스템도 이 설계 기법으로 구현할 수 있다.
    //
    // 다음은 OS의 파일과 디렉토리 관계를 Composite 패턴을 사용하여 tree 구조로 표현한 것이다.
    //
    Directory root = new Directory("/"); // "/"을 title로 가지는 Directory 인스턴스 생성후 root에 주소 저장.
    // 그러면 root아래 childs라는 Node를 파라미터로 받는 배열 생성

    root.add(new File("a.gif", "image/gif", 3456)); // File생성자를 이용해 인스턴스 생성후 그 주소를
    // root 인스턴스 주소 아래 childs 배열에 저장
    root.add(new File("b.gif", "image/gif", 34530));
    root.add(new File("test.txt", "text/plain", 8700));

    Directory src = new Directory("/src"); // "/src"을 title로 가지는 Directory 인스턴스 생성후 src에 주소 저장.
    src.add(new File("Hello.java", "test/java", 320)); 
    // src 주소 아래 childs 배열에 File생성자로 생성한 인스턴스 주소를 저장.
    src.add(new File("Hello2.java", "test/java", 400));
    root.add(src); // 그리고 src자체를 root 배열 아래 저장.

    Directory bitcamp = new Directory("/bitcamp");
    bitcamp.add(new File("A.java", "text/java", 200));
    src.add(bitcamp);

    display(root, "");
  }

  static void display(Directory dir, String path) { // dir과 상위 경로를 파라미터로 받는 display 메서드
    System.out.println(path); // 먼저 상위 경로 표시

    for (Node node : dir.childs) { 
      // 파라미터로 받은 directory 인스턴스에 저장된 childs 배열안의 node형태의인스턴스를 모두 꺼내서 반복
      if (node instanceof File) { // 이 안에 저장된 node인스턴스가 File의 자손이라면 
        // A instanceof B A가 B의 자손 혹은 본인이니? 즉 같은 형태 또는 상속받은 형태니?
        System.out.printf("%s/%s\n", path, node.getTitle()); // 경로/node의 타이틀/형태로 표시

      } else if (node instanceof Directory) { // 그게아니라 Directory거라면
        // Directory인스턴스인 node와 node경로까지 포함한 path를 파라미터로 받아서 다시 display 메서드 감.
        display((Directory)node, path + node.getTitle()); 
      }
    }
  }

}
