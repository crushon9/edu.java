package edu.java.variable08;

import java.util.Scanner;

public class ScannerMain01 {

	public static void main(String[] args) {
		System.out.println("변수 입력");
		
		// 입력을 받기 위한 변수는 Scanner 선언
		Scanner sc = new Scanner(System.in); // sc에 입력할 수 있는 기능이 적용
		// nextInt() : 정수를 입력받는 메소드
		// nextDouble() : 실수를 입력받는 메소드
		// nextLine() : 문자열 한 줄을 입력받는 메소드
		
		System.out.println("정수 입력하세요");
		int d = sc.nextInt(); // 정수 입력
		System.out.println("d : " + d);
		
		System.out.println("실수 입력하세요");
		double x = sc.nextDouble();
		System.out.println("x = " + x);
	
		System.out.println("문자열 한 줄 입력하세요");
		String str1 = sc.nextLine();
		String str2 = sc.next();
		// nextLine()메소드는 Enter전까지 입력받은 문자열을 리턴하고
		// next()메소드는 Space전까지 입력받은 문자열을 리턴한다
		
		// 위에서 nextDouble()메소드를 실행하면 콘솔에 실수값을 입력하고 엔터를 누른다
		// 이때 실수값을 리턴시키고 엔터값은 그대로 남아있다
		// nextLine() 메소드는 Enter값을 기준으로 **메소드를 바로 종료 시키게 된다
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		
		sc.close();
		
	} // end main()

} // end ScannerMain01
