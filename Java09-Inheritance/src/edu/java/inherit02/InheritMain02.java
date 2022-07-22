package edu.java.inherit02;

public class InheritMain02 {

	public static void main(String[] args) {
		// 부모 Person 클래스의 인스턴스 생성
		Person p1 = new Person();
		// 인스턴스를 생성하면, 생성자가 호출된다
		
		// 부모 Person 클래스의 인스턴스 생성
		Person p2 = new Person("두나무");
		// 인자값을 전달하면, 매개변수가 있는 생성자가 호출된다
		
		System.out.println("====================");
		BusinessPerson p3 = new BusinessPerson();
		
		System.out.println("====================");
		BusinessPerson p4 = new BusinessPerson("구글");
		
		
	}

}
