package org.tbank.view;

import java.util.Scanner;

/**
 * Provides an interface to output processed data to the standard output stream and read data from
 * the standard input stream.
 */
public class View {

  /** Reads data from the standard input stream. */
  public String getUserInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
  /**
   * Outputs the result of data processing to the output stream.
   *
   * @param message Processed data prepared for display.
   */
  public void print(String message) {
    System.out.println(message);
  }
}
