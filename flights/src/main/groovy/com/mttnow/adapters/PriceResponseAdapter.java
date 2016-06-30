package com.mttnow.adapters;

import com.mttnow.client.model.Availability.Flight.Fares.Fare;
import com.mttnow.controller.model.response.MoneyAmountResponse;
import com.mttnow.controller.model.response.PriceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceResponseAdapter {

  @Autowired
  MoneyAmountAdapter moneyAmountAdapter;

  public PriceResponse toEntity(final Fare fare) {
    if (fare == null) {
      return null;
    }

    MoneyAmountResponse ticket = moneyAmountAdapter.toEntity(fare.getBasePrice());
    MoneyAmountResponse bookingFee = moneyAmountAdapter.toEntity(fare.getFees());
    MoneyAmountResponse tax = moneyAmountAdapter.toEntity(fare.getTax());
    PriceResponse response = new PriceResponse(ticket, bookingFee, tax);
    return response;
  }
}
