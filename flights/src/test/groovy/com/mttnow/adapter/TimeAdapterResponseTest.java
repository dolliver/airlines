package com.mttnow.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.mttnow.AirlinesApplicationTests;
import com.mttnow.controller.model.response.TimeResponse;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class TimeAdapterResponseTest extends AirlinesApplicationTests {

  @Autowired
  private TimeResponseAdapter adapter;


  @Test
  public void testTimeResponseSuccessAfterNoon() throws DatatypeConfigurationException {
    XMLGregorianCalendar xmlDate = generateXmlDate("2014-07-07T17:30:00");

    final TimeResponse dto = adapter.toEntity(xmlDate);

    assertEquals("07-07-2014", dto.getDate());
    assertEquals("05:30PM", dto.getTime());
  }

  @Test
  public void testTimeResponseSuccessBeforeNoon() throws DatatypeConfigurationException {
    Instant clocktime = Instant.parse("2014-02-20T05:30:00");
    DateTime time = new DateTime(clocktime);
    XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(time.toGregorianCalendar());

    final TimeResponse dto = adapter.toEntity(xmlDate);

    assertEquals("20-02-2014", dto.getDate());
    assertEquals("05:30AM", dto.getTime());
  }

  @Test
  public void testAdaptNull() {
    final TimeResponse dto = adapter.toEntity(null);
    assertNull(dto);
  }

}
