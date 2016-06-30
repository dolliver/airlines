package com.mttnow.adapters;

import com.mttnow.controller.model.response.MoneyAmountResponse;

import org.springframework.stereotype.Component;

@Component
public class MoneyAmountAdapter {

  public MoneyAmountResponse toEntity(final String amount) {
    if (amount == null) {
      return null;
    }

    String[] moneyParts = amount.split(" ");
    MoneyAmountResponse response = new MoneyAmountResponse(moneyParts[0], Double.valueOf(moneyParts[1]));
    return response;

  }
}
