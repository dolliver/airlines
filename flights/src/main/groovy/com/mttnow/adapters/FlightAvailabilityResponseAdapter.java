package com.mttnow.adapters;

import com.mttnow.Availability;
import com.mttnow.Availability.Flight;
import com.mttnow.controller.model.response.AvailabilityResponse;
import com.mttnow.controller.model.response.FlightAvailabilityResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightAvailabilityResponseAdapter {

  @Autowired
  AvailabilityResponseAdapter availabilityResponseAdapter;

  public FlightAvailabilityResponse toEntity(final Availability availability) {
    if (availability == null) {
      return null;
    }

    FlightAvailabilityResponse response = new FlightAvailabilityResponse(generateAvailabilitiesList(availability));
    return response;
  }

  private List<AvailabilityResponse> generateAvailabilitiesList(final Availability availability) {
    List<AvailabilityResponse> availabilities = new ArrayList<AvailabilityResponse>();

    if (availability.getFlight() != null && !availability.getFlight().isEmpty()) {
      for (Flight flight : availability.getFlight()) {
        availabilities.add(availabilityResponseAdapter.toEntity(flight));
      }
    }
    return availabilities;
  }
}
