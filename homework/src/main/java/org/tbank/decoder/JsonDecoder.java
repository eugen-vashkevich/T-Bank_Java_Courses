package org.tbank.decoder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;

import static org.tbank.decoder.ErrorReason.ERROR_WHILE_PARSING_FILE;

/** Provides functionality to decode JSON files into the specified type. */
@Slf4j
public class JsonDecoder {

  /**
   * Decodes a JSON file into a list of objects of the specified type.
   *
   * @param bytesToBeDecoded The raw bytes which should be decoded.
   * @param classToDecode Representing the type of the object to be decoded.
   * @return The type of the object to be decoded represented in <var>classToDecode</var>.
   * @throws IOException If there is an error reading the file or parsing the JSON.
   */
  public static <T> T decodeJson(byte[] bytesToBeDecoded, TypeReference<T> classToDecode)
      throws IOException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode jsonNode = mapper.readTree(bytesToBeDecoded);
      return mapper.readValue(jsonNode.traverse(), classToDecode);
    } catch (IOException e) {
      log.error(ERROR_WHILE_PARSING_FILE.getText(), e.getMessage());
      throw new IllegalStateException(ERROR_WHILE_PARSING_FILE.getText(), e);
    }
  }
}
