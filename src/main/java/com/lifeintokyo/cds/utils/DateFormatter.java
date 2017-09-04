package com.lifeintokyo.cds.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class DateFormatter {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static String format(Date date) {
		return DATE_FORMAT.format(date);
	}
	public static String format(LocalDate date) {
		return format(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}
	public static Date parse(String date) {
		try {
			return DATE_FORMAT.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	private static final Locale LOCALE_JA = new Locale("ja", "JP", "JP");

    public static String dateToJapaneseCalendar(Date date, String format) {
        DateFormat japaseseFormat = new SimpleDateFormat(format, LOCALE_JA);
        return japaseseFormat.format(date);
    }
    public static String dateToJapaneseCalendar(LocalDate date, String format) {
        return dateToJapaneseCalendar(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()), format);
    }
    public static Date japaneseCalendarToDate(String jpDateStr, String format) throws ParseException {
        DateFormat japaseseFormat = new SimpleDateFormat(format, LOCALE_JA);
        return japaseseFormat.parse(jpDateStr);
    }
    
    // こんな実装になる設計書出された
    public static String warekiToSeireki(String gengoKbn, String wareki) {
        int warekiYear = Integer.parseInt(wareki.substring(0,2));
        String warekiMD = wareki.substring(2,6);
        switch (gengoKbn){
            case "M":
                warekiYear = warekiYear + 1867;
                break;
            case "T":
                warekiYear = warekiYear + 1911;
                break;
            case "S":
                warekiYear = warekiYear + 1925;
                break;
            case "H":
                warekiYear = warekiYear + 1988;
                break;
            default:
                throw new IllegalArgumentException("argument is wrong");
        }
        return String.valueOf(warekiYear) + warekiMD;
    }

    public static Map<String,String> populateBuzdateseldates(String buzdate) {
    	return populateBuzdateseldates(parse(buzdate));
    }
    public static Map<String,String> populateBuzdateseldates(Date buzdate) {
		Map<String,String> buzdateseldates = new LinkedHashMap<>();
		for (int i = -5; i < 10; i++) {
			LocalDate dateTime = LocalDate.from(buzdate.toInstant().atZone(ZoneId.systemDefault())).plusMonths(i);
			buzdateseldates.put(format(dateTime), dateToJapaneseCalendar(dateTime, "GGGGy年MM月"));
		}
		return buzdateseldates;
    }
}
