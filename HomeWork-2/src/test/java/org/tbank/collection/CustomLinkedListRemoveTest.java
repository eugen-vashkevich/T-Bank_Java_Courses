package org.tbank.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomLinkedListRemoveTest {
  @Test
  void emptyList_whenRemoveElement_thenThrowsException() {
    // Given
    final var list = new CustomLinkedList<Integer>();

    // When and Then
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(0));
  }

  @Test
  void nonEmptyList_whenRemoveElementWhichIsMissing_thenReturnsFalse() {
    // Given
    final var list = new CustomLinkedList<>(List.of(1, 2, 3, 4));
    final var expectedResult = false;

    // When
    final var actualResult = list.remove(0);

    // Then
    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  void nonEmptyList_whenRemoveElementSecondElement_thenReturnsTrue() {
    // Given
    final var list = new CustomLinkedList<>(List.of(1, 2, 3, 4));
    final var expectedResult = new CustomLinkedList<>(List.of(1, 3, 4));

    // When
    list.removeAt(1);

    // Then
    Assertions.assertEquals(expectedResult, list);
  }

  @Test
  void nonEmptyList_whenRemoveElementFirstElement_thenReturnsTrue() {
    // Given
    final var list = new CustomLinkedList<>(List.of(1, 2, 3, 4));
    final var expectedResult = new CustomLinkedList<>(List.of(2, 3, 4));

    // When
    list.remove(1);

    // Then
    Assertions.assertEquals(expectedResult, list);
  }

  @Test
  void nonEmptyList_whenRemoveElementLastElement_thenReturnsTrue() {
    // Given
    final var list = new CustomLinkedList<>(List.of(1, 2, 3, 4));
    final var expectedResult = new CustomLinkedList<>(List.of(1, 2, 3));

    // When
    list.removeAt(3);

    // Then
    Assertions.assertEquals(expectedResult, list);
  }
}
