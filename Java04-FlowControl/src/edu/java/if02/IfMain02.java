package edu.java.if02;

import java.util.Scanner;

public class IfMain02 {

	public static void main(String[] args) {
		System.out.println("if-else 문");
		// if(조건) { 본문A }
		// else { 본문B }
		// - 조건이 참이면 본문A가 실행되고 거짓이면 본문B가 실행

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		// 0보다 큰 경우와 반대의 경우
		if (x > 0) { // 만약 x가 0보다 큰 경우
			System.out.println("양수");
		} else { // 만약 x가 0이하인 경우
			System.out.println("0보다 크지 않음");
		}
		
		if (x % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		sc.close();
	} // end main()
	
} // end IfMain02
