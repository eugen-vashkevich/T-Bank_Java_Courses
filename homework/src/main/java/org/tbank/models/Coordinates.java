package org.tbank.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Represents geographical coordinates. It includes latitude and longitude properties. */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates {
  @JsonProperty("lat")
  private double latitude;

  @JsonProperty("lon")
  private double longitude;
}
