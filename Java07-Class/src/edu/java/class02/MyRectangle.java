package edu.java.class02;

// 클래스
// 상태(속성, 성질) - 멤버 변수(field, property)
// 기능 - 메소드
// 생성자(constructor)
//			- 멤버 변수들을 초기화
//			- 클래스 이름과 동일
//			- 매개변수는 있을 수도 없을 수도
//			- 클래스를 작성할 때 생성자를 하나도 정의하지 않은 경우 반드시 있어야하기때문에, 
//			- 자바 컴파일러가 기본 생성자를 자동으로 만듬
//			- 생성자를 하나라도 정의한 경우에는, 자동으로 기본 생성자를 만들지 않음

public class MyRectangle {
	// 멤버 변수
	double width; // 직사각형의 가로
	double height; // 직사각형의 세로

	// 기본 생성자
	public MyRectangle() {
	}

	// 매개변수가 있는 생성자
	public MyRectangle(double width, double height2) { // 지역 변수
		this.width = width; // this : 객체 자기 자신 (MyRectangle 클래스), 나 자신의 인스턴스
		height = height2; // 이름이 중복되지 않으면 this를 하지 않아도 됨
	}

	// 메소드
	public double calcArea() {
		return width * height; // 이름이 중복되지 않으니깐 this를 안해도 됨
	}

}
