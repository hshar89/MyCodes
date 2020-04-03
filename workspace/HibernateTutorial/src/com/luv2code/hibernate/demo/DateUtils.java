package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Date parseDate(String dateStr){
		
		Date theDate = null;
		try {
			theDate = formatter.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return theDate;
	}
	
	public static String fromatDate(Date theDate) {
		String result = null;
		
		if(theDate!=null) {
			result = formatter.format(theDate);
		}
		return result;
	}
}
