package edu.java.exception05;

public class ExceptionMain05 {

	public static void main(String[] args) {
		System.out.println("여러개의 예외 처리");
		// 하나의 try-catch 구문에서 여러개의 catch를 사용하는 방법

		try {
			int x = 12345;
			int y = 0;
			int result = x / y;
			System.out.println("result = " + result);

			int[] array = new int[10];
			array[11] = 100;
			System.out.println("array[11] = " + array[11]);

			String name = null;
			System.out.println("문자열 길이 : " + name.length());

		} catch (ArithmeticException e) {// e변수에 예외에 대한 정보가 저장됨
			System.out.println("산술연산 예외 : " + e.toString());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열인덱스 예외 : " + e.toString());

		} catch (NullPointerException e) {
			System.out.println("널포인터 예외 : " + e.toString());
		} catch (Exception e) {
			System.out.println("전체예외 : " + e.toString());
		}
		System.out.println("프로그램 종료");

		// 하나의 try구문에서 여러개의 catch를 사용하는 경우
		// 자식클래스의 Exception을 먼저 catch구문에서 사용하고
		// 가장 마지막에 최상위 부모 클래스인 Exception을 사용해야함

	}
}
