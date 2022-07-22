package edu.java.for02;

public class ForMain02 {

	public static void main(String[] args) {
		// println() : 맨 마지막 줄바꿈(\n)이 포한된 출력 함수
		// print() : 문자열을 나열하여 출력

		// 10이하의 짝수만 오름차순으로 출력 3가지 방법
		
		// 첫번째 방법 2씩증가 0 2 4 6 8 10
		for (int i = 0; i < 11; i += 2) {
			System.out.print(i);
			if (i != 10) {
				System.out.print(" ");
			}
		}
		System.out.println();

		// 두번째 방법 1씩증가하여 2곱하기 2*0 2*1 2*2 2*3 2*4 2*5
		for (int i = 0; i < 6; i++) {
			System.out.print(i * 2);
			if (i != 5) {
				System.out.print(" ");
			}
		}
		System.out.println();

		// 세번째 방법 0~10에서 짝수만 필터링
		for (int i = 0; i < 11; i++) {
			if (i % 2 == 0) {
				System.out.print(i);
				if (i != 10) {
					System.out.print(" ");
				}
			}
		}

	} // end main()
} // end ForMain02