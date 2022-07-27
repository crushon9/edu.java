package edu.java.exception02;

import java.util.Scanner;

public class ExceptionMain02 {

	public static void main(String[] args) {
		System.out.println("예외 사례");
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요>");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		if (n2 != 0) { // if 는 아예 조건으로 입구부터 막는거고, 그러니 무슨 에러가날지 예상해야가능
			int result = n1 / n2;
			System.out.println("result = " + result);
		} else {
			System.out.println("n2의 값으로 0이 아닌 값을 입력하세요");
		}
		System.out.println();

// try 구문 : 예외발생 상황에 대해 처리해주는 기능
// try {
//		정상적인 실행 문장들;
// } catch (예외클래스 변수이릅) {
//		예외상황일때 실행할 문장들
// }
		try { // try 구문을 실행하다가 예외가 발생하면 catch로 넘어감
			System.out.println("try 내부");
			System.out.println("n3 입력>");
			int n3 = sc.nextInt();
			System.out.println("n4 입력>");
			int n4 = sc.nextInt();
			int result = n3 / n4;
			System.out.println("result = " + result);
		} catch (Exception e) { // 각종 Exception 들의 부모클래스
			System.out.println("예외 발생 : " + e.getMessage());
		}
		System.out.println("프로그램 종료");

		sc.close();
	}

}
