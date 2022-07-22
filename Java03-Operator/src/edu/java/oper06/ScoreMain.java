package edu.java.oper06;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		System.out.println("총점 및 평균 계산 프로그램");
		
		// 1. 입력받을 준비 : Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		// 2. 국어, 영어, 수학 점수를 정수로 입력받아서 변수에 저장
		System.out.println("국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.println("영어 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.println("수학 점수 입력 : ");
		int math = sc.nextInt();
		
		// 3. 국어, 영어, 수학 점수를 출력
		System.out.print("국어 : ");
		System.out.println(kor);
		System.out.print("영어 : ");
		System.out.println(eng);
		System.out.print("수학 : ");
		System.out.println(math);
		
		// 4. 총점을 계산하여 출력
		int sum = kor + eng + math;
		System.out.println("총점 : " + sum);
		
		// 5. 평균을 계산하여 출력(소숫점 셋째자리까지)
		double avr = sum / 3.0; // **그냥 3으로 나누면 소숫점버리고 정수로 저장됨
		System.out.printf("평균 : %.3f", avr);
		
		sc.close();
	}
}