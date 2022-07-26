package edu.java.lambda02;

@FunctionalInterface
interface Test1 {
	public abstract void testPrint();
}

@FunctionalInterface
interface Test2 {
	public abstract void testPrint(int n);
}

public class LambdaMain02 {

	public static void main(String[] args) {

		System.out.println("- 익명클래스, 람다 표현식 연습 -");
		// 람다표현식
		// (매개변수1, 매개변수2, ... ) -> {실행문; 리턴}
		// 매개변수와 리턴타입 형태는 인터페이스의 추상메소드에 따라 결정됨
		// 인터페이스 변수이름 = (매개변수1, 매개변수2, ... ) -> {실행문; 리턴}

		// 1. "익명 클래스 연습!" 출력하는 익명클래스 생성 및 출력하기
		Test1 t1 = new Test1() {
			@Override
			public void testPrint() {
				System.out.println("익명 클래스 연습!");
			}
		};
		t1.testPrint();

		// 2. "람다 표현식 연습!" 출력하는 람다표현식 생성 및 출력하기
		Test1 t2 = () -> {
			System.out.println("람다 표현식 연습!");
		};
		t2.testPrint();

		// 3. 정수하나입력받아 "입력한 숫자는 : 100" 출력 익명클래스
		Test2 t3 = new Test2() {
			@Override
			public void testPrint(int n) {
				System.out.println("입력한 숫자는 : " + n);
			}
		};
		t3.testPrint(100);

		// 4. 정수하나입력받아 "입력한 숫자는 : 100" 출력 람다표현식
		Test2 t4 = (n) -> {
			System.out.println("입력한 숫자는 : " + n);
		};
		t4.testPrint(100);

	}
}
