package edu.java.array04;

public class ArrayMain04 {

	public static void main(String[] args) {
		System.out.println("배열 초기화 연습");
		// 우리반 학생 3명, 국어 점수를 저장한다.

		// 배열 선언과 초기화1:
		int[] koreans = new int[3];
		koreans[0] = 100;
		koreans[1] = 90;
		koreans[2] = 80;

		// 배열 선언과 초기화2:
		int[] english = { 100, 90, 80 };
		System.out.println(english.length);

		// for문을 사용한 출력
		for (int i = 0; i < english.length; i++) {
			System.out.println(english[i]);
		}

		// for-each 구문(향상된 for 구문)
		// for (타입 변수이름 : 배열) { ... }
		// - 위 타입은 배열과 동일한 타입으로 선언
		// - 배열에 있는 모든 테이터를 접근할 때 사용
		// **0번째부터 끝까지 접근, 거꾸로 불가, 인덱스없이 변수에 계속 바꿔담으면서 접근

		// for-each 사용한 출력
		for (int x : english) {
			System.out.println(x);
			// if(x>80){ 조건삽입하여 응용 가능}
		}	// for-each 작동원리 임시그릇 x변수에 바꿔담으면서 접근
			// 배열 {100, 90, 80}
			// 1) x = 100
			//		x 출력
			// 2) x = 90
			//		x 출력
			// 3) x = 80
			//		x 출력

		
	} // end main()
} // end ArrayMain04
