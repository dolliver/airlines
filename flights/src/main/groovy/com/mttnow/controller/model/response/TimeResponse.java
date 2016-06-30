package com.mttnow.controller.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeResponse {
  public final String date;
  public final String time;

  @JsonCreator
  public TimeResponse(@JsonProperty("date") String date, @JsonProperty("time") String time) {
    this.date = date;
    this.time = time;
  }
}
