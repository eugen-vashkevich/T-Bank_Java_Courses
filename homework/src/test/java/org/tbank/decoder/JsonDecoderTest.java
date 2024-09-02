package org.tbank.decoder;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tbank.models.City;
import org.tbank.models.Coordinates;

import static org.tbank.decoder.JsonDecoder.decodeJson;
import static org.tbank.fileutils.FileWorker.readBytesFromFile;

class JsonDecoderTest {

  @Test
  void fileWithCorrectJson_whenDecodeJson_thenReturnsResultOfDecode() {
    // Given
    final var pathToDecodeFile = "src/test/resources/city.json";
    final var expectedResult = new City("spb", new Coordinates(59.939095, 30.315868));
    final var dataFromFile = readBytesFromFile(pathToDecodeFile);

    // When
    final var classToDecode = new TypeReference<City>() {};
    final var actualResult = decodeJson(dataFromFile, classToDecode);

    // Then
    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  void fileWithIncorrectJson_whenDecodeJson_thenThrowsException() {
    // Given
    final var pathToDecodeFile = "src/test/resources/city-error.json";
    final var dataFromFile = readBytesFromFile(pathToDecodeFile);

    // When and Then
    final var classToDecode = new TypeReference<City>() {};
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> decodeJson(dataFromFile, classToDecode));
  }
}
