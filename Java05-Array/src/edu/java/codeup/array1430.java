package edu.java.codeup;

import java.util.Scanner;

public class array1430 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] Narr = new int[n];
		for (int i = 0; i < Narr.length; i++) {
			Narr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] Marr = new int[m];
		for (int i = 0; i < Marr.length; i++) {
			Marr[i] = sc.nextInt();
		}
	
		for (int i = 0; i < Marr.length; i++) {
			boolean flag = false;
			for (int j = 0; j < Narr.length; j++) {
				if (Marr[i] == Narr[j]) {
					Marr[i] = 1;
					flag = true;
					break;
				}
			}
			if (flag == false) {
				Marr[i] = 0;
			}
		}

		for (int i = 0; i < Marr.length; i++) {
			System.out.print(Marr[i]);
			System.out.print(" ");
		}

		sc.close();
	}
}