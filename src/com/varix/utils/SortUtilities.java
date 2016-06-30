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

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.varix.commons.configuration.providers.ConfigurationProvidersAggregator;

public class SortUtilities {
	Log log = LogFactory.getLog(ConfigurationProvidersAggregator.class);

	public List<Object> sortList(List<Object> list) {
		if (list == null || list.size() <= 0) {
			return list;
		}

		if (log.isDebugEnabled()) {
			log.debug("There are [" + list.size() + "] providers");
		}

		int n = list.size();
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - 1); j++) {
				/*
				 * log.debug(list.get(j)); log.debug(list.get(j-1)); if
				 * (list.get(j - 1).compareTo(list.get(j)) < 0) { t = list.get(j
				 * - 1); list.set((j - 1), list.get(j)); list.set(j, t); }
				 */
			}
		}

		if (log.isDebugEnabled()) {
			for (Object o : list) {
				log.debug(o);
			}
		}

		//
		return list;
	}
}