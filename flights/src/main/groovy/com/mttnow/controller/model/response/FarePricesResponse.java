package com.mttnow.controller.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FarePricesResponse {

  public final PriceResponse first;
  public final PriceResponse business;
  public final PriceResponse economy;

  @JsonCreator
  public FarePricesResponse(@JsonProperty("first") PriceResponse first,
      @JsonProperty("business") PriceResponse business, @JsonProperty("economy") PriceResponse economy) {
    this.first = first;
    this.business = business;
    this.economy = economy;
  }
}
