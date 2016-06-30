/*
 * 
 * 2010-2015 © Copyright Varix Technologies LLC. All Rights Reserved.
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
 */package com.varix.commons.utils;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class TimestampMaker {
	public static String END_OF_TODAY = "end_of_today";
	
	
	/*
	 * this function parses expressions like
	 * 1|day|now or 0|day|end
	 * the first segment is digit(s); valid valued are numeric 0-n
	 * the second segment is a qualifier, valid values are hour or day. For now day is supported.
	 * the third segment is a time pointer. Valid values are now, and/or end
	 */
	public static java.sql.Timestamp make(String expression) {
		if(StringUtils.isEmpty(expression)) {
			return null;
		}
		
		if(END_OF_TODAY.equalsIgnoreCase(expression)) {
			return makeEndOfToday();
		}
		
		/*
		String[] parts = StringUtils.split(expression, '|');
		if(parts == null || parts.length < 3) {
			return null;
		}
		
		int count = 0;
		String qualifier = StringUtils.EMPTY;
		String timePointer = StringUtils.EMPTY;
		
		try {
			count = Integer.parseInt(parts[0]);
		} catch(Exception e) { }
		
		if (StringUtils.isNotEmpty(parts[1])
				&& (parts[1].equalsIgnoreCase("hour") || parts[1]
						.equalsIgnoreCase("day"))) {
			qualifier = parts[1].toLowerCase();
		}
		*/
		return null;
	}


	public static Timestamp makeEndOfToday() {
		String beginingOfTheDay = DateUtilities.getDate(new Date());
		Date d1 = DateUtilities.getDate(beginingOfTheDay);
		long l1 = d1.getTime();
		long t2 = l1 + (24 * 60 * 60 * 1000) - 1;
		
		Timestamp t = new Timestamp(t2);
		return t;
	}
}
