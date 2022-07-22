package edu.java.if06;

import java.util.Scanner;

public class IfMain06 {

	public static void main(String[] args) {
		System.out.println("if 중첩문 연습");

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		sc.close();

		// 1) 입력된 정수에 대해 짝수와 홀수로 나눔
		// 2) 만약 짝수인 경우, 입력된 정수가 4의 배수면 -> 4의 배수
		// 입력된 정수가 4의 배수가 아니면 -> 4의 배수가 아닌 짝수

		if (num % 2 == 0) { // 짝수일 때
			System.out.println("짝수");
			if (num % 4 == 0) { // 4의 배수일 때
				System.out.println("4의 배수");
			} else { // 4의 배수가 아닐 때
				System.out.println("4의 배수가 아닌 짝수");
			}

		} else { // 홀수일 때
			System.out.println("홀수");
		}

	} // end main()

} // end IfMain
