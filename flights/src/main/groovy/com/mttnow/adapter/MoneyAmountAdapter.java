package com.mttnow.adapter;

import com.mttnow.controller.model.response.MoneyAmountResponse;

import org.springframework.stereotype.Component;

@Component
public class MoneyAmountAdapter {

  public MoneyAmountResponse toEntity(final String amount) {
    if (amount == null || amount.isEmpty()) {
      return null;
    }

    try {
      String[] moneyParts = amount.split(" ");

      if (moneyParts[0].isEmpty() || moneyParts[1].isEmpty()) {
        return null;
      }

      MoneyAmountResponse response = new MoneyAmountResponse(moneyParts[0], Double.valueOf(moneyParts[1]));
      return response;
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
      // TODO logger
      /*
       * Choosing to return null when client application does not follow
       * contract in order to avoid internal server errors and increase
       * availability of the Application. Consumers may then decide what to do
       * when Money Amount is null (like not permitting to finish a Sale, but
       * the flights will still be available to be seen
       */

      return null;
    }

  }
}
