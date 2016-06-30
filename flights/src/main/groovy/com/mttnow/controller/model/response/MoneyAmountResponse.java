package com.mttnow.controller.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyAmountResponse {

  public final String currency;
  public final double amount;

  @JsonCreator
  public MoneyAmountResponse(@JsonProperty("currency") String currency, @JsonProperty("amount") double amount) {
    this.currency = currency;
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public double getAmount() {
    return amount;
  }


}
