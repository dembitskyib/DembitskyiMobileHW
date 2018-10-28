package com.epam.lab.mobile.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static boolean compareDate(String date) {
		DateFormat format = new SimpleDateFormat("HH:mm");
		String systemDate = format.format(new Date());
		return systemDate.equals(date);
	}
}
