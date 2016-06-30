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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class CollectionsUtilities {

	public static Set<?> convert(List<?> list) {
		Set<Object> set = new HashSet<Object>();
		if (list == null) {
			return null;
		}

		if (list.size() <= 0) {
			return set;
		}

		set.addAll(list);

		//
		return set;
	}

	public static List<Object> convert(Set<Object> set) {
		List<Object> list = new ArrayList<Object>();
		if (set == null) {
			return null;
		}

		if (set.size() <= 0) {
			return list;
		}

		set.addAll(set);

		//
		return list;
	}

	public static String convertList2String(final List<?> list,
			final String separator) {
		if (list == null) {
			return StringUtils.EMPTY;
		}

		int i = 0;
		StringBuilder buffer = new StringBuilder();
		for (Object o : list) {
			buffer.append(o);
			if (i < list.size() - 1 && StringUtils.isNotEmpty(separator)) {
				buffer.append(separator);
			}
			++i;
		}

		return buffer.toString();
	}
}
