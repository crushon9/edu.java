package edu.java.while01;

// while 문
// - for문과 같은 반복문
// - 선언 형태
// 	while (조건) {
//		본문
// 	}

public class WhileMain01 {

	public static void main(String[] args) {

		// 0 ~ 10 까지 출력
		int x = 0;
		while (x <= 10) {
			System.out.print(x + " ");
			x++;
		}
		
		System.out.println();
		// while문을 사용하여 10 ~ 1 까지 출력하기
		x = 10;
		while (x >= 1) {
			System.out.print(x + " ");
			x--;
		}

	} // end main()
} // end WhileMain01
