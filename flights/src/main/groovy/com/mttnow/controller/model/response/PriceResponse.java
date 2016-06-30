package com.mttnow.controller.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceResponse {
    public final MoneyAmountResponse ticket;
    public final MoneyAmountResponse bookingFee;
    public final MoneyAmountResponse tax;

    @JsonCreator
    public PriceResponse(@JsonProperty("ticket") MoneyAmountResponse ticket, @JsonProperty("bookingFee") MoneyAmountResponse bookingFee, @JsonProperty("tax") MoneyAmountResponse tax){
        this.ticket = ticket;
        this.bookingFee = bookingFee;
        this.tax = tax;
    }
}