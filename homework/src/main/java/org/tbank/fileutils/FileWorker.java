package org.tbank.fileutils;

import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.tbank.fileutils.ErrorReason.ERROR_WHILE_CREATING_FILE;
import static org.tbank.fileutils.ErrorReason.ERROR_WHILE_READING_FILE;
import static org.tbank.fileutils.InfoMessage.SUCCESS;

/** Provides an interface for working with files. */
@Slf4j
public class FileWorker {
  /**
   * Reads the contents of a file specified by the given path and returns it as a byte array.
   *
   * @param pathToFile The path to the file to be read.
   * @return Array of bytes read from file.
   */
  public static byte[] readBytesFromFile(String pathToFile) {
    try {
      final var file = new File(pathToFile);
      return Files.readAllBytes(file.toPath());
    } catch (IOException e) {
      log.warn(ERROR_WHILE_READING_FILE.getText(), e);
      log.error(ERROR_WHILE_READING_FILE.getText(), e);
      throw new IllegalStateException(ERROR_WHILE_READING_FILE.getText(), e);
    }
  }

  /**
   * Creates a file with the specified name and writes the provided data to it.
   *
   * @param pathToSave the pathToSaveFile
   * @param data the data to write into the file
   */
  public static void createFileWithData(String pathToSave, String data) {
    try {
      Path path = Paths.get(pathToSave);
      Files.createDirectories(path.getParent());
      try (FileWriter fileWriter = new FileWriter(path.toFile())) {
        fileWriter.write(data);
        log.info(SUCCESS.getText());
      }
    } catch (IOException e) {
      log.warn(ERROR_WHILE_CREATING_FILE.getText(), e);
      log.error(ERROR_WHILE_CREATING_FILE.getText(), e);
      throw new IllegalStateException(ERROR_WHILE_CREATING_FILE.getText(), e);
    }
  }
}
