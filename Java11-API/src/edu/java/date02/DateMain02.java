package edu.java.date02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMain02 {

	public static void main(String[] args) {
		// 날짜를 원하는 형식(format)으로 출력
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// MM:월 mm:분 HH:24시간표기 hh:12시간표기
		String dateString = sdf.format(currentDate);
		System.out.println(dateString);
		
		sdf = new SimpleDateFormat("yy-MM-dd");
		dateString = sdf.format(currentDate);
		System.out.println(dateString);
		
	}
}
