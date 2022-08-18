package scheduler;

import java.util.Calendar;
import java.util.GregorianCalendar;

class CalendarSet {
	static final int CAL_COLUMN = 7; // 요일 7개
	static final int CAL_MAX_ROW = 6; // 월의 최대행갯수
	static int[][] calDates = new int[CAL_MAX_ROW][CAL_COLUMN];
	static int calYear;
	static int calMonth;
	static int calDate; // 현재월의날짜
	static final int calEndDateArray[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 월별기본마지막날짜
	static int calEndDate; // 윤달을 계산한 실제 마지막 날짜
	static Calendar today = Calendar.getInstance();

	public CalendarSet() {
	}

	// 오늘의 년도, 월, 날짜를 추출하여 캘린더생성메소드로 넘겨주며 호출
	public static void setToday() {
		calYear = today.get(Calendar.YEAR);
		calMonth = today.get(Calendar.MONTH);
		calDate = today.get(Calendar.DATE);
		makeCalData(today);
	} // end setToday()

	public static void moveMonth(int mon) {
		calMonth += mon;
		if (calMonth > 11)
			while (calMonth > 11) {
				calYear++;
				calMonth -= 12;
			}
		else if (calMonth < 0)
			while (calMonth < 0) {
				calYear--;
				calMonth += 12;
			}
		Calendar cal = new GregorianCalendar(calYear, calMonth, calDate);
		makeCalData(cal);
	} // end moveMonth()

	// 윤달 체크 계산식 (4로 나누어지고, 100으로 나누어지지 않거나 / 400으로 나누어지면)
	private static int leapCheck(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return 1;
		else
			return 0;
	} // end leapCheck()

	// 동적 달력 생성
	private static void makeCalData(Calendar cal) {
		// 월의 시작지점 계산
		int StartDayOfMonth = (cal.get(Calendar.DAY_OF_WEEK) - (cal.get(Calendar.DATE) % 7) + 7) % 7;
		if (calMonth == 1) // 인덱스1 = 2월 윤달체크
			calEndDate = calEndDateArray[calMonth] + leapCheck(calYear);
		else
			calEndDate = calEndDateArray[calMonth];

		for (int row = 0; row < CAL_MAX_ROW; row++) {
			for (int col = 0; col < CAL_COLUMN; col++) {
				calDates[row][col] = 0; // 0으로 초기화
			}
		}

		for (int row = 0, date = 1, start = 0; row < CAL_MAX_ROW; row++) {
			if (row == 0) // 첫번째줄일때는
				start = StartDayOfMonth; // 시작위치를 월시작위치로 설정
			else // 아니라면
				start = 0; // 0번째 시작위치로
			for (int col = start; col < CAL_COLUMN; col++) {
				if (date <= calEndDate)
					calDates[row][col] = date++;
			}
		}
	} // makeCalData()

} // end CalendarSet class
