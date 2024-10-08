package org.tbank.encoder;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static org.tbank.encoder.InfoMessage.SUCCESS;
import static org.tbank.encoder.ErrorReason.ERROR_WHILE_CONVERTING_TO_XML;

/** Provides a utility method for converting Java objects into XML format. */
@Slf4j
public class XmlBuilder {

  /**
   * Converts a given Java object into XML format.
   *
   * @param <T> the object to be converted
   * @param classToBeConverted the object instance to convert to XML
   * @return a string representation of the object in XML format
   * @throws IllegalStateException if an error occurs during XML conversion
   */
  public static <T> String toXml(T classToBeConverted) {
    final var xmlMapper = new XmlMapper();
    try {
      final var xmlFormat = xmlMapper.writeValueAsString(classToBeConverted);
      log.info(SUCCESS.getText());
      return xmlFormat;
    } catch (IOException e) {
      log.error(ERROR_WHILE_CONVERTING_TO_XML.getText(), e);
      throw new IllegalStateException(ERROR_WHILE_CONVERTING_TO_XML.getText(), e);
    }
  }
}
