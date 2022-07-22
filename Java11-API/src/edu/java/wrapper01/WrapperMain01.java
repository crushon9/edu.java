package edu.java.wrapper01;

// Wrapper 클래스 : 자바의 기본 데이터 타입(primitive type)을 감싸는 클래스
// Byte, Character, Integer, Float, Double, Boolean, Long, Short
// 클래스이므로 첫 글자는 대문자
// Wrapper 클래스를 사용하는 이유
// 1. 클래스의 메소드, 상수를 사용하기 위해서 (static 메소드, 상수)
// 2. 매개변수 Object를 갖는 메소드의 인자값으로 사용하기 위해서
//	  (모든 클래스의 선조인 Object. 하지만 기본타입은 클래스가 아니니깐)
// 3. 컬렉션 프레임워크에서 사용하기 위해서
// 기본 타입의 데이터를 객체로 표현해야 하는 경우 래퍼클래스를 사용한다. 이런 객체를 포장 객체라고 한다

public class WrapperMain01 {

	public static void main(String[] args) {
		// Wrapper 클래스 상수(static)
		System.out.println(Integer.MIN_VALUE);

		// Wrapper 클래스로 변수 선언하기
//		Integer num1 = new Integer(123); / 원래 정석대로는 이게 맞는데 자바 9버전부터 일케 쓰지말래
		Integer num1 = 123;
		int n1 = num1; // 원래 안되는건데,, 됨..

		// valueOf() 함수
		Integer num3 = Integer.valueOf(100);
		System.out.println(num3);
		Double num4 = Double.valueOf(3.14);
		System.out.println(num4);
		Integer num5 = Integer.valueOf("100");
		System.out.println(num5);
//		num5 = Integer.valueOf("100.5"); Error 
//		num5 = Integer.valueOf("100안녕"); Error

		// parseXxx() : 문자열을 전달 받아서, 기본 자료형으로 리턴해주는 메소드
		int x = Integer.parseInt("12345");
		System.out.println(x);

		double y = Double.parseDouble("1.12345");
		System.out.println(y);
	}
}
