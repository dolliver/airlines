package com.mttnow.controller.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightResponse {
  public final String operator;
  public final String flightNumber;
  public final String departsFrom;
  public final String arrivesAt;
  public final TimeResponse departsOn;
  public final TimeResponse arrivesOn;
  public final String flightTime;
  public final FarePricesResponse farePrices;

  @JsonCreator
  public FlightResponse(@JsonProperty("operator") String operator, @JsonProperty("flightNumber") String flightNumber,
      @JsonProperty("departsFrom") String departsFrom, @JsonProperty("arrivesAt") String arrivesAt,
      @JsonProperty("departsOn") TimeResponse departsOn, @JsonProperty("arrivesOn") TimeResponse arrivesOn,
      @JsonProperty("flightTime") String flightTime, @JsonProperty("farePrices") FarePricesResponse farePrices) {
    this.operator = operator;
    this.flightNumber = flightNumber;
    this.departsFrom = departsFrom;
    this.arrivesAt = arrivesAt;
    this.departsOn = departsOn;
    this.arrivesOn = arrivesOn;
    this.flightTime = flightTime;
    this.farePrices = farePrices;
  }

}
