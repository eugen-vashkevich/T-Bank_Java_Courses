package org.tbank.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomLinkedListAddTest {

  @Test
  void emptyList_whenAddOneElement_thenReturnTrue() {
    // Given
    final var list = new CustomLinkedList<>();
    final var expectedResult = true;

    // When
    final var actualResult = list.add(1);

    // Then
    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  void nonEmptyList_whenAddOneElement_thenReturnTrue() {
    // Given
    final var list = new CustomLinkedList<>(List.of(1, 2, 3));
    final var expectedResult = true;

    // When
    final var actualResult = list.add(1);

    // Then
    Assertions.assertEquals(expectedResult, actualResult);
  }
}
