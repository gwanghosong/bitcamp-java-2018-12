// LinkedList배열 연습은 레퍼런스, 주소 개념 이해에 좋다.
package algorithm.data_structure.linkedlist;

import java.awt.Cursor;

public class LinkedList2 {
  Node head;
  Node tail;
  int size;

  public LinkedList2() {
    head = new Node();
    tail = head;
    size = 0;

  }

  // LinkedList는 add() 할 때 마다 노드를 만들어 값을 저장하기 때문에
  // ArrayList 처럼 한 번에 큰 메모리를 준비할 필요가 없다.
  // 그러나 값 이외에 다음 노드와 이전 노드의 주소를 담기 위해 추가로 메모리를 사용한다.
  public void add(Object value) {
    tail.value = value;
    Node node = new Node();
    tail.next = node;
    node.prev = tail;
    tail = node;
    size++;

  }

  public int size() {
    return size;
  }

  // ArrayList와 달리 해당 인덱스를 찾아가려면 링크를 따라가야 하기 때문에
  // 조회속도가 느리다.
  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;

    Node cursor = head;
    // 해당 인덱스로 이동한다.
    // int i = 0이 아닌 이유?
    // index가 0이라면 for문자체가 실행되지않는다.
    // cursor가 head의 인스턴스주소를 가리키고 움직이지 않기 때문에
    // 그대로 head, 즉 index가 0일 때의 value값을 리턴하게된다.
    for (int i = 1; i < size; i++)
      cursor = cursor.next;

    // cursor가 가리키는 노드의 주소를 리턴?
    // 노드의 값을 리턴
    return cursor.value;
  }

  // value 값으로 이루어지고 index값이 같은 순으로 배열만들기
  public Object[] toArray() {
    Object[] arr = new Object[size()];
    
    Node cursor = head;
    // head와 tail이 같을때만 제외
    int i = 0;
    while (cursor != tail) {
      arr[i++] = cursor.value;
      cursor = cursor.next;
    }
    return arr;

  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = head;
    // 교체할 값이 들어 있는 노드로 이동한다.
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    // 변경 전에 이전 값을 보관한다.
    Object old = cursor.value;
    // 값을 변경한다.
    cursor.value = value;
    // 이전 값을 리턴한다. 쓰든 안쓰든 호출하는 사람이 알아서 할 일이다.
    // 다만 변경 전 값을 활용할 경우를 대비해 리턴하는 것이다.
    return old;
  }

  // 값을 삽입하는 경우에는 ArrayList 방식보다 효율적이다.
  // 삽입 위치에 있는 노드를 찾은 후에 새 노드를 앞, 뒤 노드에 연결하면 된다.
  public int insert(int index, Object value) {
    if (index < 0 || index >= size)
      return -1;
    
    // 새 노드를 만들어 값을 담는다.
    Node node = new Node(value);

    // 삽입할 위치에 있는 원래 노드를 찾는다.
    Node cursor = head;

    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }

    // 새 노드가 찾은 노드를 가리키게 한다.
    // 찾은 노드를 뒤로 밀거니까
    node.next = cursor;

    // 찾은 노드의 이전 노드 주소를 새 노드의 이전 노드 주소로 설정한다.
    node.prev = cursor.prev;

    // 찾은 노드의 이전 노드로 새 노드를 가리키게 한다.
    cursor.prev = node;

    // 이전 노드의 다음 노드로 새 노드를 가리키게 한다.
    if (node.prev != null) {
    node.prev.next = node;
    // null.next = node; nullPointerException에러
    } else {
      head = node;
    }
    // 맨 앞에 노드를 추가할 때는 head를 변경해야 한다.
    // 크기를 늘린다.
    size++;
    
    return 0;

  }

  public Object remove(int index) {
    if (index < 0 || index >= size)
      return null;

    // index 위치에 있는 노드를 찾는다.
    Node cursor = head;

    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    // 찾은 노드의 이전 노드가 다음 노드를 가리키게 한다.
    if (cursor.prev != null) {
    cursor.prev.next = cursor.next;
    } else {
      // 맨 처음 노드를 삭제할 때
      head = cursor.next;
    }

    // 찾은 노드의 다음 노드가 이전 노드를 가리키게 한다.
    cursor.next.prev = cursor.prev;

    // JVM(Garbage Collector)가 가비지를 효과적으로 계산할 수 있도록
    // 가비지가 된 객체는 다른 객체를 가리키지 않도록 한다.
    Object old = cursor.value;
    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;

    //크기를 줄인다.
    size--;

    // 호출한 쪽에서 필요하면 사용하라고 삭제된 값을 리턴해 준다.
    return old;

  }
}






