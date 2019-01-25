package com.eomcs.util;

import java.util.Arrays;

public interface List<E> {
  
  Object[] toArray();
  public <T> T[] toArray(T[] a);
  public void add(E obj);
  public E get(int index);
  public E set(int index, E obj);
  public E remove(int index);
  public int size();
    
  }