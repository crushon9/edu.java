package edu.java.inherit05;

public class Person {
	private String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	// 자바의 모든 클래스는 java.lang.Object 클래스를 상속받아서 만들어짐!
	// 자바의 모든 클래스는 Object 클래스의 public 메소드들을 사용가능
	// Object클래스의 toString() 메소드의 리턴값 : 패키지이름.클래스이름.@참조값
	// getClass().getName() + '@' + Integer.toHexString(hashCode())
	// 예시) edu.java.inherit05.Person@4d591d15
	
//	@Override
//	public String toString() {
//		return name + "입니다"; // 기존 toString() 변경
//	}

}
