// 제네릭 적용
package design_pattern.iterator;

import algorithm.data_structure.linkedlist3.LinkedList;

// Queue가 보관하는 데이터 타입을 E라고 가정하자.
// E라고 가정한 상태에서 코드를 작성한다.
//
public class Queue<E> extends LinkedList<E> {

  public void offer(E value) {
    // 상속 받은 메서드를 사용하여 값을 추가하라.
    this.add(value);
  }

  public E poll() {
    // 상속 받은 메서드를 사용하여 값을 꺼내라.

    return this.remove(0);

  }

  public boolean empty() {
    // 상속 받은 필드나 메서드를 사용하여 값을 리턴하라.
    return this.size == 0;
  }

  // 자신이 보유한 데이터를 대신 꺼내주는 일을 하는 객체를 리턴한다.
  public Iterator<E> iterator() {  
    return new Iterator<E>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < size();
      }

      @SuppressWarnings("unchecked")
      @Override
      public E next() {
        return (E) get(index++);
      }
    };
  }
}


