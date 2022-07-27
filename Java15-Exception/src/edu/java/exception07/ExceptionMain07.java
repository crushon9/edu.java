package edu.java.exception07;

import java.util.Scanner;

public class ExceptionMain07 {

	public static void main(String[] args) {
		System.out.println("try-catch-finally");

		// try {
		// 정상적인 경우 실행할 코드;
		// } catch (Exception e) {
		// 예외상황일때 실행할 코드;
		// } finally {
		// 정상적인 경우든, 예외 상황이든 상관없이 항상 실행할 코드
		// }

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("try 실행");
			int a = sc.nextInt();
			int b = sc.nextInt();
			int result = a / b;
			System.out.println("result = " + result);
			System.out.println("try 종료");
		} catch (Exception e) {
			System.out.println("catch 실행");
			System.out.println(e.toString());
		} finally {
			System.out.println("finally 실행");
			sc.close();
		}
		System.out.println("프로그램 종료");

	}
}
