package edu.java.inherit03;

public class SmartPhone extends Phone {
	
//	생성자
//	자식클래스의 생성자가 호출되면, 부모클래스의 생성자가 먼저 실행된 후에 자식클래스의 코드들이 실행됨
	// (즉 자식클래스 생성자안에 부모클래스생성자를 집어넣어야함)
//	1) 부모클래스의 생성자를 명시적으로 호출하지 않을때는 super();가 자동으로 호출
//	2) 부모클래스의 생성자를 명시적으로 super(); 또는 super(매개변수);로 호출 가능
	
//	만약에 부모클래스가 기본생성자를 가지고있지 않은 경우에는
//	super();가 자동으로 호출될 수 없기 때문에,
//	자식클래스의 생성자에서 (매개변수);를 호출하는 코드가 반드시 있어야 함
	// **그러니 그냥 기본생성자는 수동으로 늘 만들자!
	
//	부모클래스인 Phone에 기본생성자가 정의되어있지 않기때문에 자식클래스에서도 기본생성자 정의 불가
//	public SmartPhone() {}
	
	public SmartPhone(String phoneNum) {
		super(phoneNum);
		System.out.println("SmartPhone(phoneNum) 매개변수생성자 호출");
	}
	
}
