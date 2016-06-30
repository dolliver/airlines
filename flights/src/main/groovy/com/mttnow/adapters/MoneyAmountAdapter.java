package com.mttnow.adapters;

import org.springframework.stereotype.Component;

import com.mttnow.controller.model.response.MoneyAmountResponse;

@Component
public class MoneyAmountAdapter {
	
	public MoneyAmountResponse toEntity(final String amount) {
		
		if(amount == null) {
			return null;
		}
		
	
		String[] moneyParts = amount.split(" ");
		MoneyAmountResponse response = new MoneyAmountResponse(moneyParts[0], Double.valueOf(moneyParts[1]));
		return response;

	}
}
