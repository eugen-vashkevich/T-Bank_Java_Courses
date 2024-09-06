package org.tbank.decoder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;

import static org.tbank.decoder.ErrorReason.ERROR_WHILE_PARSING_FILE;
import static org.tbank.decoder.InfoMessage.SUCCESS;

/** Provides functionality to decode JSON files into the specified type. */
@Slf4j
public class JsonDecoder {

  /**
   * Decodes a JSON file into a list of objects of the specified type.
   *
   * @param bytesToBeDecoded The raw bytes which should be decoded.
   * @param classToDecode Representing the type of the object to be decoded.
   * @return The type of the object to be decoded represented in <var>classToDecode</var>.
   */
  public static <T> T decodeJson(byte[] bytesToBeDecoded, TypeReference<T> classToDecode) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      JsonNode jsonNode = mapper.readTree(bytesToBeDecoded);
      final var result = mapper.readValue(jsonNode.traverse(), classToDecode);
      log.info(SUCCESS.getText(), classToDecode.getType());
      return result;
    } catch (JsonParseException e) {
      log.warn(ERROR_WHILE_PARSING_FILE.getText(), e.getMessage());
      log.error(ERROR_WHILE_PARSING_FILE.getText(), e);
      throw new IllegalArgumentException(ERROR_WHILE_PARSING_FILE.getText(), e);
    } catch (IOException e) {
      log.warn(ERROR_WHILE_PARSING_FILE.getText(), e.getMessage());
      log.error(ERROR_WHILE_PARSING_FILE.getText());
      throw new IllegalStateException(ERROR_WHILE_PARSING_FILE.getText());
    }
  }
}
