package edu.java.method04;

import java.util.Scanner;

public class MethodMain04 {

	public static void main(String[] args) {
		System.out.println("배열을 매개변수로 갖는 메소드");
		// call by value 값을 넘겨줘서 해당 값을 저장하여 작업
		// call by reference 주소값을 전달하기 때문에 어느 위치에서든 같은 객체

		// 정수(int) 5개를 저장할 수 있는 배열 선언
		int[] scores = new int[5]; // new : heap 영역에 새로운공간을 할당
		System.out.println("선언주소값 : " + scores);

		// 배열에 데이터 입력
		inputScores(scores); // scores는 주소값을 인자로 전달함 call by reference
		// 배열값 출력
		printScores(scores);
		// 배열에 저장된 점수들의 총합을 출력
		int total = calcTotal(scores);
		System.out.println("합계 : " + total);

	} // end main()

	// 배열에 점수를 입력하는 기능
	private static void inputScores(int[] scores) { // 주소값을 전달 받음
		System.out.println("입력주소값 : " + scores);
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < scores.length; i++) {
			System.out.println("점수 : " + i + "번째 입력>");
			scores[i] = sc.nextInt();
		}
		sc.close();
	} // end inputScores()

	// 배열의 점수를 출력하는 기능
	private static void printScores(int[] scores) {
		// 값자체를 주고 받는거라면 리턴값을 void가 아니라 int[]로 주고받겠지만, 주소값을 주고받으므로 void로 해도 원본값이 수정됨
		System.out.println("출력주소값 : " + scores);
		for (int x : scores) {
			System.out.println("입력한 점수 : " + x);
		}
	} // end printScores()

	// 배열의 점수를 합산하는 기능
	private static int calcTotal(int[] scores) {
		int total = 0;
		for (int i = 0; i < scores.length; i++) {
			total += scores[i];
		}
		return total;
	} // end calcTotal()

} // end MethodMain04
