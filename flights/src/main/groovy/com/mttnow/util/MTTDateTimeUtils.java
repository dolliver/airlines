package com.mttnow.util;

import org.joda.time.Duration;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.text.SimpleDateFormat;

import javax.xml.datatype.XMLGregorianCalendar;


public class MTTDateTimeUtils {

  public static final String FORMAT_DATE = "dd-MM-yyyy";
  public static final String FORMAT_TIME = "hh:mma";

  public static String getDateFromXmlCalendar(final XMLGregorianCalendar date) {
    return parseXmlCalendarToString(date, FORMAT_DATE);
  }

  public static String getTimeFromXmlCalendar(final XMLGregorianCalendar date) {
    return parseXmlCalendarToString(date, FORMAT_TIME);
  }

  public static String parseXmlCalendarToString(final XMLGregorianCalendar date, final String format) {
    String toReturn = "";
    if (date != null && date.toGregorianCalendar() != null) {
      final SimpleDateFormat sdf = new SimpleDateFormat(format);
      toReturn = sdf.format(date.toGregorianCalendar().getTime());
    }
    return toReturn;
  }

  public static String getStringFromDuration(Duration duration) {
    PeriodFormatter hm =
        new PeriodFormatterBuilder().printZeroAlways().minimumPrintedDigits(2).appendHours().appendSeparator(":")
            .appendMinutes().toFormatter();
    String result = hm.print(duration.toPeriod());
    return result;
  }

}
