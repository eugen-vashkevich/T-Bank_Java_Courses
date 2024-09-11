package org.tbank.collection;

import lombok.NoArgsConstructor;
import java.util.List;

/**
 * A custom implementation of a linked list.
 *
 * @param <T> the type of elements held in this list.
 */
@NoArgsConstructor
public class CustomLinkedList<T> implements CustomList<T> {
  private Node<T> head;
  private Node<T> tail;

  private int size;

  /**
   * Constructs a CustomLinkedList with the specified values.
   *
   * @param values the initial values to add to the list
   */
  public CustomLinkedList(List<? extends T> values) {
    addAll(values);
  }

  /**
   * Retrieves the element at the specified position in this list.
   *
   * @param index index of the element to return.
   * @return the element at the specified position in this list.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
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

  /**
   * Appends the specified element to the end of this list.
   *
   * @param data element to be appended to this list.
   * @return true if successfully added element.
   */
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

  /**
   * Removes the first occurrence of the specified element from this list, if it is present.
   *
   * @param data element to be removed from this list, if present
   * @return true if this list contained the specified element
   */
  @Override
  public boolean remove(T data) {
    var node = head;
    for (int i = 0; i < size; i++) {
      if (node.getValue().equals(data)) {
        return removeAt(i);
      }
      node = node.getNext();
    }
    return false;
  }

  /**
   * Removes the element at the specified position in this list.
   *
   * @param index the index of the element to be removed.
   * @return true if the element was successfully removed.
   * @throws IndexOutOfBoundsException if the index is out of range
   */
  @Override
  public boolean removeAt(int index) {
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

  /** Returns size of the list. */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns true if this list contains the specified element.
   *
   * @param data element whose presence in this list is to be tested
   * @return true if this list contains the specified element
   */
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

  /**
   * Appends all of the elements in the specified collection to the end of this list.
   *
   * @param values collection containing elements to be added to this list
   * @return true if this list changed as a result of the call
   */
  @Override
  public boolean addAll(List<? extends T> values) {
    for (var item : values) {
      add(item);
    }
    return true;
  }

  /**
   * Compares the specified object with this list for equality.
   *
   * @param obj the object to be compared for equality with this list
   * @return true if the specified object is equal to this list
   */
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

  /**
   * Returns a string representation of this list.
   *
   * @return a string representation of this list
   */
  @Override
  public String toString() {
    final var sb = new StringBuilder("[");
    var current = head;
    while (current != null) {
      sb.append(current.getValue());
      if (current.getNext() != null) {
        sb.append(", ");
      }
      current = current.getNext();
    }
    sb.append("]");
    return sb.toString();
  }
}
