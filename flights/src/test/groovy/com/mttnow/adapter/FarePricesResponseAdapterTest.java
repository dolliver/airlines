package com.mttnow.adapter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.mttnow.AirlinesApplicationTests;
import com.mttnow.client.model.Availability.Flight.Fares.Fare;
import com.mttnow.controller.model.response.FarePricesResponse;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FarePricesResponseAdapterTest extends AirlinesApplicationTests {

  @Autowired
  private FarePricesResponseAdapter adapter;


  @Test
  public void testFarePriceResponseAdapterBusiness() {
    final Fare mockedFareBusiness = Mockito.mock(Fare.class);
    Mockito.when(mockedFareBusiness.getClazz()).thenReturn("CIF");

    List<Fare> fares = Arrays.asList(mockedFareBusiness);


    final FarePricesResponse dto = adapter.toEntity(fares);

    assertNotNull(dto);
    assertNotNull(dto.getBusiness());
    assertNull(dto.getEconomy());
    assertNull(dto.getFirst());
  }

  @Test
  public void testFarePriceResponseAdapterSuccessEconomy() {
    final Fare mockedFareEconomy = Mockito.mock(Fare.class);
    Mockito.when(mockedFareEconomy.getClazz()).thenReturn("YIF");

    List<Fare> fares = Arrays.asList(mockedFareEconomy);

    final FarePricesResponse dto = adapter.toEntity(fares);

    assertNotNull(dto);
    assertNull(dto.getBusiness());
    assertNotNull(dto.getEconomy());
    assertNull(dto.getFirst());
  }

  @Test
  public void testFarePriceResponseAdapterSuccessFirst() {

    final Fare mockedFareFirst = Mockito.mock(Fare.class);
    Mockito.when(mockedFareFirst.getClazz()).thenReturn("FIF");

    List<Fare> fares = Arrays.asList(mockedFareFirst);

    final FarePricesResponse dto = adapter.toEntity(fares);

    assertNotNull(dto);
    assertNull(dto.getBusiness());
    assertNull(dto.getEconomy());
    assertNotNull(dto.getFirst());
  }

  @Test
  public void testFarePriceResponseAdapterOnlyNoValidValues() {

    final Fare mockedWrongClass = Mockito.mock(Fare.class);
    Mockito.when(mockedWrongClass.getClazz()).thenReturn("ABCDSD");

    final Fare anotherWrongClass = Mockito.mock(Fare.class);
    Mockito.when(anotherWrongClass.getClazz()).thenReturn("123134");

    List<Fare> fares = Arrays.asList(mockedWrongClass, anotherWrongClass);

    final FarePricesResponse dto = adapter.toEntity(fares);

    assertNull(dto);
  }

  @Test
  public void testFarePriceResponseAdapterWrongAndValidValues() {

    final Fare mockedWrongClass = Mockito.mock(Fare.class);
    Mockito.when(mockedWrongClass.getClazz()).thenReturn("ABCDSD");

    final Fare correctFirstClass = Mockito.mock(Fare.class);
    Mockito.when(correctFirstClass.getClazz()).thenReturn("FIF");

    List<Fare> fares = Arrays.asList(mockedWrongClass, correctFirstClass);

    final FarePricesResponse dto = adapter.toEntity(fares);

    assertNotNull(dto);
    assertNull(dto.getBusiness());
    assertNull(dto.getEconomy());
    assertNotNull(dto.getFirst());
  }

  @Test
  public void testFarePriceResponseAdapterNoClassInformed() {

    final Fare noClass = Mockito.mock(Fare.class);
    Mockito.when(noClass.getClazz()).thenReturn(null);

    List<Fare> fares = Arrays.asList(noClass);

    final FarePricesResponse dto = adapter.toEntity(fares);

    assertNull(dto);
  }


  @Test
  public void testFarePriceResponseAdapterSuccessAllFares() {
    final Fare mockedFareBusiness = Mockito.mock(Fare.class);
    Mockito.when(mockedFareBusiness.getClazz()).thenReturn("CIF");

    final Fare mockedFareEconomy = Mockito.mock(Fare.class);
    Mockito.when(mockedFareEconomy.getClazz()).thenReturn("YIF");

    final Fare mockedFareFirst = Mockito.mock(Fare.class);
    Mockito.when(mockedFareFirst.getClazz()).thenReturn("FIF");

    List<Fare> fares = Arrays.asList(mockedFareBusiness, mockedFareEconomy, mockedFareFirst);


    final FarePricesResponse dto = adapter.toEntity(fares);

    assertNotNull(dto);
    assertNotNull(dto.getBusiness());
    assertNotNull(dto.getEconomy());
    assertNotNull(dto.getFirst());
  }

  @Test
  public void testAdaptNull() {
    final FarePricesResponse dto = adapter.toEntity(null);
    assertNull(dto);
  }

  @Test
  public void testAdaptEmptyList() {
    final FarePricesResponse dto = adapter.toEntity(new ArrayList<Fare>());
    assertNull(dto);
  }

}
