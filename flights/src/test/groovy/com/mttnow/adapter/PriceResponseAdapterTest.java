package com.mttnow.adapter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.mttnow.AirlinesApplicationTests;
import com.mttnow.client.model.Availability.Flight.Fares.Fare;
import com.mttnow.controller.model.response.PriceResponse;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public class PriceResponseAdapterTest extends AirlinesApplicationTests {

  @Autowired
  private PriceResponseAdapter adapter;


  @Test
  public void testPriceResponseAdapterSuccess() {
    final Fare mockedFare = Mockito.mock(Fare.class);
    Mockito.when(mockedFare.getBasePrice()).thenReturn("EUR 101");
    Mockito.when(mockedFare.getFees()).thenReturn("EUR 202");
    Mockito.when(mockedFare.getTax()).thenReturn("EUR 303");


    final PriceResponse dto = adapter.toEntity(mockedFare);

    assertNotNull(dto);
    assertNotNull(dto.getBookingFee());
    assertNotNull(dto.getTax());
    assertNotNull(dto.getTicket());
  }

  @Test
  public void testPriceResponseAdapterInvalidBookingFee() {
    final Fare mockedFare = Mockito.mock(Fare.class);
    Mockito.when(mockedFare.getBasePrice()).thenReturn("EUR 101");
    Mockito.when(mockedFare.getFees()).thenReturn("abcde");
    Mockito.when(mockedFare.getTax()).thenReturn("EUR 303");


    final PriceResponse dto = adapter.toEntity(mockedFare);

    assertNotNull(dto);
    assertNull(dto.getBookingFee());
    assertNotNull(dto.getTax());
    assertNotNull(dto.getTicket());
  }

  @Test
  public void testPriceResponseAdapterInvalidBasePrice() {
    final Fare mockedFare = Mockito.mock(Fare.class);
    Mockito.when(mockedFare.getBasePrice()).thenReturn("53453535");
    Mockito.when(mockedFare.getFees()).thenReturn("EUR 202");
    Mockito.when(mockedFare.getTax()).thenReturn("EUR 303");


    final PriceResponse dto = adapter.toEntity(mockedFare);

    assertNotNull(dto);
    assertNotNull(dto.getBookingFee());
    assertNotNull(dto.getTax());
    assertNull(dto.getTicket());
  }

  @Test
  public void testPriceResponseAdapterInvalidTax() {
    final Fare mockedFare = Mockito.mock(Fare.class);
    Mockito.when(mockedFare.getBasePrice()).thenReturn("EUR 101");
    Mockito.when(mockedFare.getFees()).thenReturn("EUR 202");
    Mockito.when(mockedFare.getTax()).thenReturn(" 303");


    final PriceResponse dto = adapter.toEntity(mockedFare);

    assertNotNull(dto);
    assertNotNull(dto.getBookingFee());
    assertNull(dto.getTax());
    assertNotNull(dto.getTicket());
  }


  @Test
  public void testAdaptNull() {
    final PriceResponse dto = adapter.toEntity(null);
    assertNull(dto);
  }

}
