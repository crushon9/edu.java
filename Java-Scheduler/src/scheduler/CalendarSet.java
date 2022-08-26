package scheduler;

import java.util.Calendar;
import java.util.GregorianCalendar;

class CalendarSet { // 날짜의 수학적 값을 담은 클래스, 계산은 여기서 이루어지고, static멤버변수를 가지기때문에 다른 클래스에서 접근하여 출력함
	static final int CAL_COLUMN = 7; // 요일 7개
	static final int CAL_MAX_ROW = 6; // 월의 최대행갯수
	static int[][] calDates = new int[CAL_MAX_ROW][CAL_COLUMN]; // Date를 배열에 담는 이유는 좌표를 통해 값을식별하기 위해서, 2차원배열로 만든이유는
																// 일,토요일마다 다른 효과를 줘야하기 때문에
	static int calYear;
	static int calMonth;
	static int calDate;
	static final int calEndDateArray[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 월별기본마지막날짜(윤달계산X)
	static int calEndDate; // 윤달을 계산한 실제 마지막 날짜
	static Calendar today = Calendar.getInstance(); // 인스턴스 생성시 자동으로 현재의 날짜정보가 들어감

	public CalendarSet() {
	}

	// 날짜 int에 today 인스턴스의 값을 넣음
	public static void setToday() {
		calYear = today.get(Calendar.YEAR);
		calMonth = today.get(Calendar.MONTH); // 월은 0부터 시작됨(계산은 이값으로 하되 출력시 1더해서 출력)
		calDate = today.get(Calendar.DATE);
		makeCalData(today);
	} // end setToday()

	// 월, 년을 변경할때 값을 변경하여 재할당
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
		// today인스턴스는 두고, 새롭게 인스턴스 생성하여 값 변동
		Calendar cal = new GregorianCalendar(calYear, calMonth, calDate);
		makeCalData(cal);
	} // end moveMonth()

	// 일 값 계산
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

	// 윤달 체크 계산식 (4로 나누어지고, 100으로 나누어지지 않거나 / 400으로 나누어지면)
	private static int leapCheck(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return 1;
		else
			return 0;
	} // end leapCheck()

} // end CalendarSet class
