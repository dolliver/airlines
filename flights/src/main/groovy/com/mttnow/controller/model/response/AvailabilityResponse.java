package com.mttnow.controller.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AvailabilityResponse {
    public final FlightResponse flight;

    @JsonCreator
    public AvailabilityResponse(@JsonProperty("flight") FlightResponse flight){
        this.flight = flight;
    }

}