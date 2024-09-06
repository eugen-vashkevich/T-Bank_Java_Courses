package org.tbank.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Represents specific info messages for log. */
@Getter
@AllArgsConstructor
public enum InfoMessage {
  /** Successful massage about decode JSON. */
  REQUEST_USER_INPUT("Request user input"),
  ;

  private String text;
}
