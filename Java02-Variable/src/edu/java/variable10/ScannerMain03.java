package edu.java.variable10;

import java.util.Scanner;

public class ScannerMain03 {

	public static void main(String[] args) {
		System.out.println("문자 하나 입력 받아 출력");

		Scanner sc = new Scanner(System.in);
		
		char ch1 = sc.nextLine().charAt(0); // 실제로는 문자열을 입력받지만 char로 저장
		System.out.println(ch1);
		
		sc.close();
	}

}
