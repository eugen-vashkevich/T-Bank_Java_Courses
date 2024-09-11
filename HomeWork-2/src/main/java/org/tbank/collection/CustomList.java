package org.tbank.collection;

import java.util.List;

public interface CustomList<T> {
  T get(int index);

  boolean add(T data);

  boolean remove(T data);
  boolean removeAt(int index);

  int size();

  boolean contains(T data);

  boolean addAll(List<? extends T> values);
}
