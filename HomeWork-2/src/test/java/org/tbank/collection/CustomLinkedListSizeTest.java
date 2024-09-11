package org.tbank.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomLinkedListSizeTest {

  @Test
  void emptyLinkedList_whenCheckSize_thenReturnsZero() {
    // Given
    final var list = new CustomLinkedList<Integer>();
    final int expectedSize = 0;

    // When
    final int actualSize = list.size();

    // Then
    Assertions.assertEquals(expectedSize, actualSize);
  }

  @Test
  void linkedListWithTwoElements_whenCheckSize_thenReturnsTwo() {
    //Given
    final var list = new CustomLinkedList<>(List.of(1,2));
    final int expectedSize = 2;

    // When
    final int actualSize = list.size();

    // Then
    Assertions.assertEquals(expectedSize, actualSize);
  }
}
