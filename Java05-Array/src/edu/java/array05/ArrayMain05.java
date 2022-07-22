package edu.java.array05;

public class ArrayMain05 {

	public static void main(String[] args) {
		System.out.println("배열 연습1");

		// char 26개를 저장할 수 있는 배열 선언
		char[] alphas = new char[26];

		// for문을 사용하여 'a' ~ 'z'까지 저장
		for (int i = 0; i < alphas.length; i++) {
			alphas[i] = (char) ('a' + i);
		}
		// **생각해볼 문제
		for (char i = 'a'; i <= 'z'; i++) {
			alphas[i - 'a'] = i; // 이때 인덱스는 char일까? NoNo 빼기 연산하면서 숫자로 변환됐음;;
		}

		System.out.println("for-each : char변수");
		for (char x : alphas) { // 배열의 자료형과 변수자료형을 맞출것
			System.out.print(x + " ");
		}

		System.out.println("\nfor-each : int변수");
		for (int x : alphas) { // int로 하면 char배열이 자동형변환이 일어남
			System.out.print(x + " ");
		}

	} // end main()
} // end ArrayMain05