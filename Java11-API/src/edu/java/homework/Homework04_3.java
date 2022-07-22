package edu.java.homework;

import java.util.Scanner;

public class Homework04_3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String[] str = new String[num];
		for (int i = 0; i < num; i++) {
			str[i] = sc.nextLine();
		}

		String result;
		for (int i = 0; i < num; i++) {
			result = Character.toString(str[i].charAt(0));
			for (int j = 0; j < str[i].length() - 1; j++) {
				if (str[i].charAt(j) != str[i].charAt(j + 1)) {
					result = result + str[i].charAt(j + 1);
				}
			}
			System.out.println((str[i].length() - result.length()) + "개삭제 " + str[i] + " -> " + result);
		}
		sc.close();
	}
}
