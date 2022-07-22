package edu.java.inherit03;

public class Phone {
	// 멤버 변수
	private String phoneNum;

	// 클래스의 기본생성자를 생략하면 컴파일러가 자동으로 기본생성자를 만들어줌
	// 생성자를 하나라도 정의한 경우, 자바 컴파일러는 기본 생성자를 자동으로 만들어주지 않음
//	public Phone() {
//	}
	
	public Phone(String phoneNum) {
		super();
		this.phoneNum = phoneNum;
		System.out.println("Phone(phoneNum) 매개변수생성자 호출");
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
