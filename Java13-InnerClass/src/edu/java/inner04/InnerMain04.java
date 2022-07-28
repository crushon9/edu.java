package edu.java.inner04;

// 외부 클래스
class OuterClass {
	int value;
	static int count = 0;

	public OuterClass(int value) {
		this.value = value;
	}

	// static 내부 클래스(중첩 클래스, nested class)
	static class NestedClass {
		private String name;
		static int test;

		public NestedClass(String name) {
			this.name = name;
		}

		public void display() {
//			System.out.println("value = " + value);
			// static class니깐 외부클래스의 static이 아닌 변수는 참조할 수 없음!

			System.out.println("count = " + count);
			// 외부클래스에서 static으로 선언된 변수는 참조 가능

			System.out.println("name = " + name);

		} // end display()

		public static void testMethod() {
			System.out.println("hi");
		}

	} // end NestedClass
} // end OuterClass

public class InnerMain04 {

	public static void main(String[] args) {
		// static 멤버 변수 사용 : (클래스이름).(변수이름)
		OuterClass.count = 100;
		System.out.println(OuterClass.count);

		// 중첩 클래스(static 클래스)의 인스턴스 생성 (외부클래스의 인스턴스를 생성하지 않아도 접근가능)
		// (외부클래스 이름).(중첩클래스 이름) 변수이름 = new (외부클래스 이름).(내부클래스 이름)();
		OuterClass.NestedClass nest = new OuterClass.NestedClass("Peter");
		nest.display();

		// 중첩 클래스(static 클래스)의 static 변수 사용하기
		OuterClass.NestedClass.test = 1;

		// 중첩 클래스(static 클래스)의 static 메소드 사용하기
		OuterClass.NestedClass.testMethod();

	} // end main()
} // end InnerMain04
