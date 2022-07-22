package edu.java.variable07;

import java.util.Scanner;

public class casting {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        long result = (long) a + (long) b;
        System.out.println(result);
	
		sc.close();
	}
}