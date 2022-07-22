package edu.java.method02;

public class MethodMain02 {
	// 자바는 컴파일시 모든 메소드를 자동으로 앞쪽에 선언하기 때문에 호출위치와 선언위치의 순서는 상관없다고한다..
	// 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 합을 리턴
	// 메소드이름 : add
	// 리턴타입 : int
	// 매개변수 : int x, int y
	public static int add(int x, int y) {
		return x + y;
	}
//	public static int add(int x, int y) {
//		int sum = x + y;
//		return sum;
//	}
//	위의 두 메소드는 같은 기능
	// 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 차를 리턴
	public static int sub(int x, int y) {
		return Math.abs(x - y);
	}
	// 기능 : 두 개의 실수를 매개변수로 전달받아서, 두 실수의 곱을 리턴
	public static double mul(double x, double y) {
		return x * y;
	}
	// 기능 : 두 개의 실수를 매개변수로 전달받아서, x를 y로 나눈값을 리턴
	public static double div(double x, double y) {
		return x / y;
	}
	public static void main(String[] args) {
		System.out.println("메소드 연습");
		int result = add(10, 20);
		System.out.println("add = " + result);

		result = sub(20, 10);
		System.out.println("sub = " + result);

		double m = mul(1.2, 3.4);
		System.out.println("mul = " + m);

		m = div(1, 2); // 자동 형 변환 가능성을 염두
		System.out.println("div = " + m);

		// 매개변수로 함수 리턴값 넣기 (add리턴값 int는 double로 자동 형 변환 됐음)
		m = mul(add(10, 20), 2);
		System.out.println("div = " + m);
		
	} // end main()
} // end MethodMain02
