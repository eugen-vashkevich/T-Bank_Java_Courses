package org.tbank.encoder;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Represents specific info messages for log. */
@Getter
@AllArgsConstructor
public enum InfoMessage {
  /**
   * Success message about building xml format.
   */
  SUCCESS("Successfully created xml format"),
  ;

  private String text;
}
