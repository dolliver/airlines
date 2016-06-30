package com.mttnow.adapters;

import com.mttnow.Availability.Flight;
import com.mttnow.controller.model.response.AvailabilityResponse;
import com.mttnow.controller.model.response.FlightResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvailabilityResponseAdapter {

  @Autowired
  FlightResponseAdapter flightResponseAdapter;

  public AvailabilityResponse toEntity(final Flight flight) {
    if (flight == null) {

      return null;
    }

    FlightResponse flightResponse = flightResponseAdapter.toEntity(flight);
    AvailabilityResponse response = new AvailabilityResponse(flightResponse);
    return response;
  }
}
