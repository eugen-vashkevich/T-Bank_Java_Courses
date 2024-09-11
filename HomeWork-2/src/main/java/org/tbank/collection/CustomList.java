package org.tbank.collection;

import java.util.List;

public interface CustomList<T> extends Iterable<T> {
  T get(int index);

  void add(T data);

  int size();

  boolean contains(T data);

  void addAll(List<? extends T> values);
}
