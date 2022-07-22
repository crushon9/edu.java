package edu.java.class03;

public class MyCircle {
	// 멤버 변수
	double radius;
	// 기본 생성자
	public MyCircle() {}
	// 매개변수 있는 생성자
	public MyCircle(double radius) {
		this.radius = radius;
		// 현재 클래스(MyCircle)에 있는 radius 변수에
		// 외부에서 받아오는(매개변수) radius의 값을 저장한다
	}
	// 메소드
	public double calcAlea() {
		return 3.14 * radius * radius;
	}

}
