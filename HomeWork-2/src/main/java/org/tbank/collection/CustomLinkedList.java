package org.tbank.collection;

import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@NoArgsConstructor
public class CustomLinkedList<T> implements CustomList<T> {
  private Node<T> head;
  private Node<T> tail;

  private int size;

  public CustomLinkedList(List<? extends T> values) {
    addAll(values);
  }

  @Override
  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    var current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getValue();
  }

  @Override
  public boolean add(T data) {
    final var newNode = new Node<>(data);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.setNext(newNode);
      tail = newNode;
    }
    size++;
    return true;
  }

  @Override
  public boolean remove(T data) {
    var node = head;
    for (int i = 0; i < size; i++) {
      if (node.getValue().equals(data)) {
        return remove(i);
      }
      node = node.getNext();
    }
    return false;
  }

  @Override
  public boolean remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    if (index == 0) {
      head = head.getNext();
      if (head == null) {
        tail = null;
      }
      size--;
      return true;
    }

    var current = head;
    for (int i = 0; i < index - 1; i++) {
      current = current.getNext();
    }

    current.setNext(current.getNext().getNext());

    if (current.getNext() == null) {
      tail = current;
    }

    size--;
    return true;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean contains(T data) {
    var current = head;
    while (current != null) {
      if (current.getValue().equals(data)) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  @Override
  public boolean addAll(List<? extends T> values) {
    for (var item : values) {
      add(item);
    }
    return true;
  }

  @Override
  public Iterator<T> iterator() {
    return new CustomLinkedListIterator();
  }

  private class CustomLinkedListIterator implements Iterator<T> {
    private Node<T> current = head;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      final T data = current.getValue();
      current = current.getNext();
      return data;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    CustomLinkedList<?> otherList = (CustomLinkedList<?>) obj;

    if (size != otherList.size) {
      return false;
    }

    var current = head;
    var otherCurrent = otherList.head;

    while (current != null) {
      if (!current.getValue().equals(otherCurrent.getValue())) {
        return false;
      }
      current = current.getNext();
      otherCurrent = otherCurrent.getNext();
    }

    return true;
  }
}
