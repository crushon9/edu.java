package edu.java.array01;

// 배열
// 같은 타입의 변수들을 하나의 목록으로 저장할 때 사용
// 배열의 선언과 초기화
//		배열타입[] 배열이름 = new 배열타입[배열길이];
//		배열이름[인덱스] = 값;
//		or
//		배열타입[] 배열이름 = { 값1, 값2, ...}
// 배열의 인덱스는 0부터 시작

public class ArrayMain01 {

	public static void main(String[] args) {
		System.out.println("배열(array)");

		// 초기화 방식1
		char[] scores = new char[4];
		scores[0] = 90;
		scores[1] = 80;
//		scores[2] = 70;
//		scores[3] = 60;
		for (int i = 0; i < 4; i++) {
			System.out.println((int)scores[i]);
		}
		
		// 초기화 방식2
//		int[] scores = {90, 80, 70, 60};

// 선언시 배열길이 꼭 지정해야함, 배열 형변환가능, 배열초기값은 default값 0이 들어가있음
		

	}

}
