package edu.java.if03;

import java.util.Scanner;

public class IfMain03 {

	public static void main(String[] args) {
		// Ctrl + Shift + f : 자동 줄맞춤
		System.out.println("if - else if - else 문");
		// if(조건1) { 본문A } 
		// else if(조건2) { 본문B }
		// ...
		// else { 본문Z }
		// - 조건1이 참이면 본문A, 조건2가 참이면 본문B, 모두 아닐 경우 본문Z 실행
		// - else if절은 1개 이상 작성 가능
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		if (x > 0) {
			System.out.println("양수");
		} else if (x == 0) {
			System.out.println("0");
		} else {
			System.out.println("음수");
		}
		
		sc.close();
		
	} // end main()
	
} // end IfMain03
