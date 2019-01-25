package design_pattern.iterator;

public class ArrayList<E> {
  static final int DEFAULT_SIZE = 5;

  Object[] arr;
  int size;

  public ArrayList() {
    this(0);
  }

  public ArrayList(int capacity) {
    if (capacity > DEFAULT_SIZE)
      arr = new Object[capacity];
    else
      arr = new Object[DEFAULT_SIZE];
  }

  public Object[] toArray() {
    Object[] list = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      list[i] = this.arr[i];
    }
    return list;
  }

  public void add(E value) {
    if (arr.length == this.size) {
      increase();
    }

    arr[this.size++] = value;
  }




  public int insert(int index, E value) {
    if (index < 0 || index >= size) 
      return -1;

    if (arr.length == this.size) 
      increase();

    for (int i = size - 1; i >= index; i--)
      this.arr[i + 1] = this.arr[i];

    this.arr[index] = value;
    size++;

    return 0;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {

    if (index < 0 || index >= size)
      return null;
    return (E) this.arr[index];
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;

    E old = (E) this.arr[index];
    this.arr[index] = value;
    return old;
  }

  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;

    E old = (E) this.arr[index];

    for(int i = index; i < size - 1; i++) 
      this.arr[i] = this.arr[i + 1];

    size --;

    return old;
  }

  public int size() {
    return this.size;
  }

  private void increase() {
    int oldCapacity = arr.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1); 
    Object[] temp = new Object[newCapacity];
    for (int i = 0; i < this.arr.length; i++) {
      temp[i] = this.arr[i];
    }
    arr = temp;
  }

  // 자신이 보유한 데이터를 대신 꺼내주는 일을 하는 객체를 리턴한다.
  // 제네릭이 적용된 메서드를 리턴하는 메서드
  // 참고 : 제네릭 <다루는 타입의 별명> 리턴타입 메서드명 (다루는타입별명 파라미터, ...) {...}
  // 여기서는 iterator()라는 메서드가 Iterator<E>라는 객체 자체를 리턴해버림.
  // 생성자, 제너릭이 아니라 메서드다.
  // Iterator<E>라는 객체 자체를 리턴해 버리는 메서드
  
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      // 이 클래스는 ArrayList에서 값을 꺼내주는 일을 전문적으로 한다.
      // 이런 일을 하는 객체를 "Iterator"라 부른다.
      // 
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < size();
      }

      @Override
      public E next() {
        return (E) get(index++);
      }
    };
  }


}

