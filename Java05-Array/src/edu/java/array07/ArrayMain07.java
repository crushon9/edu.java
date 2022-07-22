package edu.java.array07;

public class ArrayMain07 {

	public static void main(String[] args) {
		System.out.println("배열 연습3");
		// char배열로 나열한게 String이다..
		String test = "문자열입니다.";
		System.out.println(test);

		System.out.println("문자열의 길이 : " + test.length());

		// 문자열 배열 선언
		String[] subjects = { "국어", "영어", "수학", "프로그래밍" };
//		char[][] subjects2 = { {'국','어'}, {'영','어'}};
		// "영어"의 문자열 길이를 출력
		System.out.println("문자열배열의 요소 길이 : " + subjects[1].length());

		// Quiz : 모든 subjects의 문자열 길이를 출력
		for (int i = 0; i < subjects.length; i++) {
			System.out.print(subjects[i].length() + " ");
		}
		System.out.println();
		for (String str : subjects) {
			System.out.print(str.length() + " ");
		}

	}

}
