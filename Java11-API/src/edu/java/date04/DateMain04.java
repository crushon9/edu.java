package edu.java.date04;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateMain04 {

	public static void main(String[] args) {
		Calendar cal = new GregorianCalendar(2022, 7, 21); // 다형성

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		String dateString = String.format("%d-%02d-%02d", year, month, day);
		// %02d 앞에 0을 채우면서 2자리로 표현
		System.out.println(dateString);

		System.out.println();
		// Calendar를 SimpleDateFormat으로 표현
		Calendar birth = new GregorianCalendar(1999, 0, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// sdf.format(date);의 매개변수는 Date타입이와야 하므로 Calendar to Date 과정이 필요함  
		Date date = birth.getTime();
		String str = sdf.format(date);
		System.out.println(str);
	}

}
