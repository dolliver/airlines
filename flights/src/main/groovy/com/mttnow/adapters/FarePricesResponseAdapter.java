package com.mttnow.adapters;

import com.mttnow.client.model.Availability.Flight.Fares.Fare;
import com.mttnow.controller.model.response.FarePricesResponse;
import com.mttnow.controller.model.response.PriceResponse;
import com.mttnow.enums.FareClassEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FarePricesResponseAdapter {

  @Autowired
  PriceResponseAdapter priceResponseAdapter;

  public FarePricesResponse toEntity(List<Fare> fares) {

    if (fares == null || fares.isEmpty()) {
      return null;
    }

    PriceResponse first = priceResponseAdapter.toEntity(getFareFromList(fares, FareClassEnum.FIRST));
    PriceResponse business = priceResponseAdapter.toEntity(getFareFromList(fares, FareClassEnum.BUSINESS));
    PriceResponse economy = priceResponseAdapter.toEntity(getFareFromList(fares, FareClassEnum.ECONOMY));

    FarePricesResponse response = new FarePricesResponse(first, business, economy);
    return response;
  }

  private Fare getFareFromList(List<Fare> list, FareClassEnum fareClass) {
    if (list != null && !list.isEmpty()) {
      for (Fare fare : list) {
        if (fare.getClazz().equals(fareClass.code())) {
          return fare;
        }
      }
    }
    return null;
  }

}
