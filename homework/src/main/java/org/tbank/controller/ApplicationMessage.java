package org.tbank.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Represents specific application messages. */
@AllArgsConstructor
@Getter
public enum ApplicationMessage {
    /**
     * Request user to enter path to the JSON file.
     */
    ENTER_PATH_TO_THE_JSON_FILE("Please enter path to the city JSON file"),
    /**
     * Request user to enter path where to save xml file.
     */
    ENTER_PATH_WHERE_TO_SAVE_XML_FILE("Please enter path where to save the XML file"),
    ERROR_WHILE_PARSING_JSON_FILE("Error while parsing JSON file"),
    ;

    private String text;
}
