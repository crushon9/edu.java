package edu.java.inherit02;

public class BusinessPerson extends Person {
	// 멤버 변수
	private String company;

//	*생성자
//자식클래스의 생성자가 호출되려면, 부모클래스의 생성자가 먼저 호출되어야함
//부모클래스의 생성자를 명시적으로 호출하지않으면, 부모클래스의 '기본생성자-super();'가 코드에 없어도 자동호출
//부모클래스의 생성자를 명시적으로 호출할때는 super();
//부모클래스의 매개변수있는 생성자는 자동으로 호출되지않기때문에 필요한경우 반드시 명시적으로 호출해야함 super(name)
//	- 자식클래스의 생성자에서 부모클래스의 생성자를 호출할때는 다른 어떤 코드보다 먼저 부모클래스르 호출해야함
	public BusinessPerson() {
		super(); // 부모 클래스의 기본생성자 호출 -> 생략가능
		System.out.println("BusinessPerson() 기본생성자");
	}

	public BusinessPerson(String name) {
		super(name); // 부모클래스의 매개변수있는생성자를 호출 -> 생략불가
		System.out.println("BusinessPerson() 매개변수생성자");
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	

}
