package com.mttnow.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.mttnow.AirlinesApplicationTests;
import com.mttnow.controller.model.response.MoneyAmountResponse;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.datatype.DatatypeConfigurationException;

public class MoneyAmountAdapterTest extends AirlinesApplicationTests {

  @Autowired
  private MoneyAmountAdapter adapter;


  @Test
  public void testMoneyAmountSuccessWithoutDecimals() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("EUR 91");

    assertEquals(91, dto.getAmount(), 0);
    assertEquals("EUR", dto.getCurrency());
  }

  @Test
  public void testMoneyAmountSuccessWithDecimals() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("BRL 100.58");

    assertEquals(100.58, dto.getAmount(), 0);
    assertEquals("BRL", dto.getCurrency());
  }

  @Test
  public void testMoneyAmountCentsOnly() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("USD 0.66");

    assertEquals(0.66, dto.getAmount(), 0);
    assertEquals("USD", dto.getCurrency());
  }

  @Test
  public void testMoneyAmountCentsOnlyWithoutZero() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("USD .66");

    assertEquals(0.66, dto.getAmount(), 0);
    assertEquals("USD", dto.getCurrency());
  }

  @Test
  public void testMoneyAmountDecimalWithMoreDigits() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("USD 100.6758695");

    assertEquals(100.6758695, dto.getAmount(), 0);
    assertEquals("USD", dto.getCurrency());
  }

  @Test
  public void testMoneyAmountWithoutCurrency() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("85.00");
    assertNull(dto);
  }

  @Test
  public void testMoneyAmountDifferenceDecimalSeparator() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("85,00");
    assertNull(dto);
  }

  @Test
  public void testMoneyAmountWithoutAmount() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("USD");
    assertNull(dto);
  }

  @Test
  public void testMoneyAmountWithoutCurrencyAndSpace() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("85.00 ");
    assertNull(dto);
  }

  @Test
  public void testMoneyAmountWithoutAmountAndSpace() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("USD ");
    assertNull(dto);
  }

  @Test
  public void testMoneyAmountSpaceWithValidNumber() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity(" 4329424");
    assertNull(dto);
  }


  @Test
  public void testMoneyAmountInvalidAmount() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("USD abcd");
    assertNull(dto);
  }

  @Test
  public void testMoneyAmountnlySpace() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity(" ");
    assertNull(dto);
  }

  @Test
  public void testMoneyAmountInvalidValue() throws DatatypeConfigurationException {
    final MoneyAmountResponse dto = adapter.toEntity("54353535");
    assertNull(dto);
  }

  @Test
  public void testAdaptNull() {
    final MoneyAmountResponse dto = adapter.toEntity(null);
    assertNull(dto);
  }

  @Test
  public void testAdaptEmptyString() {
    final MoneyAmountResponse dto = adapter.toEntity("");
    assertNull(dto);
  }

}
