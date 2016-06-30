package com.mttnow.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.mttnow.AirlinesApplicationTests;
import com.mttnow.controller.model.response.FlightAvailabilityResponse;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Scanner;

public class AirlineClientResponseReceiverTest extends AirlinesApplicationTests {

  @Autowired
  private AirlineClientResponseReceiver receiver;


  @Test
  public void testResponseReceiving() throws IOException {

    String xml = loadResourceAsString("airlineResponse.xml");
    final Exchange exchangeMock = Mockito.mock(Exchange.class);
    Message in = new DefaultMessage();
    Message out = new DefaultMessage();

    in.setBody(xml);

    Mockito.when(exchangeMock.getIn()).thenReturn(in);
    Mockito.when(exchangeMock.getOut()).thenReturn(out);

    receiver.receive(exchangeMock);


    assertNotNull(exchangeMock.getOut().getBody());
    assertTrue(exchangeMock.getOut().getBody() instanceof FlightAvailabilityResponse);

  }

  public String loadResourceAsString(String fileName) throws IOException {
    Scanner scanner = new Scanner(getClass().getClassLoader().getResourceAsStream(fileName));
    String contents = scanner.useDelimiter("\\A").next();
    scanner.close();
    return contents;
  }

}
