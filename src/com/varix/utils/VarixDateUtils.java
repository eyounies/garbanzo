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
 */
 package com.varix.commons.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class VarixDateUtils {
	public static long now() {
		Calendar today = Calendar.getInstance();
		return today.getTimeInMillis();
	}

	public static Date nowAsDate() {
		return new Date();
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

}
