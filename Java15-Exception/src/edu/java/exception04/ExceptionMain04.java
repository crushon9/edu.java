package edu.java.exception04;

public class ExceptionMain04 {

	public static void main(String[] args) {
		// Exception : 예외처리를 위한 클래스
		// |_ ArithmeticException
		// |_ NullPointerException
		// |_ ArrayIndexOutOfBoundsException
		// |_ ...
		System.out.println("예외 메시지 출력");
		try {
			System.out.println("try 내부");
			String name = null;
			System.out.println("문자열 길이 : " + name.length());
		} catch (Exception e) { // Exception -> NullPointException으로 하면 디테일하게 지정가능, 결과출력은 똑같음
			System.out.println("예외 메시지 : " + e.toString());
		}
		System.out.println("프로그램 종료"); // 예외처리를했기때문에 이부분이 출력가능

	}
}
