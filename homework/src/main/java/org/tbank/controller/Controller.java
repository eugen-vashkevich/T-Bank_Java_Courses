package org.tbank.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.tbank.models.City;
import org.tbank.view.View;

import java.io.IOException;

import static org.tbank.controller.ApplicationMessage.*;
import static org.tbank.decoder.JsonDecoder.decodeJson;
import static org.tbank.encoder.XmlBuilder.toXml;
import static org.tbank.fileutils.FileWorker.createFileWithData;
import static org.tbank.fileutils.FileWorker.readBytesFromFile;

/**
 * The main entry point for the application, from which the user's interaction with the program
 * begins.
 */
@NoArgsConstructor
@AllArgsConstructor
public class Controller {

  private View view;

  /** Starts the main user flow of the application. */
  public void run() {
    view.print(ENTER_PATH_TO_THE_JSON_FILE.getText());

    final var pathToJsonFile = view.getUserInput();

    final var bytesFromFile = readBytesFromFile(pathToJsonFile);
    final var classToDecode = new TypeReference<City>() {};
    final var resultOfJsonDecode = decodeJson(bytesFromFile, classToDecode);

    final var xmlRepresentation = toXml(resultOfJsonDecode);

    view.print(ENTER_PATH_WHERE_TO_SAVE_XML_FILE.getText());
    final var pathForSaveFile = view.getUserInput();

    createFileWithData(pathForSaveFile, xmlRepresentation);
  }
}
