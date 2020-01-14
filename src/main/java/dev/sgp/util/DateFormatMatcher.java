package dev.sgp.util;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateFormatMatcher {
	private static final Logger LOG = LoggerFactory.getLogger(DateFormatMatcher.class);
	private final static Pattern PATTERN = Pattern.compile("(\\d{4})[\\.\\/\\-](\\d{2})[\\.\\/\\-](\\d{2})");
	
	public static LocalDate parse(String text){
		Matcher m = PATTERN.matcher(text);
		LocalDate date = LocalDate.now();
		try{
			int yy = Integer.parseInt(m.group(1));
			int mm = Integer.parseInt(m.group(2));
			int dd = Integer.parseInt(m.group(3));
		} catch(RuntimeException e){
			LOG.error(e.getMessage(), e);
		}
		return date;
	}
}
