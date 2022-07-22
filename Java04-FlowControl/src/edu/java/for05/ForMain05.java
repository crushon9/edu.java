package edu.java.for05;

public class ForMain05 {

	public static void main(String[] args) {
		System.out.println("for문 연습");

		// 등차수열의 합 구하기
		// 1 + 2 + 3 + ... + 10
		int sum1 = 0;
		for (int i = 1; i <= 10; i++) {
			sum1 += i;
		}
		System.out.println(sum1);

		// 1 ~ 100까지의 숫자 중 짝수들의 합을 출력
		int sum2 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum2 += i;
			}
		}
		System.out.println(sum2);

	}

}