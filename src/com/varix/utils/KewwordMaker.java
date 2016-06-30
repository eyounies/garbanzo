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


import java.util.Random;

import org.apache.commons.lang.StringUtils;

import com.varix.commons.configuration.ApplicationConfigurations;
import com.varix.commons.configuration.ConfigConstants;

public class KewwordMaker {
	public static String[] default_ignored_words = { "and", "off", "of", "in", "on", "at",
			"out", "inch", "new", "for", "each", "other", "only", "and", "the",
			"free", "with", "all", "many", "few", "true", "false", "good",
			"bad", "ugly", "to", "do", "does", "did", "otherwise", "what",
			"when", "where", "how", "else", "then", "if", "GB", "GHz", "about",
			"ship", "shipping", "detail", "details", "oz", "brand", "box",
			"or", "is", "were", "was", "has", "have", "had", "small", "large",
			"cu", "ft" };

	public static String[] hot_deals_words = {"daily deal savers", "super deal", "great deal", "deal news", "one day sale", "dailydeal", "hot deals", "daily deals", "daily deals sites", "daily deals site", "Today's Deal", "Today's Deals", "Deal of the day", "Deals of the Day", "deals2buy", "fatwallet", "Bargains in a Box", "deal", "discount", "bargain", "bargains", "bargains n more", "bargain hunt", "hotdeal", "hot deal", "smartdeal", "smart deal", "slickdeal", "slick deal", "steal deal", "daily deals online", "daily deal"};
	public static String[] hot_coupons_words = {"promo code", "promo codes", "manufacturer coupons", "one day sale", "free coupons", "grocery coupons", "overstock coupon", "voucher codes", "Today's Coupons", "Today's Coupon", "coupons2buy", "deals2buy", "fatwallet", "Bargains in a Box", "Coupon of the Day", "coupon", "discount", "bargain", "bargains", "bargains n more", "bargain hunt", "hotcoupon", "hot coupon", "smartcoupon", "smart coupon", "slickdeal", "slick coupon", "steal coupon", "daily coupons online", "daily coupon"};
	
	public static String getRandomWords(String[] hotWords) {
		if(hotWords == null || hotWords.length <= 0) {
			return StringUtils.EMPTY;
		}
		
		Random random = new Random();
		StringBuilder buffer = new StringBuilder();

		try {
			buffer.append(hotWords[random.nextInt(hotWords.length)]).append(", ");
			buffer.append(hotWords[random.nextInt(hotWords.length)]).append(", ");
			buffer.append(hotWords[random.nextInt(hotWords.length)]).append(", ");
			buffer.append(hotWords[random.nextInt(hotWords.length)]).append(", ");
			buffer.append(hotWords[random.nextInt(hotWords.length)]).append(", ");
			buffer.append(hotWords[random.nextInt(hotWords.length)]).append(", ");
			buffer.append(hotWords[random.nextInt(hotWords.length)]).append(", ");
		} catch(Exception e) {
			System.out.println("Error occured during randomizing keywords...");
		}
		
		return buffer.toString();
	}
	
	public static String getRandomHotCouponWords() {
		return getRandomWords(hot_coupons_words);
	}

	public static String getRandomHotDealWords() {
		return getRandomWords(hot_deals_words);
	}
	
	public static String make(String text, String type) {
		String hotWords = StringUtils.EMPTY;
		if(type.equalsIgnoreCase("deal")) {
			hotWords = getRandomHotDealWords();
		} else {
			hotWords = getRandomHotCouponWords();
		}
		
		return hotWords + make(text);
	}

	public static String make(String text) {
		if (StringUtils.isEmpty(text)) {
			return text;
		}

		text = StringUtilities.remove(text.trim(), StringUtilities.special_characters_no_spaces);
		String[] tokens = StringUtils.split(text, " ");
		StringBuilder buffer = new StringBuilder();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].length() <= 1 || isIgnoredWord(tokens[i])
					|| isNumber(tokens[i])) {
				continue;
			}

			buffer.append(tokens[i].toLowerCase());
			if (i < (tokens.length - 1)) {
				buffer.append(", ");
			}
		}

		return buffer.toString();
	}

	private static boolean isNumber(String string) {
		return string.matches("-?\\d+(\\.\\d+)?");
	}

	public static boolean isIgnoredWord(String word) {
		boolean ignore = false;
		String[] igwords = getIgnoredWords();
		for (int i = 0; i < igwords.length; i++) {
			if (word.equalsIgnoreCase(igwords[i])) {
				ignore = true;
				break;
			}
		}

		return ignore;
	}
	
	public static String[] getIgnoredWords() {
		String list = ApplicationConfigurations.getInstance().getPropertyValue(ConfigConstants.LIST_IGNORE_KEYWORDS);
		if(StringUtils.isEmpty(list)) {
			return default_ignored_words;
		}
		
		String[] words = StringUtils.split(list, '|');
		if(words == null || words.length <= 0) {
			return default_ignored_words;
		}
		
		return words;
	}
}
