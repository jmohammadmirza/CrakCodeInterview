package com.something.anyting;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortDate {

	public static void main(String[] args) throws ParseException {

		//Starters
		LocalDate now = LocalDate.now();

		System.out.println("Time Now Default Format: YYYY-MM-DD :"+now.getDayOfMonth());

		LocalDateTime beginningOfDay = LocalDate.parse("2018-01-09").atStartOfDay();

		System.out.println("Time Now 2018-01-09 :"+beginningOfDay);

		//Sort String Date Array
		String dates[] =  { "05-11-2014" , "23-08-2014" , "05-02-2013" };

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		List<LocalDate> list = new ArrayList<LocalDate>();

		for ( String string : dates)  {

			LocalDate localDate = LocalDate.parse(string,formatter);

			list.add( localDate );
		}

		Collections.sort( list );

		System.out.println("list: "+list);


		LocalDate[] dateArray=new LocalDate[dates.length];

		for (int index = 0; index < dates.length; index++) {

			LocalDate localDate = LocalDate.parse(dates[index],formatter);

			dateArray[index]=localDate;
		}

		Arrays.sort(dateArray);

		System.out.println("Arrays Date: "+Arrays.toString(dateArray));
		
		//Print in the specific format
		for ( LocalDate localDate : list ) {
		   System.out.println( localDate.format(formatter));
		}
		
	}

}
