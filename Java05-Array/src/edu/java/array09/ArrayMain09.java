package edu.java.array09;

public class ArrayMain09 {

	public static void main(String[] args) {
		System.out.println("2차원 배열 연습");
		String[] avengers = { "아이언맨", "토르", "헐크", "캡틴아메리가", "닥터스트레인지" };
		String[] villain = { "타노스", "하이드라", "레드스컬" };
		String[][] marvel = { avengers, villain };

		// 이중 for-each 로 출력
		for (String[] group : marvel) {
			for (String name : group) {
				System.out.println(name + " ");
			}
			System.out.println();
		}
		
		System.out.println(marvel[0][4].length());
		// char로 3중 반복문
		for (int i = 0; i < marvel.length; i++) {
			for (int j = 0; j < marvel[i].length; j++) {
				for (int k = 0; k < marvel[i][j].length(); k++) {
					System.out.print(marvel[i][j].charAt(k) + " ");
				}
				System.out.println("*");
			}
			System.out.println(".");
		}


	} // end main()
} // end ArrayMain09
