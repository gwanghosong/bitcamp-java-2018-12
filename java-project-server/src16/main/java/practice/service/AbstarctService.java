package practice.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public abstract class AbstarctService<E> {

  List<E> list;

  ObjectInputStream in;
  ObjectOutputStream out;
  String filepath;

  public void init(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }



  public abstract void execute(String request) throws Exception;

}

