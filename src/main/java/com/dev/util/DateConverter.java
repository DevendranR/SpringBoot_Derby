package com.dev.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	public static String convertDateToString(Date date){  
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		return dateFormat.format(date);
	}
	public static Date convertStringToDate(String date) throws ParseException{  
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		return dateFormat.parse(date);
	}
}
