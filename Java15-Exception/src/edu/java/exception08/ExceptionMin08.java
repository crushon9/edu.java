package edu.java.exception08;

import java.util.Scanner;

public class ExceptionMin08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("메뉴 선택");
				int choice = Integer.parseInt(sc.next());
//				int choice = sc.nextInt(); // 이렇게 하면 버퍼가 입력되서 무한루프에 빠지네
				System.out.println("choice : " + choice);
				break;
			} catch (Exception e) {
				System.out.println("숫자가 아닙니다");
			}
		}

	}
}
