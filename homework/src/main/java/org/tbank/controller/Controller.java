package org.tbank.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.tbank.models.City;
import org.tbank.view.View;

import static org.tbank.controller.ApplicationMessage.*;
import static org.tbank.controller.DebugMessages.DECODED_JSON;
import static org.tbank.controller.DebugMessages.READ_BYTES_FROM_FILE;
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
@Slf4j
public class Controller {

  private View view;

  /** Starts the main user flow of the application. */
  public void run() {
    view.print(ENTER_PATH_TO_THE_JSON_FILE.getText());

    final var pathToJsonFile = view.getUserInput();

    final var bytesFromFile = readBytesFromFile(pathToJsonFile);
    log.debug(READ_BYTES_FROM_FILE.getText(), bytesFromFile.length);
    final var classToDecode = new TypeReference<City>() {};
    final var resultOfJsonDecode = decodeJson(bytesFromFile, classToDecode);
    log.debug(DECODED_JSON.getText(), resultOfJsonDecode);

    final var xmlRepresentation = toXml(resultOfJsonDecode);

    view.print(ENTER_PATH_WHERE_TO_SAVE_XML_FILE.getText());
    final var pathForSaveFile = view.getUserInput();

    createFileWithData(pathForSaveFile, xmlRepresentation);
  }
}
