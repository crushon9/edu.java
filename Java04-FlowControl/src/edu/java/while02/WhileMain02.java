package edu.java.while02;

import java.util.Scanner;

public class WhileMain02 {

	public static void main(String[] args) {
		System.out.println("while 구구단 연습");

		// 몇 단 입력받아 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 단? 숫자를 입력하세요");
		int dan = sc.nextInt();

		int i = 1;
		while (i < 10) {
			System.out.println(dan + " X " + i + " = " + dan * i);
			i++;
		}
		System.out.println("=========");
		
		
		// 전체 구구단 while 중첩반복문
		int d = 2;
		while (d < 10) {
			System.out.println(d + "단");
			i = 1;
			while (i < 10) {
				System.out.println(d + " X " + i + " = " + d * i);
				i++;
			}
			d++;
		}
		System.out.println("=========");
		
		
		// for문으로 구구단 출력하기
		// 단 : 2 ~ 9
		// 곱하는수 : 1 ~ 9
		for (int x = 2; x <= 9; x++) {
			System.out.println(x + "단");
			for (int y = 1; y <= 9; y++) {
				System.out.println(x + " X " + y + " = " + x * y);
			}
		}

		sc.close();

	}
}
