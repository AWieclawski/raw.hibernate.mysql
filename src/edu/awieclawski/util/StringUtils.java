package edu.awieclawski.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StringUtils {
	private final static Logger LOGGER = Logger.getLogger(StringUtils.class.getName());

	public static Boolean notNullNorEmpty(String text) {
		Boolean result = false;
		if (text != null && !text.isEmpty() && !text.toLowerCase().equals("null"))
			result = true;
		return result;
	}

	public static String integerToString(Integer number) {
		String foo;
		try {
			foo = String.valueOf(number);
		} catch (NullPointerException e) {
			foo = "";
		}
		return foo;
	}

	public static Integer stringToIntegerOrZero(String value) {
		Integer number;
		try {
			number = Integer.parseInt(value.trim());
		} catch (NumberFormatException e) {
			number = 0;
		}
		return number;
	}

	public static String cleanStringOrEmpty(String text) {
		try {
			return text.replace("-", "").replace("—", "").replace("−", "") // remove dashes: -,—,−
					.replaceAll("\\s+", ""); // remove whitespaces
		} catch (NullPointerException e) {
			LOGGER.log(Level.SEVERE, text, e);
			return "";
		}
	}

	public static Long stringToLongOrZero(String value) {
		Long number;
		try {
			number = Long.parseLong(value.trim());
		} catch (NumberFormatException e) {
			LOGGER.log(Level.SEVERE, value, e);
			number = 0L;
		}
		return number;
	}

	public static String wrapByApostrophes(String text) {
		text = "'" + text + "'";
		return text;
	}

	public String firstLetterToLowerCase(String input) {
		if (notNullNorEmpty(input))
			return input.substring(0, 1).toLowerCase() + input.substring(1);
		return null;
	}

}
