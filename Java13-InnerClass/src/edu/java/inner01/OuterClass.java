package edu.java.inner01;

// 내부클래스(Inner Class) : 다른 클래스 내부에서 정의된 클래스

// 1. 멤버 내부클래스(member inner class)
//	- 멤버변수를 선언하는 위치에서 정의하는 내부클래스
//	- 외부클래스의 인스턴스가 생성되어야만 객체 생성이 가능함

// 2. static 내부클래스(static inner class), 중첩클래스(nested class)
//	- 멤버변수를 선언하는 위치에서 static으로 정의한 내부클래스
//	- 외부클래스의 인스턴스를 생성하지 않아도 객체생성이 가능함
//	- 외부클래스와 상관없는 클래스라고 생각해도 됨

// 3. 지역 내부클래스(local inner class) : 메소드 안에서 정의하는 클래스

// 4. 익명클래스(anonymous class) : 이름없는 내부클래스, 람다표현식 사용가능

public class OuterClass {
	// 멤버변수
	private int value1;
	// 생성자
	public OuterClass(int value1) {
		this.value1 = value1;
	}
	// 메소드
	public void display() {
		System.out.println("value1 = " + value1);
	}

	// 멤버 내부클래스(member inner class)
	class InnerClass {
		private int value2;
		public InnerClass(int value2) {
			this.value2 = value2;
		}
		// 외부클래스의 멤버변수는 내부클래스에서 직접사용가능
		public void setOuterValue(int value) {
			value1 = value;
		}
		public void printValues() {
			System.out.println("outervalue : " + value1);
			System.out.println("innervalue : " + value2);
		}
	} // InnerClass
} // OuterClass
