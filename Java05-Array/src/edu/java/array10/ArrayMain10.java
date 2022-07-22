package edu.java.array10;

public class ArrayMain10 {

	public static void main(String[] args) {
		System.out.println("배열 연습");

		int[] integer = { 11, 10, 8, 6 };

		// 인덱스의 값이 짝수인 배열 원소 출력 element
		for (int i = 0; i < integer.length; i++) {
			if (i % 2 == 0) {
				System.out.print(integer[i] + " ");
			}
		}

		// 배열의 원소가 짝수인 원소 출력
		for (int i = 0; i < integer.length; i++) {
			if (integer[i] % 2 == 0) {
				System.out.print(integer[i] + " ");
			}
			if (i + 1 == integer.length) {
				System.out.println();
			}
		}

		String[] str = { "사과", "배", "바나나", "당근" };
		// 문자열 배열 원소 중에 "배"라는 글자가 있으면 "배를 찾았습니다" 출력
		for (String x : str) {
			if (x.equals("배") == true) { // s == "배" 도 가능
				System.out.println(x + "을(를) 찾았습니다!");
				break;
			}
		}

	} // end

}
