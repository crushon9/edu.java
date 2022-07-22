package edu.java.for04;

import java.util.Scanner;

public class ForMain04 {

	public static void main(String[] args) {
		System.out.println("for문 연습");

		// Quiz 1
		// 1 ~ 10까지 숫자 중
		// 홀수면 홀수, 짝수면 짝수가 출력되는 프로그램
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		if (1 <= x && x <= 10) {
			if (x % 2 == 0) {
				System.out.println("짝수");
			} else {
				System.out.println("홀수");
			}
		} else {
			System.out.println("범위를 확인하세요");
		}

		// Quiz 2
		// for문과 if문을 활용하여 아래 출력 결과를 나타내시오
		/*
		 * 1꼬마 2꼬마 3꼬마 인디언 
		 * 4꼬마 5꼬마 6꼬마 인디언 
		 * 7꼬마 8꼬마 9꼬마 인디언 
		 * 10꼬마 인디언 보이~
		 */
		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) {
				System.out.print(i + "꼬마 인디언\n");
			} else if (i == 10) {
				System.out.println("10꼬마 인디언 보이~");
			} else {
				System.out.print(i + "꼬마 ");
			}
		}

		sc.close();
	}
}
