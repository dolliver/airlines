package com.mttnow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
    @RequestMapping("/test")
    public String welcome() {
        return flightService.helloWorld();
    }

}
