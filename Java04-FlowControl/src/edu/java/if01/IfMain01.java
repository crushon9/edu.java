package edu.java.if01;

import java.util.Scanner;

// 흐름 제어(Flow Control)
// - 프로그램의 실행 흐름을 개발자가 원하는 방향으로 바꿀 수 있음
// - 제어문이라고 부름
// - 제어문에는 조건문과 반복문이 존재
// - 조건문 : if , if-else , if-else if-else , switch
// - 반복문 : for , while , do-while

public class IfMain01 {

	public static void main(String[] args) {
		System.out.println("if문");
		
		// if(조건) { 본문 }
		// - 조건이 참(true)이면 본문을 실행
		
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		// 만약 score가 90점 이상인 조건이 참이면
		if (score >= 90) {
			System.out.println("점수가 90점 이상입니다.");
			System.out.println("등급은 A 입니다.");
		}
		// 만약 score가 90점 미만인 조건이 참이면
		if (score < 90) {
			System.out.println("점수가 90점보다 작습니다.");
			System.out.println("등급은 B 입니다.");
		}
		
		
		sc.close();
		
	} // end main()
} // end IfMain01