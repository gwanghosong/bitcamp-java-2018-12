package algorithm.data_structure.array;

public class ArrayList {
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
  // add는 length고 toArray는 size인 이유
  // add는 배열이 꽉차면 배열을 증가시킨 곳에 arr 값을 넣기때문에
  // size로 하면 원래 배열 size == arr.length == 4일때
  // 4 + 2 즉 6개를 집어넣어야되는데 5,6번째값은 존재하지가 않는다.
  // 즉 성립자체가 안되기때문에 arr.length를 넣어야하고
  // toArray는 해당 배열을 리턴하는 것이기때문에
  // 즉, add처럼 증가하는 함수가 없어서
  // size만큼 리턴하면 딱 맞는다.
  // 그래서 add는 arr.length, toArray는 size를 써서 for문을 돌린다.
  public void add(Object value) {
    // 현재 배열이 꽉 찼다면(==) 현재 배열 크기의 50%만큼 증가시켜라.
    if (arr.length == this.size) {
      increase();
    }
    
    arr[this.size++] = value;
  }
    
    
    /*
     * 의문점 왜 안될까?
     if (DEFAULT_SIZE >= size)
      return;
    else 
      size = (this.size >> 1);
      */
  public Object[] toArray() {
   // return Arrays.copyOf(arr, size, arr.getClass());
    
    Object[] list = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      list[i] = this.arr[i];
    }
    return list;
  }

  
  
  public int insert(int index, Object value) {
    if (index < 0 || index >= size) // insert란 원래있는 배열의 index에 삽입하고
      // 그 뒤에있는 배열을 뒤로 밀어내는 것으로
      // size보다 같거나 큰 값을 집어넣는다는 것은 애초에 배열에 존재하는 index가 아닌
      // +a인 곳에 넣는다는 것으로 insert 개념자체가 성립하지 않는다.
      return -1;
    
    if (arr.length == this.size) 
      increase();
    
    for (int i = size - 1; i >= index; i--)
      this.arr[i + 1] = this.arr[i];
    
    this.arr[index] = value;
    size++;
    
    return 0;
  }

  
  // 현재 배열이 꽉 찼다면 현재 배열 크기의 50%만큼 증가시켜라.
  // 유효 범위가 아니면 저장하지 말라.
  // 삽입할 위치의 항목부터 이후의 항목들을 뒤로 밀어라.
  /*if (arr.length >= size) {
      int oldcapacity = arr.length;
      int newcapacity = oldcapacity + (oldcapacity >> 1); 
      arr = Arrays.copyOf(arr, newcapacity);
    } 
    arr[size++] = value;
    
    if (arr != arr[index])
      return null;
    
    @SuppressWarnings("unused")
    Object obj = arr[index];
    
    for (int i = index; i < size; i++) {
        Object temp = new Object[size];
        temp = arr[i];
        if (i <= 0) 
          return null;
        else {
        arr[i] = arr[i - 1];
        arr[i + 1] = temp;
        size++;
        }
      }
      return obj;
   */
 
  
  public Object get(int index) {
    // 유효 인덱스(현재 배열의 데이터가 저장된 방번호)가 아니면 null을 리턴하라.
    /*
     * if (arr != arr[index])
      return null;
    
    @SuppressWarnings("unused")
    Object obj = arr[index];
    
    return arr[index];
     */
    if (index < 0 || index >= size)
      return null;
    return this.arr[index];
  }
  
  public Object set(int index, Object value) {
  // 유효 인덱스(현재 배열의 데이터가 저장된 방번호)가 아니면 변경하지 말라. 리턴 값은 null이다.
    if (index < 0 || index >= size)
      return null;
    
    Object old = this.arr[index];
    this.arr[index] = value;
    return old;
  }
    /*if (arr != arr[index])
      return null;
    
    @SuppressWarnings("unused")
    Object obj = arr[index];
    
    arr[index] = value;
    
    return obj;
    */
  
  public Object remove(int index) {
  // 유효 인덱스(현재 배열의 데이터가 저장된 방번호)가 아니면 삭제하지 말라. 리턴 값은 null이다.
  // 삭제한 후 다음 항목을 앞으로 당긴다.
    if (index < 0 || index >= size)
      return null;
    
    Object old = this.arr[index];
    
    for(int i = index; i < size - 1; i++) 
      this.arr[i] = this.arr[i + 1];
      
      size --;
      
      return old;
    }
    /*if (arr != arr[index])
      return null;
    else {
      remove(index);
     
    @SuppressWarnings("unused")
    Object obj = arr[index];
    
    for (int i = index; i < size; i++) {
        arr[i] = arr[i + 1];
        size--;
      }
      return obj;
      }
      */
    
  
  public int size() {
    return this.size;
  }
  
  private void increase() {
    int oldCapacity = arr.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1); 
    //arr = Arrays.copyOf(arr, newCapacity);
    Object[] temp = new Object[newCapacity];
    for (int i = 0; i < this.arr.length; i++) {
      temp[i] = this.arr[i];
    }
    arr = temp;
  }
}

/*
void reverse(int[] values) {

}
 */

