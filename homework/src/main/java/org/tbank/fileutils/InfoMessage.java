package org.tbank.fileutils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Represents specific info messages for log. */
@Getter
@AllArgsConstructor
public enum InfoMessage {
  /** Successful massage about creating file. */
  SUCCESS("Successfully created file"),
  ;

  private String text;
}
