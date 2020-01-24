package com.example.demo.time;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDK8_DateFormat {
	public static void main(String[] args) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String format = LocalDate.now().format(formatter);
		System.out.println(format);
		
		LocalDateTime localDateTimeNow = LocalDateTime.now();
		System.out.println(localDateTimeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
		System.out.println(localDateTimeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS")));
		System.out.println(localDateTimeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
		System.out.println(localDateTimeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSS")));
		
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
		System.out.println(formatter1.format(formatter1.parse("20190429")));
		
		String result = formatDate("20190429", "yyyyMMdd");
		String result1 = formatDate("2019-04-29 17:29:10.0", "yyyyMMdd");
		System.out.println(result);
		System.out.println(result1);
		
	}
	
	public static String formatDate(String dateStr,String pattern){
        if(dateStr.isEmpty()) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
        	Date date = sdf.parse(dateStr);
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
	
}
