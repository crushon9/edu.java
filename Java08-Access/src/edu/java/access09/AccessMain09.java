package edu.java.access09;

// * static : 멤버변수 또는 메소드를 선언(정의)할 때 사용
// - 인스턴스 생성 이전에 프로그램이 처음 시작될 때 static 메모리 영역에 자동으로 생성

// * 클래스 변수,메소드(static 변수,메소드) : static으로 선언한 멤버변수,메소드
// - 인스턴스를 생성하지 않아도 사용 가능 /static->static(가능), static->인스턴스(가능)
// - 변수사용형식 : 클래스이름.변수이름
// - 메소드사용형식 : 클래스이름.메소드()
// - static 변수는 생성되는 모든 인스턴스들이 공유하기 때문에 값의 변경에 대해서 주의해야 함!

// * 인스턴스 변수,메소드 : static이 선언되지 않은 멤버변수,메소드
// - 인스턴스를 생성한 후에만 사용가능 /인스턴스->인스턴스(가능), 인스턴스->static(불가능)
// - 변수사용형식 : 참조변수.변수이름
// - 메소드사용형식 : 참조변수.메소드()

public class AccessMain09 {

	public static void main(String[] args) {
		// static 멤버변수와 메소드 - 인스턴스 생성 없이 사용 가능
		System.out.println("stNum : " + TestStatic.stNum);
		TestStatic.stNum = 123;
		TestStatic.display2();

		TestStatic test1 = new TestStatic();
		System.out.println("#inNum : " + test1.inNum);
		System.out.println("#stNum : " + test1.stNum);
		test1.inNum = 1;
		test1.stNum = 2; // 다른 인스턴스의 stNum도 2로 고치게됨
		test1.display1();

		TestStatic test2 = new TestStatic();
		System.out.println("$inNum : " + test2.inNum);
		System.out.println("$stNum : " + test2.stNum);
		test2.inNum = 3;
		test2.stNum = 4;
		test2.display1();

	}

}
