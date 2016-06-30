package com.mttnow;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.restlet.RestletComponent;
import org.restlet.Component;
import org.restlet.ext.spring.SpringServerServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.google.gson.Gson;

@org.springframework.stereotype.Component
public class AirlineCamelRouter extends RouteBuilder {
	
	@Autowired
	AirlineResponseProcessor airlineResponseProcessor;
	
    @Override
    public void configure() throws Exception {

    	restConfiguration().component("restlet");
    	
    	
        rest("/say")
        .get("/hello").produces("application/json").to("direct:airlineclient");

        from("direct:airlineclient").to("restlet://http://private-72732-mockairline.apiary-mock.com/flights/DUB/DEL/20151007/20151020/2")
        .convertBodyTo(String.class)
		.bean(airlineResponseProcessor)		
        .process(new Processor() {
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
    	ServletRegistrationBean regBean = new ServletRegistrationBean( serverServlet, "/rest/*");
    	
    	
    	Map<String,String> params = new HashMap<String,String>();
    	
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
