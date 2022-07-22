package edu.java.access09;

public class TestStatic {

	int inNum; // 인스턴스 멤버 변수
	static int stNum; // 클래스(static) 멤버 변수

	// 인스턴스 메소드
	public void display1() {
		System.out.println("inNum = " + inNum);
		System.out.println("stNum = " + stNum);
		
//		AccessMain09 a = new AccessMain09();
//		a.main(null);
	}

	// 클래스(static) 메소드
	public static void display2() {
//		System.out.println("inNum = " + inNum); / - error
		// static 메소드는 인스턴스 생성없이 사용가능
		// inNum은 인스턴스 멤버션수이므로 인스턴스 생성 후에 사용가능
		// static 메소드에서는 inNum은 사용불가
		
		System.out.println("stNum = " + stNum);
		
	}
}
