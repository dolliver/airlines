package com.mttnow;

import java.io.StringReader;

import javax.xml.bind.JAXB;

public class XMLProcessor {

  public static Availability process(String xml) {
	  
	  Availability avail = JAXB.unmarshal(new StringReader(xml), Availability.class);
	  return avail;
	  
	  
  }

}
