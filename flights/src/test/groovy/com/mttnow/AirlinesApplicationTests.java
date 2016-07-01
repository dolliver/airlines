package com.mttnow;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@SpringBootApplication
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlightsAvailabilityApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public abstract class AirlinesApplicationTests {

  protected XMLGregorianCalendar generateXmlDate(String date) throws DatatypeConfigurationException {
    Instant clocktime = Instant.parse(date);
    DateTime time = new DateTime(clocktime);
    return DatatypeFactory.newInstance().newXMLGregorianCalendar(time.toGregorianCalendar());
  }

}
