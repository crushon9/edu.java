package edu.java.if04;

import java.util.Scanner;

public class IfMain04 {

	public static void main(String[] args) {
		System.out.println("if - else if - else 연습");

		// 점수를 정수로 입력받아서
		// score가 90점 이상이면 "A"를 출력
		// score가 80점 이상이면 "B"를 출력
		// score가 70점 이상이면 "C"를 출력
		// score가 70점 미만이면 "F"를 출력
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();

		System.out.println("점수 등급은?"); // 사용자를 위해서,,
		if (score >= 90) { 
		// 첫 조건은 가장 큰값이나 적은값으로 해야 그 나머지범위가 else if로 내려간다
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else { 
// else는 개발자가 범위실수할 확률은 낮지만, 타인이 코드의 마지막범위를 알기 힘들수있다
// else if는 개발자가 범위실수할수도있다. 하지만 타인이 읽기에 범위가 가시적이다
			System.out.println("F");
		}

		sc.close();

	}
}
