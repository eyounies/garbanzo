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

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;

public class StringUtilities {
	public static char[] special_characters = { '\\', '/', ',', '.', '<', '>',
			';', ':', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_',
			'+', '=', '?', '|', '[', ']', '`', '~', '"', ' ', '-', '\''};

	public static char[] special_characters_no_spaces = { '\\', '/', ',', '.', '<', '>',
		';', ':', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_',
		'+', '=', '?', '|', '[', ']', '`', '~', '"', '-', '\''};
	
	public static String makeString(final NameValuePair[] arguments,
			final String prefix, final String separator) {
		if (arguments == null || arguments.length <= 0) {
			return StringUtils.EMPTY;
		}

		StringBuilder buffer = new StringBuilder();

		int i = 0;
		buffer.append(prefix);
		for (NameValuePair argument : arguments) {
			buffer.append(argument.getName()).append("=")
					.append(argument.getValue());
			if (i < arguments.length - 1) {
				buffer.append(separator);
			}
			++i;
		}

		//
		return buffer.toString();
	}

	public static String makeSeoString(String text) {
		if (StringUtils.isEmpty(text)) {
			return text;
		}

		text = remove(text, special_characters_no_spaces);
		text = text.replaceAll("\\s+", "-");
		text = text.replaceAll("\\-+", "-");
		return text;
	}

	public static String removeSpecialCharacters(final String text) {
		return remove(text, special_characters);
	}
	
	public static String removeHtmlBreaks(String html) {
		String text = Jsoup.parse(html).text();
		text = StringUtils.remove(text, "\\r\\n");
		text = StringUtils.remove(text, "\\r");
		text = StringUtils.remove(text, "\\n");
		
		return text;
	}
	
	public static String remove(final String text, final char[] tobeRemoved) {
		if (StringUtils.isEmpty(text)) {
			return text;
		}

		char[] orgChars = text.toCharArray();
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			boolean found = false;
			for (int j = 0; j < tobeRemoved.length; j++) {
				if (orgChars[i] == tobeRemoved[j]) {
					found = true;
					break;
				}
			}

			if (found == false) {
				buffer.append(orgChars[i]);
			}
		}

		//
		return buffer.toString();
	}

	public static String remove(final String text, final char tobeRemoved) {
		if (StringUtils.isEmpty(text)) {
			return text;
		}

		char[] orgChars = text.toCharArray();
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			if (orgChars[i] != tobeRemoved) {
				buffer.append(orgChars[i]);
			}
		}

		//
		return buffer.toString();
	}

	public static String format(String text, char separator, int every,
			boolean upperCase) {
		if (StringUtils.isEmpty(text)) {
			return text;
		}

		int flag = 0;
		char[] orgChars = text.toCharArray();
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			if (flag == every) {
				buffer.append(separator);
				flag = 0;
			}

			buffer.append(orgChars[i]);
			++flag;
		}

		//
		return upperCase == true ? buffer.toString().toUpperCase() : buffer
				.toString().toLowerCase();
	}
}
