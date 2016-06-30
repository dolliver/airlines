package com.mttnow;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController

@RequestMapping(path="destination")
class ThisWillActuallyRun {

    @RequestMapping("/home")
    String home() {
        return "Hello World 33!"
    }

}