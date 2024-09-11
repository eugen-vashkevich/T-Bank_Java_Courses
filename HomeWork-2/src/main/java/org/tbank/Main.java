package org.tbank;

import org.tbank.collection.CustomLinkedList;

import java.util.List;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    // Part 1
    final var list = new CustomLinkedList<Integer>();
    list.add(1);
    list.addAll(List.of(2, 3, 4));
    System.out.println(list.get(1));
    System.out.println(list.contains(2));
    System.out.println(list.remove(1));
    System.out.println(list.removeAt(0));
    System.out.println(list.size());
    System.out.println(list);

    // Part 2
    Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

    CustomLinkedList<Integer> listForStream =
        stream.reduce(
            new CustomLinkedList<Integer>(),
            (acc, element) -> {
              acc.add(element);
              return acc;
            },
            (list1, list2) -> {
              list1.addAll((List<? extends Integer>) list2);
              return list1;
            });
    System.out.println(listForStream);
  }
}
