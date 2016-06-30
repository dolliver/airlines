package com.mttnow;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mttnow.adapters.FlightAvailabilityResponseAdapter;
import com.mttnow.controller.model.response.FlightAvailabilityResponse;

@Component
public class AirlineResponseProcessor {

	@Autowired
	FlightAvailabilityResponseAdapter adapter;
	
	public void receive(Exchange exchange) throws Exception {
		
		Availability avail = XMLProcessor.process((String)exchange.getIn().getBody());		
    	FlightAvailabilityResponse response = adapter.toEntity(avail);	
		exchange.getOut().setBody(response);
	}

}
