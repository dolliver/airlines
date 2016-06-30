package com.mttnow.adapter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.mttnow.AirlinesApplicationTests;
import com.mttnow.client.model.Availability.Flight;
import com.mttnow.controller.model.response.AvailabilityResponse;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public class AvailabilityResponseAdapterTest extends AirlinesApplicationTests {

  @Autowired
  private AvailabilityResponseAdapter adapter;

  @Test
  public void testAvailabilityResponseAdapterSuccess() {
    final Flight mockedFlight = Mockito.mock(Flight.class);
    final AvailabilityResponse dto = adapter.toEntity(mockedFlight);

    assertNotNull(dto);
    assertNotNull(dto.getFlight());
  }


  @Test
  public void testAdaptNull() {
    final AvailabilityResponse dto = adapter.toEntity(null);
    assertNull(dto);
  }

}
