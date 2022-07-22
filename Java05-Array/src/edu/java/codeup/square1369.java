package edu.java.codeup;

import java.util.Scanner;

public class square1369 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = m - 1;

		for (int i = 0; i < n; i++) {

			if (i == 0 || i == n - 1) {
				for (int j = 0; j < n; j++) {
					System.out.print("*");
				}
			} else {
				System.out.print("*");
				
				int index = 2;
				for (int k = n - 2; k > 0; k--) {

					if (index % m == x) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
					index++;
				}
				System.out.print("*");
				x--;
				if (x < 0) {
					x = m - 1;
				}
			}
			System.out.println();
		}
		sc.close();
	}
}