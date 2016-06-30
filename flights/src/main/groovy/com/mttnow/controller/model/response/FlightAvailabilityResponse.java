package com.mttnow.controller.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class FlightAvailabilityResponse {

  public final List<AvailabilityResponse> availability;

  @JsonCreator
  public FlightAvailabilityResponse(@JsonProperty("availability") List<AvailabilityResponse> availability) {
    this.availability = availability;
  }

  public List<AvailabilityResponse> getAvailability() {
    return availability;
  }



}
