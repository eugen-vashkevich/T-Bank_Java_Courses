package org.tbank.encoder;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Represents specific error messages that can occur during file operations in the application. */
@AllArgsConstructor
@Getter
public enum ErrorReason {
  /** Error that occurs while converting to XML. */
  ERROR_WHILE_CONVERTING_TO_XML("Error while converting to XML"),;

  private final String text;
}
