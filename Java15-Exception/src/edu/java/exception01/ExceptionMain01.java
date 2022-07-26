package edu.java.exception01;

// 컴파일에러 : 소스코드 빌드 시 발생하는 에러 (실행파일이 만들어지지 않기 때문에 실행할 수 없음)
// 예외(Exception) : 소스코드 빌드땐 에러가 없었지만, 실행파일을 실행할 때 발생하는 오류 
// 논리적오류 : 컴파일 에러도 없고 실행시 예외도 발생하진않지만, 논리적 문제로 원하는 결과가 나오지 않는 경우

public class ExceptionMain01 {

	public static void main(String[] args) {
//		int 123; // 컴파일 에러

//		int n = 123 / 0; // 예외 발생 ArithmeticException

		int result = findMax(20, 1); // 논리적 오류
		System.out.println(result);

	} // end main

	public static int findMax(int x, int y) {
		if (x < y) {
			return x;
		} else {
			return y;
		}
	} // end findMax

} // end ExceptionMain01
