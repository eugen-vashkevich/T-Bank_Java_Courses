package org.tbank.decoder;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Represents specific info messages for log. */
@Getter
@AllArgsConstructor
public enum InfoMessage {
  /** Successful massage about decode JSON. */
  SUCCESS("Successfully decoded JSON to {}"),
  ;

  private String text;
}
