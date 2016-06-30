package com.mttnow;

import com.mttnow.adapters.FlightAvailabilityResponseAdapter;
import com.mttnow.client.XMLProcessor;
import com.mttnow.client.model.Availability;
import com.mttnow.controller.model.response.FlightAvailabilityResponse;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirlineResponseProcessor {

  @Autowired
  FlightAvailabilityResponseAdapter adapter;

  public void receive(Exchange exchange) throws Exception {

    Availability avail = XMLProcessor.process((String) exchange.getIn().getBody());
    FlightAvailabilityResponse response = adapter.toEntity(avail);
    exchange.getOut().setBody(response);
    exchange.getOut().setHeaders(exchange.getIn().getHeaders());
  }
}
