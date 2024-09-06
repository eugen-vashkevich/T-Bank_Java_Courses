package org.tbank.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Represents specific error messages that can occur during file operations in the application. */
@AllArgsConstructor
@Getter
public enum DebugMessages {
  /** Error that occurs while parsing json. */
  READ_BYTES_FROM_FILE("Read  bytes from JSON file"),
  DECODED_JSON("Decoded JSON to object: "),
  ;

  private final String text;
}
