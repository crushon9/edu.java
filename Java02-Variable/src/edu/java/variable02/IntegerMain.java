package edu.java.variable02;

public class IntegerMain {

	public static void main(String[] args) {
		System.out.println("정수(Integer) 자료형");
		byte n1 = 5;
		System.out.println("n1 = " + n1);
		
		// Ctrl + / : 코드 주석 처리 및 주석 해제
//		n1 = 128;
		short n2 =1234;
		System.out.println("n2 = " + n2);
//		n2 = 32768;
		// short 타입에 저장 할 수 있는 범위를 넘는 수는 저장 불가능
		
		// 각 타입의 최대와 최소를 구하는 방법
		int n3 = Integer.MIN_VALUE;
		System.out.println("n3 = " + n3);
		
		long n4 = Long.MAX_VALUE;
		System.out.println("n4 = " + n4);
		
	} // end main()

} // end IntegerMain