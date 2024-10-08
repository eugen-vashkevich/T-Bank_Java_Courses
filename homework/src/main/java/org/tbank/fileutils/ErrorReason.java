package org.tbank.fileutils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Represents specific error messages that can occur during file operations in the application. */
@AllArgsConstructor
@Getter
public enum ErrorReason {
  /** Error that occurs while reading a file. */
  ERROR_WHILE_READING_FILE("Error while reading file"),
  /** Error that occurs while parsing json. */
  ERROR_WHILE_CREATING_FILE("Error while reading file"),
  ;

  private final String text;
}
