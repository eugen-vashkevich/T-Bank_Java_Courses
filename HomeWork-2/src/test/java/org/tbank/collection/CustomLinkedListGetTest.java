package org.tbank.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

class CustomLinkedListGetTest {

  @Test
  void emptyList_whenGetSecondElement_thenThrowsException() {
    // Given
    final var list = new CustomLinkedList<Integer>();

    // When and Then
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
  }

  @Test
  void nonEmptyList_whenIndexGreaterThanSize_thenThrowsException() {
    // Given
    final var list = new CustomLinkedList<Integer>(List.of(1, 2, 3));

    // When and Then
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
  }

  @Test
  void nonEmptyList_whenGetSecondElement_thenReturnsSecondElement() {
    // Given
    final var list = new CustomLinkedList<Integer>(List.of(1, 2, 3));
    final int expectedResult = 2;

    // When
    final int actualResult = list.get(1);

    // Then
    Assertions.assertEquals(expectedResult, actualResult);
  }
}
