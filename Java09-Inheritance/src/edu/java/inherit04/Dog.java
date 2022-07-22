package edu.java.inherit04;

public class Dog extends Animal {
	// 멤버 변수
	private String type;

	// 생성자 overloading
	public Dog() {
	}

	public Dog(String name, String type) {
		super(name);
		this.type = type;
	}

	// 메소드 재정의(override)
	// - 부모클래스가 가지고있는 메소드를 자식클래서에서 재정의(다시정의)
	// - 메소드의 리턴타입, 이름, 매개변수 모두 부모클래스의 메소드와 일치해야함 (즉 본문내용만변경가능)
	// override를 쓰는이유는 speak라는 부모메소드로 묶기위함
	@Override // <- 일종의 주석같은거..
	public void speak() {
		System.out.println("멍멍!");
	}

}
