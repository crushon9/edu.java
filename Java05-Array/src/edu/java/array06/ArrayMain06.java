package edu.java.array06;

public class ArrayMain06 {

	public static void main(String[] args) {
		System.out.println("배열 연습2");

		boolean[] arr1 = { true, false, true, false };

		for (boolean b : arr1) {
			System.out.print(b + " ");
		}

		System.out.println("\n=============================");
		boolean[] arr2 = new boolean[4];
		// 배열의 인덱스가 짝수일 때는 true, 홀수일 때는 false를 저장
		for (int i = 0; i < arr2.length; i++) {
			if (i % 2 == 1) {
				arr2[i] = false;
			} else {
				arr2[i] = true;
			}
		}
		for (boolean b : arr2) {
			System.out.print(b + " ");
		}
		

	} // end main()
} // end ArratMain06
