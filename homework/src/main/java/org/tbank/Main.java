package org.tbank;

import org.tbank.controller.Controller;
import org.tbank.view.View;

public class Main {
  public static void main(String[] args) {
    final var view = new View();
    final var controller = new Controller(view);

    controller.run();
  }
}
