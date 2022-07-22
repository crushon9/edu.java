package edu.java.array02;

public class ArrayMain02 {

	public static void main(String[] args) {
		System.out.println("배열의 선언, 초기화, 출력");

		// int형 정수 10개를 저장할 수 있는 배열 선언
		int[] array = new int[10];
		System.out.printf("array참조변수에 담긴 주소 : %s\n", array);

		// 배열의 길이 출력
		// *그냥 숫자로 입력하면 리스크가 크기때문에 length 메소드를 쓴다
		System.out.println("배열의 길이 : " + array.length);

		// 배열의 인덱스 : 0 ~ (length - 1)
		// for문을 사용하여 배열에 1 ~ 10까지의 값을 저장
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}

		// for문을 사용하여 배열의 모든 값 출력
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			System.out.print(" ");
		}

		System.out.println();
		// Quiz 거꾸로 출력하기
		for (int i = array.length; i > 0; i--) {
			System.out.print(array[i - 1]);
			System.out.print(" ");
		}

		System.out.println();
		// for문을 사용하여 배열의 모든 값(원소)들을 더하기
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (i + 1 == array.length) {
				System.out.println("array[] sum = " + sum);
			}
		}

	} // end main()
} // end ArrayMain02
