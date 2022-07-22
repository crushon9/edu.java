package edu.java.codeup;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];

		int num = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[n - 1 - j][m - 1 - i] = num;
				num++;
			}
		}

		for (int i = 0; i < a.length; i++) { // 층만큼 반복
			for (int j = 0; j < a[i].length; j++) { // 호만큼 반복
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}