package org.tbank.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Represents a city with a unique slug identifier and its coordinates. */
public record City(String slug, @JsonProperty("coords") Coordinates coordinates) {
}
