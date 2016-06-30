package com.mttnow.adapters;

import com.mttnow.controller.model.response.TimeResponse;
import com.mttnow.util.MTTDateTimeUtils;

import org.springframework.stereotype.Component;

import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class TimeResponseAdapter {

  public TimeResponse toEntity(final XMLGregorianCalendar time) {
    if (time == null) {
      return null;
    }

    TimeResponse response =
        new TimeResponse(MTTDateTimeUtils.getDateFromXmlCalendar(time), MTTDateTimeUtils.getTimeFromXmlCalendar(time));
    return response;
  }
}
