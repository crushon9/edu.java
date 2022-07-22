package edu.java.array03;

import java.util.Scanner;

public class ArrayMain03 {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		Scanner sc = new Scanner(System.in);
		// Ctrl + Shift + o : 자동 import 단축키
		System.out.println("입력받을 점수 개수>");
		int n = sc.nextInt();
		// 배열에 점수 입력받기
		int[] scores = new int[n];
		for (int i = 0; i < scores.length; i++) {
			System.out.println(i + "번째 점수입력>");
			scores[i] = sc.nextInt();
		}
		// 입력받은 점수 모두 출력
		for (int i = 0; i < scores.length; i++) {
			System.out.println(i + "번째 점수 : " + scores[i]);
		}
		// 배열에 저장된 모든 점수의 합 출력
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
			if (i + 1 == scores.length) {
				System.out.println("합계 = " + sum);
			}
		}
		// 평균 출력하기 (소수점까지 표현)
		double avg = (double) sum / (double) scores.length;
// (double) sum/length 일때 (double)sum을 length로 나누니깐 double로 자동형변환
// (double) (sum/length) 일때 (sum /length)값을 double로 형변환함
		System.out.println("평균 = " + avg);

		// 점수 중 최대값 출력
		int max = Integer.MIN_VALUE; // int 범위 중에 최소값 저장
		for (int i = 0; i < scores.length; i++) {
			if (max < scores[i]) { // 배열에 저장된 값이 max보다 크면
				max = scores[i]; // max에 그 값을 저장해라
			}
			if (i + 1 == scores.length) {
				System.out.println("최대값 = " + max);
			}
		}
		// 점수 중 최소값 출력
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < scores.length; i++) {
			if (min > scores[i]) {
				min = scores[i];
			}
			if (i + 1 == scores.length) {
				System.out.println("최소값 = " + min);
			}
		}

		sc.close();
	}
}
