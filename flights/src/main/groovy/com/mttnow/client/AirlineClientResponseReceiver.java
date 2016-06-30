package com.mttnow.client;

import com.mttnow.adapter.FlightAvailabilityResponseAdapter;
import com.mttnow.client.model.Availability;
import com.mttnow.controller.model.response.FlightAvailabilityResponse;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.StringReader;

import javax.xml.bind.JAXB;

@Component
public class AirlineClientResponseReceiver {

  @Autowired
  FlightAvailabilityResponseAdapter adapter;

  public void receive(Exchange exchange) {

    // Parse client XML response to Java Pojo
    String clientXmlResponse = (String) exchange.getIn().getBody();
    Availability avail = JAXB.unmarshal(new StringReader(clientXmlResponse), Availability.class);

    // Adapt Java XML Pojo to Controller Response Format
    FlightAvailabilityResponse response = adapter.toEntity(avail);
    exchange.getOut().setBody(response);
    exchange.getOut().setHeaders(exchange.getIn().getHeaders());
  }
}
