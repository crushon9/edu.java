package edu.java.inherit01;

public class BasicTv {
	// 멤버 변수(필드, 프로퍼티)
	boolean powerOn; // (package) 접근제한자가 생략된 것. 상속인스턴스에서 사용가능
	int channel;
	private int volume; // private은 상속인스턴스에서 사용불가
	
	// 기본생성자
	public BasicTv() {
	}

	// 메소드
	public void turnOnOff() {
		System.out.println("turnOnOff() Method");
	}
	
}
