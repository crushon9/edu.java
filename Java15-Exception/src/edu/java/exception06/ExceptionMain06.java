package edu.java.exception06;

public class ExceptionMain06 {

	public static void main(String[] args) {
		// 하나의 try 구문에서 여러개의 catch를 사용하는 방법2 (Java7 버전부터)
		// try {
		// 정상일때 사용할 코드;
		// } catch { Ex1 | Ex2 | Ex3 | .. e) {
		// 예외일때 실행할 코드;
		// } catch (Exception e) {...}

		try {
			System.out.println("try start");
			int x = 12345;
			int y = 0;
			int result = x / y;
			System.out.println("result = " + result);

			int[] array = new int[10];
			array[11] = 100;
			System.out.println("array[11] = " + array[11]);

			String name = null;
			System.out.println("문자열 길이 : " + name.length());
			System.out.println("try end");

		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 : " + e.toString());

		} catch (Exception e) {
			System.out.println("전체예외 : " + e.toString());
		}

		System.out.println("프로그램 종료");

	}
}
