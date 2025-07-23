package com.makemytripautomation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Demo {
	
	
	
	public static void main(String[] args) {
		
		LocalDate date = LocalDate.now();
		date=date.plusDays(5);
		System.out.println(date);
		
		int dayOfMonth = date.getDayOfMonth();
		System.out.println(dayOfMonth);
		
		String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		System.out.println(month);
		
		int year = date.getYear();
		System.out.println(year);		
		
	
		
	}

}
