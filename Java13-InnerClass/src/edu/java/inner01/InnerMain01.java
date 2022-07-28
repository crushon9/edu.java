package edu.java.inner01;
// 변수 선언
// 1. 멤버변수(필드) : 클래스에서 선언된 변수
//				   클래스내부 어느곳에서나 사용가능
//				   접근제한자 및 수식어 사용가능

// 2. 지역변수 : 메소드 안에서 선언된 변수
//		 	  변수가 속한 블록{ }안에서 사용가능
//		 	  접근제한자 및 수식어 사용불가 (final은 가능)
public class InnerMain01 {
	private int member; // 멤버 변수

	public static void main(String[] args) {
		int local; // 지역 변수

		// OuterClass의 인스턴스 생성
		// 외부클래스의 인스턴스를 생성했다고해서 내부클래스의 인스턴스까지 생성된 것은 아님
		// 즉, 외부클래스의 참조변수가 내부클래스의 메소드를 사용할수없음
		OuterClass out1 = new OuterClass(100);
		out1.display();
		System.out.println("------");

		// InnerClass의 인스턴스 생성
		// (외부클래스).(내부클래스) 참조변수 = (외부클래스참조변수).new (내부클래스생성자)();
		OuterClass.InnerClass inner1 = out1.new InnerClass(200);
		inner1.printValues();
		System.out.println("------");

		// 내부클래스의 인스턴스를 통한 외부클래스 멤버변수 변경
		inner1.setOuterValue(111);
		inner1.printValues();
		out1.display();
		System.out.println("------");
		
		// InnerClass의 인스턴스 또 생성
		OuterClass.InnerClass inner2 = out1.new InnerClass(777);
		inner2.printValues();
		System.out.println("------");

	}

}
