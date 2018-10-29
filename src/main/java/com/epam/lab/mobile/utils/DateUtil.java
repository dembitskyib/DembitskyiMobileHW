package com.epam.lab.mobile.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getCurrentDate(String formatPattern) {
		DateFormat format = new SimpleDateFormat(formatPattern);
		return format.format(new Date());
	}

}
