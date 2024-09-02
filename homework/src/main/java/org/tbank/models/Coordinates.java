package org.tbank.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Represents geographical coordinates. It includes latitude and longitude properties. */
public record Coordinates(
    @JsonProperty("lat") double latitude, @JsonProperty("lon") double longitude) {}
