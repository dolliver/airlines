package com.mttnow;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.restlet.RestletComponent;
import org.restlet.Component;
import org.restlet.ext.spring.SpringServerServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@org.springframework.stereotype.Component
public class AirlineCamelRouter extends RouteBuilder {
	
    @Override
    public void configure() throws Exception {

    	restConfiguration().component("restlet");
    	
    	
        rest("/say")
        .get("/hello").to("direct:hello")
        .get("/bye").consumes("application/json").to("direct:bye")
        .post("/bye").to("mock:update");
        
        from("direct:hello")
        .transform().constant("Hello World");
    from("direct:bye")
        .transform().constant("Bye World");
    
    
    	from("direct:example").to("cxfrs://http://www.webservicex.net/stockquote.asmx/GetQuote?symbol=GOOG");
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
