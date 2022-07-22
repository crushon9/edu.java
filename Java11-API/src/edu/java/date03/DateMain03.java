package edu.java.date03;

import java.util.Calendar;

public class DateMain03 {

	public static void main(String[] args) {
		// Calendar : 추상 클래스
		// L GregorianCalendar : Calendar의 자식 클래스
		Calendar cal = Calendar.getInstance(); // 싱글톤으로 인스턴스 생성
		System.out.println(cal);

		// 날짜와 시간 정보 추출
		int year = cal.get(Calendar.YEAR);
		System.out.println("year : " + year);
		int month = cal.get(Calendar.MONTH) + 1; // 1월(0) ~ 12월(11)
		System.out.println("month : " + month);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println("day : " + day);
		int hour = cal.get(Calendar.HOUR_OF_DAY); // HOUR:12시간, HOUR_OF_DAY:24시간
		System.out.println("hour : " + hour);
		int minute = cal.get(Calendar.MINUTE);
		System.out.println("minute : " + minute);
		int second = cal.get(Calendar.SECOND);
		System.out.println("second : " + second);

		String dateString = String.format("%d/%d/%d %d:%d:%d", year, month, day, hour, minute, second);
		System.out.println(dateString);

	}

}
