package edu.java.if05;

import java.util.Scanner;

public class IfMain05 {

	public static void main(String[] args) {
		System.out.println("if - else 문자 조건 연습");
		// 문자 하나를 입력받아서 그 글자가
		// 1) A ~ Z이면, "영대문자"라고 출력
		// 2) a ~ z이면, "영소문자"라고 출력
		// 3) 0 ~ 9이면, "숫자"라고 출력
		// 4) 그 외 경우는, "몰라요"라고 출력
		Scanner sc = new Scanner(System.in);

		System.out.println("문자를 입력하세요 :");
		String str = sc.next();

		if (str.length() == 1) {
			char ch = str.charAt(0);

			if (ch >= 'A' && ch <= 'Z') {
				System.out.println("영대문자");
			} else if (ch >= 'a' && ch <= 'z') {
				System.out.println("영소문자");
			} else if (ch >= '0' && ch <= '9') {
				System.out.println("숫자");
			} else {
				System.out.println("몰라요");
			}

		} else {
			System.out.println("문자는 하나만 입력하세요");
		}

		sc.close();
	}
}