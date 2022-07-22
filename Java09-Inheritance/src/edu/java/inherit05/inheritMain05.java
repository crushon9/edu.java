package edu.java.inherit05;

public class inheritMain05 {

	// * 모든 클래스의 부모클래스는 Object클래스 이다.
	public static void main(String[] args) {
		Person p1 = new Person("둘리");
		System.out.println(p1); // println의 매개변수타입은 Object
		System.out.println(p1.toString());
		// toString의 호출클래스는 java.lang.Object.toString()
		// Object클래스의 toString은 모든 클래스에서 사용가능
		// p1과 p1.toString()은 같은 결과를 출력

		System.out.println("=====Quiz=====");
		Point point = new Point(1.0, 2.0);
		System.out.println(point);
		System.out.println(point.toString());

		String str1 = new String("문자열");
		System.out.println(str1);
		System.out.println(str1.toString()); // 동일한 결과
		String str2 = new String(); // null값 저장
		System.out.println(str2);
		System.out.println("=============");

	}

}
