package com.mttnow;

import com.google.gson.Gson;
import com.mttnow.client.AirlineClientResponseReceiver;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.restlet.RestletComponent;
import org.restlet.Component;
import org.restlet.ext.spring.SpringServerServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Component
public class FlightsAvailabilityRouter extends RouteBuilder {

  public static final String API_MAPPING = "/rest/*";
  public static final String FLIGHT_AVAILABILITY_ENDPOINT = "/flights/availability";
  public static final String AIRLINE_CLIENT_ROUTE = "direct:airlineclient";
  public static final String REST_COMPONENT_RESTLET = "restlet";

  @Value("${client.airline.flight.availability.endpoint}")
  private String airlineClientEndpoint;

  @Autowired
  AirlineClientResponseReceiver airlineResponseProcessor;

  @Override
  public void configure() throws Exception {

    restConfiguration().component(REST_COMPONENT_RESTLET);

    // REST endpoint route exposed by application that returns JSON of flights
    // availabilities
    rest(FLIGHT_AVAILABILITY_ENDPOINT).get("/{origin}/{destination}/{departureDate}/{returnDate}/{passengers}")
        .produces(MediaType.APPLICATION_JSON_VALUE).to(AIRLINE_CLIENT_ROUTE);

    // Route that consumes airline REST webservice that returns their flights in
    // XML
    from(AIRLINE_CLIENT_ROUTE)
        .to("restlet://" + airlineClientEndpoint + "/{origin}/{destination}/{departureDate}/{returnDate}/{passengers}")
        .convertBodyTo(String.class).bean(airlineResponseProcessor).process(new Processor() {
          @Override
          public void process(Exchange exchange) throws Exception {
            Gson gson = new Gson();
            String json = gson.toJson(exchange.getIn().getBody());
            exchange.getOut().setBody(json);
          }
        });
  }

  @Bean
  public ServletRegistrationBean servletRegistrationBean() {

    SpringServerServlet serverServlet = new SpringServerServlet();
    ServletRegistrationBean regBean = new ServletRegistrationBean(serverServlet, API_MAPPING);

    Map<String, String> params = new HashMap<String, String>();
    params.put("org.restlet.component", "restletComponent");
    regBean.setInitParameters(params);

    return regBean;
  }


  @Bean
  public Component restletComponent() {
    return new Component();
  }

  @Bean
  public RestletComponent restletComponentService() {
    return new RestletComponent(restletComponent());
  }

}
