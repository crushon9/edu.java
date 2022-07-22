package edu.java.class01;

public class ClassMain01 {
// Alt + Shift + R : 클래스 이름변경

	// 프로그램의 시작점 : main() 메소드
	public static void main(String[] args) {
		// 변수 타입으로 선언할 수 있는 형태
		// - 기본타입 변수 : boolean, char, int 등. 실제 값(리터럴)을 변수 안에 저장
		// 예) int a = 3, b = 10;
		// - 참조타입 변수 : 배열, 클래스, 인터페이스 등 주소를 통해 객체 참조
		// 예) int[] a = new int[3]; / BasicTv tv = new BasicTv();

		// 클래스의 "객체(인스턴스)"를 "생성"한다
		// 클래스이름 변수이름 = new 생성자();
		BasicTv tv = new BasicTv();
		BasicTv tv1 = new BasicTv();
		// new heap메모리를 할당하여 BasicTv의 새로운 인스턴스를 복제하여 그 참조값을 tv에 넘겨줌 (객체화) 
		tv.displayInfo(); // 현재 상태 출력
		tv1.displayInfo(); // 현재 상태 출력
		
//		기존 생성자를 호출하여 객체를 생성하게 되면 클래스의 멤버 변수들은 기본값으로 초기화됨
//		숫자(int, double)타입의 기본값 : 0, 0.0
//		boolean 타입의 기본값 : false
//		그 외 타입(참조 타입) : null

		tv.turnOnOff(); // power 버튼 출력
		tv.displayInfo();
		tv1.displayInfo(); // tv1은 값이 변하지 않음
		tv.turnOnOff(); // power 버튼 출력
		tv.displayInfo();

//		BasicTv tv2 = null;
//		tv2.displayInfo();
		// NullPointerException : 참조변수가 null 값을 가진 경우 객체의 멤버변수나 메소드를 사용하면 발생하는 프로그램 오류

		tv.channelDown();
		tv.channelUp();
		tv.volumeUp();
		tv.volumeDown();

	} // end main()

} // end ClassMain01
