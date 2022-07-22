package edu.java.array08;

public class ArrayMain08 {

	public static void main(String[] args) {
		System.out.println("2차원 배열");

		// 2차원 배열 : 1차원 배열을 원소로 갖는 배열 dimension
		int[] korean = { 10, 20, 30 }; // 1차원 배열
		int[] english = { 40, 50, 60, 70 }; // 1차원 배열

		int[][] scores = { korean, english };
		// 이중 for반복문이랑 비교해서 int[i][j] 라고 생각하면됨
		System.out.println(scores[1][1]); // 1층 1호 또는 i = 1, j = 1
		System.out.println(scores[0][2]); // 0층 2호 또는 i = 0, j = 2
		System.out.println("층의 길이(개수) : " + scores.length); // i 개수
		System.out.println("0층의 호의 길이(개수) : " + scores[0].length); // j 개수
		// **String 2차원배열이면 사실 3차원이겠네? arr[i][j].length는 문자열자체의 길이겠네?

		for (int i = 0; i < scores.length; i++) { // 층만큼 반복
			for (int j = 0; j < scores[i].length; j++) { // 호만큼 반복
				System.out.print(scores[i][j] + " ");
			}
			System.out.println();
		}
		
		int[][] a = new int[3][4]; //3 X 4 배열 생성
		// 배열이 생성되면서 특정 주소값을 갖는다
		// 주소값은 컴퓨터 메모리에 저장되는 위치를 의미한다
		System.out.println(a); // 배열 a[0][0]의 주소값

		
	}
}
