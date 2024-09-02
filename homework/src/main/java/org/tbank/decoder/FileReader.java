package org.tbank.decoder;

import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.tbank.decoder.ErrorReason.ERROR_WHILE_READING_FILE;

/** Provides an interface for reading files as a byte array. */
@Slf4j
public class FileReader {
  /**
   * Reads the contents of a file specified by the given path and returns it as a byte array.
   *
   * @param pathToFile The path to the file to be read.
   * @return Array of bytes read from file.
   * @throws IOException If file does not exist or is an error reading file.
   */
  public static byte[] readBytesFromFile(String pathToFile) throws IOException {
    try {
      final var file = new File(pathToFile);
      return Files.readAllBytes(file.toPath());
    } catch (IOException e) {
      log.error(ERROR_WHILE_READING_FILE.getText(), e);
      throw new IllegalStateException(ERROR_WHILE_READING_FILE.getText(), e);
    }
  }
}
