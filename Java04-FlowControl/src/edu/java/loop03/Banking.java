package edu.java.loop03;

import java.util.Scanner;

public class Banking {

	public static void main(String[] args) {
		System.out.println("JAVA 은행");
// 프로그램을 종료하면 데이터가 모두 날아감..ㅎ 
		Scanner sc = new Scanner(System.in);

		int balance = 0;
		boolean run = true;
		while (run) {
			
			System.out.println("============================");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("============================");
			System.out.print("선택> ");
			int choice = sc.nextInt(); // 선택된 값을 저장할 변수

			switch (choice) {
			case 1:
				System.out.print("예금액> ");
				balance += sc.nextInt(); // 기존 값에 입력된 값을 합산
				System.out.println("저장되었습니다.");
				break;
			case 2:
				System.out.print("출금액> ");
				balance -= sc.nextInt();
				System.out.println("저장되었습니다.");
				break;
			case 3:
				System.out.println("잔액> " + balance + " 입니다.");
				break;
			case 4:
				System.out.println("종료합니다.");
				run = false;
				break;
			default: // else와 같은 기능
				System.out.println("올바른 메뉴를 선택하세요.");
				break;
			}
		}
		sc.close();
	}
}
