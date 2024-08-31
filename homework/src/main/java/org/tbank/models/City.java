package org.tbank.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Represents a city with a unique slug identifier and its coordinates. */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {
  private String slug;

  @JsonProperty("coords")
  private Coordinates coordinates;
}
