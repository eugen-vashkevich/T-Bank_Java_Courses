package org.tbank.encoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tbank.models.City;
import org.tbank.models.Coordinates;

import static org.tbank.encoder.XmlBuilder.toXml;

class XmlBuilderTest {
  @Test
  void buildXmlFormat() {
    // Given
    final var city = new City("spb", new Coordinates(59.939095, 30.315868));
    final var expectedResult =
        "<City><slug>spb</slug><coords><lat>59.939095</lat><lon>30.315868</lon></coords></City>";

    // When
    final var result = toXml(city);

    // Then
    Assertions.assertEquals(expectedResult, result);
  }
}
