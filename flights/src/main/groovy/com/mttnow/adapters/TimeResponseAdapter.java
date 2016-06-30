package com.mttnow.adapters;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import com.mttnow.MTTDateUtils;
import com.mttnow.controller.model.response.TimeResponse;

@Component
public class TimeResponseAdapter {
	
	public TimeResponse toEntity(final XMLGregorianCalendar time) {
		
		if(time == null) {
			return null;
		}
		
		TimeResponse response = new TimeResponse(MTTDateUtils.getDateFromXmlCalendar(time), MTTDateUtils.getTimeFromXmlCalendar(time));
		return response;
	}
}
