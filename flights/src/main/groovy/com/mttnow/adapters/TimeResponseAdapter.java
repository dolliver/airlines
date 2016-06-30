package com.mttnow.adapters;

import com.mttnow.controller.model.response.TimeResponse;
import com.mttnow.util.MTTDateUtils;

import org.springframework.stereotype.Component;

import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class TimeResponseAdapter {

  public TimeResponse toEntity(final XMLGregorianCalendar time) {

    if (time == null) {
      return null;
    }

    TimeResponse response =
        new TimeResponse(MTTDateUtils.getDateFromXmlCalendar(time), MTTDateUtils.getTimeFromXmlCalendar(time));
    return response;
  }
}
