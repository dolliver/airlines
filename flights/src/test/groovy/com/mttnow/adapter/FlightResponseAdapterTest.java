package com.mttnow.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.mttnow.AirlinesApplicationTests;
import com.mttnow.client.model.Availability.Flight;
import com.mttnow.client.model.Availability.Flight.Fares;
import com.mttnow.client.model.Availability.Flight.Fares.Fare;
import com.mttnow.controller.model.response.FlightResponse;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

public class FlightResponseAdapterTest extends AirlinesApplicationTests {

  @Autowired
  private FlightResponseAdapter adapter;


  @Test
  public void testFlightResponseAdapterSuccess() throws DatatypeConfigurationException {
    final Flight mockedFlight = Mockito.mock(Flight.class);
    Mockito.when(mockedFlight.getArrivalDate()).thenReturn(generateXmlDate("2014-07-07T20:50:00"));
    Mockito.when(mockedFlight.getCarrierCode()).thenReturn("AC");
    Mockito.when(mockedFlight.getDepartureDate()).thenReturn(generateXmlDate("2014-07-07T10:30:00"));
    Mockito.when(mockedFlight.getDestinationAirport()).thenReturn("YYZ");
    Mockito.when(mockedFlight.getFlightDesignator()).thenReturn("AC090");
    Mockito.when(mockedFlight.getOriginAirport()).thenReturn("GRU");

    Fares fares = Mockito.mock(Fares.class);
    List<Fare> fareList = new ArrayList<Fare>();
    Fare fare1 = Mockito.mock(Fare.class);
    Mockito.when(fare1.getClazz()).thenReturn("FIF");
    fareList.add(fare1);
    Mockito.when(fares.getFare()).thenReturn(fareList);
    Mockito.when(mockedFlight.getFares()).thenReturn(fares);

    final FlightResponse dto = adapter.toEntity(mockedFlight);

    assertNotNull(dto);
    assertNotNull(dto.getArrivesOn());
    assertNotNull(dto.getDepartsOn());
    assertNotNull(dto.getFarePrices());
    assertEquals("YYZ", dto.getArrivesAt());
    assertEquals("GRU", dto.getDepartsFrom());
    assertEquals("AC090", dto.getFlightNumber());
    assertEquals("10:20", dto.getFlightTime());
    assertEquals("AC", dto.getOperator());

  }

  @Test
  public void testFlightResponseFaresNullList() {
    final Flight mockedFlight = Mockito.mock(Flight.class);
    Mockito.when(mockedFlight.getFares()).thenReturn(null);

    final FlightResponse dto = adapter.toEntity(mockedFlight);

    assertNotNull(dto);
    assertNull(dto.getFarePrices());
  }

  @Test
  public void testFlightResponseNoDepartureDate() {
    final Flight mockedFlight = Mockito.mock(Flight.class);
    Mockito.when(mockedFlight.getDepartureDate()).thenReturn(null);

    final FlightResponse dto = adapter.toEntity(mockedFlight);

    assertNotNull(dto);
    assertNull(dto.getDepartsOn());
    assertNull(dto.getFlightTime());
  }

  @Test
  public void testFlightResponseNoArrivalDate() {
    final Flight mockedFlight = Mockito.mock(Flight.class);
    Mockito.when(mockedFlight.getArrivalDate()).thenReturn(null);

    final FlightResponse dto = adapter.toEntity(mockedFlight);

    assertNotNull(dto);
    assertNull(dto.getArrivesOn());
    assertNull(dto.getFlightTime());
  }

  @Test
  public void testFlightResponseDepartureAfterArrival() throws DatatypeConfigurationException {
    final Flight mockedFlight = Mockito.mock(Flight.class);
    Mockito.when(mockedFlight.getArrivalDate()).thenReturn(generateXmlDate("2014-07-07T20:50:00"));
    Mockito.when(mockedFlight.getDepartureDate()).thenReturn(generateXmlDate("2014-07-07T23:50:00"));

    final FlightResponse dto = adapter.toEntity(mockedFlight);

    assertNotNull(dto);
    assertNotNull(dto.getArrivesOn());
    assertNotNull(dto.getDepartsOn());
    assertNull(dto.getFlightTime());
  }


  @Test
  public void testAdaptNull() {
    final FlightResponse dto = adapter.toEntity(null);
    assertNull(dto);
  }

}
