package org.tbank.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomLinkedListContainsTest {
  @Test
  void emptyList_whenContainsElements_thenReturnsFalse() {
    // Given
    final var list = new CustomLinkedList<>();
    final var expectedResult = false;

    // When
    final var actualResult = list.contains(3);

    // Then
    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  void nonEmptyList_whenContainsElementsWhichIsMissing_thenReturnsFalse() {
    // Given
    final var list = new CustomLinkedList<>(List.of(1, 3, 2, 5));
    final var expectedResult = false;

    // When
    final var actualResult = list.contains(4);

    // Then
    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  void nonEmptyList_whenContainsElements_thenReturnsTrue() {
    // Given
    final var list = new CustomLinkedList<>(List.of(1, 3, 2, 5));
    final var expectedResult = true;

    // When
    final var actualResult = list.contains(5);

    // Then
    Assertions.assertEquals(expectedResult, actualResult);
  }
}
