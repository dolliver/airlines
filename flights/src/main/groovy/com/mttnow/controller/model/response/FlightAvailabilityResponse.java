package com.mttnow.controller.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class FlightAvailabilityResponse {
    public final List<AvailabilityResponse> availability;

    @JsonCreator
    public FlightAvailabilityResponse(@JsonProperty("availability") List<AvailabilityResponse> availability){
        this.availability = availability;
    }
        
}