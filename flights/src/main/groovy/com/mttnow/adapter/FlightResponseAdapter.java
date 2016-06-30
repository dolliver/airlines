package com.mttnow.adapter;

import com.mttnow.client.model.Availability.Flight;
import com.mttnow.controller.model.response.FarePricesResponse;
import com.mttnow.controller.model.response.FlightResponse;
import com.mttnow.controller.model.response.TimeResponse;
import com.mttnow.util.MTTDateTimeUtils;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class FlightResponseAdapter {

  @Autowired
  FarePricesResponseAdapter farePricesResponseAdapter;

  @Autowired
  TimeResponseAdapter timeResponseAdapter;

  public FlightResponse toEntity(final Flight flight) {
    if (flight == null) {
      return null;
    }

    FarePricesResponse farePrices = null;
    if (flight.getFares() != null) {
      farePrices = farePricesResponseAdapter.toEntity(flight.getFares().getFare());
    }

    TimeResponse arrivesOn = timeResponseAdapter.toEntity(flight.getArrivalDate());
    TimeResponse departsOn = timeResponseAdapter.toEntity(flight.getDepartureDate());
    String flightTime = calculateFlightDuration(flight.getDepartureDate(), flight.getArrivalDate());
    FlightResponse response =
        new FlightResponse(flight.getCarrierCode(), flight.getFlightDesignator(), flight.getOriginAirport(),
            flight.getDestinationAirport(), departsOn, arrivesOn, flightTime, farePrices);

    return response;
  }

  private String calculateFlightDuration(XMLGregorianCalendar departureDate, XMLGregorianCalendar arrivalDate) {

    if (departureDate == null || arrivalDate == null || departureDate.compare(arrivalDate) > 0) {
      return null;
    }

    DateTime start = new DateTime(departureDate.toGregorianCalendar().getTime());
    DateTime end = new DateTime(arrivalDate.toGregorianCalendar().getTime());
    Duration duration = new Duration(start, end);
    return MTTDateTimeUtils.getStringFromDuration(duration);

  }


}
