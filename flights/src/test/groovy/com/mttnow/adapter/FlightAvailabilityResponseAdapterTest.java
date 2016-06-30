package com.mttnow.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.mttnow.AirlinesApplicationTests;
import com.mttnow.client.model.Availability;
import com.mttnow.client.model.Availability.Flight;
import com.mttnow.controller.model.response.FlightAvailabilityResponse;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FlightAvailabilityResponseAdapterTest extends AirlinesApplicationTests {

  @Autowired
  private FlightAvailabilityResponseAdapter adapter;

  @Test
  public void testFlightAvailabilityResponseAdapterSuccess() {
    final Availability mockedAvailability = Mockito.mock(Availability.class);
    List<Flight> flights = new ArrayList<Flight>();
    flights.add(Mockito.mock(Flight.class));
    flights.add(Mockito.mock(Flight.class));
    Mockito.when(mockedAvailability.getFlight()).thenReturn(flights);

    final FlightAvailabilityResponse dto = adapter.toEntity(mockedAvailability);

    assertNotNull(dto);
    assertNotNull(dto.getAvailability());
    assertEquals(2, dto.getAvailability().size());
  }

  @Test
  public void testFlightAvailabilityNullList() {
    final Availability mockedAvailability = Mockito.mock(Availability.class);
    Mockito.when(mockedAvailability.getFlight()).thenReturn(null);

    final FlightAvailabilityResponse dto = adapter.toEntity(mockedAvailability);

    assertNotNull(dto);
    assertNull(dto.getAvailability());
  }

  @Test
  public void testFlightAvailabilityEmptyList() {
    final Availability mockedAvailability = Mockito.mock(Availability.class);
    Mockito.when(mockedAvailability.getFlight()).thenReturn(new ArrayList<Flight>());

    final FlightAvailabilityResponse dto = adapter.toEntity(mockedAvailability);

    assertNotNull(dto);
    assertNull(dto.getAvailability());
  }

  @Test
  public void testAdaptNull() {
    final FlightAvailabilityResponse dto = adapter.toEntity(null);
    assertNull(dto);
  }

}
