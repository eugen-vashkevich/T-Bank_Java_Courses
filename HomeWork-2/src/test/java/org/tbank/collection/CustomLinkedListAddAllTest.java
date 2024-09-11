package org.tbank.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class CustomLinkedListAddAllTest {

  @Test
  void emptyLinkedList_whenAddAll_thenContainsAllElements() {
    // Given
    final var emptyLinkedList = new CustomLinkedList<>();
    final var expectedList = new CustomLinkedList<>(List.of(1, 2, 3, 4));

    // When
    emptyLinkedList.addAll(List.of(1, 2, 3, 4));

    // Then
    Assertions.assertEquals(expectedList, emptyLinkedList);
  }

  @Test
  void nonEmptyLinkedList_whenAddAll_thenContainsAllElements() {
    // Given
    final var list = new CustomLinkedList<>(List.of(1, 2, 3));
    final var expectedList = new CustomLinkedList<>(List.of(1, 2, 3, 4, 5, 6));

    // When
    list.addAll(List.of(4, 5, 6));

    // Then
    Assertions.assertEquals(expectedList, list);
  }
}
