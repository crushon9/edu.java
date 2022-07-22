package edu.java.codeup;

import java.util.Scanner;

public class array1430_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		byte[] arr = new byte[10000000];
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			arr[sc.nextInt()] = 1;
		}
		
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			System.out.print(arr[sc.nextInt()] + " ");
		}
		
		sc.close();
	}
}