/*
 * 
 * 2010-2015 � Copyright Varix Technologies LLC. All Rights Reserved.
 * 
 * All code contained herein is, and remains the property of Varix 
 * Technologies LLC, The intellectual and technical concepts contained
 * herein are proprietary to Varix Technologies LLC and may be covered
 * by U.S. and Foreign Patents, patents in process,  and are protected by
 * trade secret or copyright law.
 *
 * This software is confidential and copyrighted. Title to Software and all 
 * associated intellectual property rights is retained by Varix Technologies
 *  LLC. Unless enforcement  is prohibited by applicable law, you may not
 * modify, decompile, or reverse engineer Software. Under this license 
 * agreement, you are not allowed to copy, sell, resell any
 * part of this software.
 *
 */
 package com.varix.commons.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateUtilities {
	public static final String DATE_FORMAT_yyyy_MM_dd_HH_mm_ss = "MM/dd/yyyy HH:mm:ss";
	public static final String DATE_SITEMAP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss+00:00"; //2014-11-22T07:51:45+00:00
	public static final String DATE_LONG_FORMAT = "yyyy-MM-dd HH:mm:ss"; //2014-11-22 07:51:45
	
	public static final String DATE_FORMAT_yyyy_MM_dd = "yyyy/MM/dd";
	public static final String DATE_FORMAT_DASH_yyyy_MM_dd = "yyyy-MM-dd";
	public static final String DATE_FORMAT_DASH_yyyy_MM_dd_HH_MM_DD = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_MM_dd_yyyy = "MM/dd/yyyy";
	public static final String DATE_FORMAT_dd_MM_yyyy = "dd-MM-yyyy";

	public static Date nowAsDate() {
		return new Date();
	}

	public static String today(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String d = sdf.format(new Date());
		return d;
	}
	
	public static String yesterday(String format) {
		Date d = DateUtils.addDays(new Date(), -1);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}
	
	public static String daysAgo(String format, int daysAgo) {
		if(daysAgo > 0) {
			daysAgo *= -1;
		}
		
		Date d = DateUtils.addDays(new Date(), daysAgo);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}
	
	public static long yesterday() {
		Calendar today = Calendar.getInstance();
		today.add(5, -1);
		return today.getTimeInMillis();
	}

	public static Date yesterdayDate() {
		return DateUtils.addDays(new Date(), -1);
	}

	public static long weekAgo() {
		Calendar today = Calendar.getInstance();
		today.add(5, -7);
		return today.getTimeInMillis();
	}

	public static Date weekAgoAsDate() {
		return DateUtils.addDays(new Date(), -7);
	}

	public static Date twoYearsAgoAsDate() {
		return DateUtils.addDays(new Date(), -730);
	}
	
	public static Date yearAgoAsDate() {
		return DateUtils.addDays(new Date(), -365);
	}
	
	public static Date sixMonthsAgoAsDate() {
		return DateUtils.addDays(new Date(), -183);
	}

	public static Date getDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String d = sdf.format(date);
		return d;
	}
	
	public static Timestamp getCurrentTimestamp() {
		java.util.Date date= new java.util.Date();
		return new Timestamp(date.getTime());
	}
	
	public static long now() {
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		
		return now.getTime();
	}
	
	public static Timestamp nowAsTimestamp() {
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		return currentTimestamp;	}
	
	public static Timestamp oneYearAhead() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 1);
		Date now = calendar.getTime();
		Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		return currentTimestamp;
	}
	
	public static Timestamp adjust(Date d, int adjustmentType, int adjustment) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(adjustmentType, adjustment);
		Date now = calendar.getTime();
		Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp;
	}
	
	public static Timestamp oneYearAgo() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		Date now = calendar.getTime();
		Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		return currentTimestamp;
	}
	
	public static Timestamp sixMonthAhead() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 6);
		Date now = calendar.getTime();
		Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		return currentTimestamp;
	}
	
	public static Timestamp sixMonthAgo() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -6);
		Date now = calendar.getTime();
		Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		return currentTimestamp;
	}
	
	public static Timestamp oneMonthAhead() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date now = calendar.getTime();
		Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		return currentTimestamp;
	}
	
	public static Timestamp oneMonthAgo() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		Date now = calendar.getTime();
		Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		return currentTimestamp;
	}
	
	public static Timestamp oneWeekAhead() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 7);
		Date now = calendar.getTime();
		Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		return currentTimestamp;
	}
	
	public static Timestamp currentTimestamp() {
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		return currentTimestamp;
	}
	
	public static Date addYearsToToday(int amount) {
		return DateUtils.addYears(new Date(), amount);
	}

	public static Date subtractAsDate(int amount) {
		return addYearsToToday(-1 * amount);
	}

	public static Timestamp subtractAsTimestamp(int amount) {
		Date d = addYearsToToday(-1 * amount);
		return new Timestamp(d.getTime());
	}

	public static String formatDate(Date d, String format) {
		if(d == null) {
			return null;
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(d);
	}
	
	public static String formatTimestamp(Date d, String format) {
		if(d == null) {
			return null;
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(d);
	}

	
	public static Date formatDate(String d, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = formatter.parse(d);
		} catch (ParseException localParseException) {
		}
		return date;
	}
	
	public static Timestamp formatTimestamp(String d, String format) {
		Timestamp timestamp = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			Date parsedDate = dateFormat.parse(d);
			timestamp = new java.sql.Timestamp(parsedDate.getTime());
		} catch (Exception e) {
		}
		return timestamp;
		// return Timestamp.valueOf(d);
	}
	
	public static java.sql.Date formatDateTextMonthAsSql(String d, String format) {
		Date date = formatDateTextMonth(d, format);
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		return sqldate;
	}
	
	public static String formatTimestamp(java.sql.Timestamp t, String format) {
		String tmp = StringUtils.EMPTY;
		try {
			tmp = new SimpleDateFormat(format).format(t);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	public static String formatTimestamp(long t, String format) {
		String tmp = StringUtils.EMPTY;
		try {
			java.sql.Timestamp timestamp = new java.sql.Timestamp(t);
			tmp = new SimpleDateFormat(format).format(timestamp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	public static Date formatDateTextMonth(String d, String format) {
		if(StringUtils.isEmpty(d)) {
			return null;
		}
		
		String[] parts = d.split("-");
		if(parts.length != 3) {
			return null;
		}
		
		Date date = null;
		try {
			Date dd = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(parts[1]);
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(dd);
		    int month = cal.get(Calendar.MONTH) + 1;
		    
		    
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			
			String newd = parts[0] + "-" + month + "-" + parts[2];
			date = formatter.parse(newd);
		} catch (ParseException localParseException) { }
		
		return date;
	}
	
	public static java.sql.Date formatSqlDate(String d, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		java.sql.Date sqldate = null;
		try {
			Date date = formatter.parse(d);
			sqldate = new java.sql.Date(date.getTime());
			
		} catch (ParseException localParseException) {
		}
		
		return sqldate;
	}
	
	public static String formatSqlDate(java.sql.Date d, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			return formatter.format(d);
			
			
		} catch (Exception e) {
		}
		
		return StringUtils.EMPTY;
	}
}