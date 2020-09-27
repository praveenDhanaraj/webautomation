package com.flipkart.webautomation.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtilities {

	public static int getIntegerFromString(String text) {
		return Integer.parseInt(text.replaceAll("[^0-9]", ""));
	}
	
	public static List<String> getList(String input,String seperator){
		return Arrays.asList(input.split(seperator));
	}
}
