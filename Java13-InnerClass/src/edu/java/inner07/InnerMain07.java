package edu.java.inner07;

interface Hello {
	public abstract void hello();
}

class Person implements Hello {

	@Override
	public void hello() {
		System.out.println("안녕");
	}

} // end Person

class Dog implements Hello {

	@Override
	public void hello() {
		System.out.println("왈왈");
	}

} // end Dog

public class InnerMain07 {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.hello();

		Hello p2 = new Person(); // 다형성
		p2.hello();

		Hello dog = new Dog(); // 다형성
		dog.hello();

//		Hello cat = new Hello(); 원래 인터페이스 Hello는 인스턴스 생성 불가
		Hello cat = new Hello() { // 익명클래스로 재정의하여 사용가능
			@Override
			public void hello() {
				System.out.println("야옹");
			}
		};
		cat.hello();

		Hello father = new Hello() {
			@Override
			public void hello() {
				System.out.println("I'm your father");
			}
		};
		father.hello();
		
		// new Hello() { ..본체.. }
		// 본체 : Hello 인터페이스를 구형하는 클래스의 내용(객체)
		
		// 익명클래스를 사용하는 이유
		// 인터페이스의 메소드가 한개일때 클래스 외부에서 선언하여 implements하지 않고 사용하기 위해
		// 익명 클래스를 사용하면 클래스를 외부에서 생성할 피룡가없음
		// 객체를 한번생성하고 더이상 생성하지 않을경우 사용

	} // end main
} // end InnerMain07
