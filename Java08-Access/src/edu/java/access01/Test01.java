package edu.java.access01;

public class Test01 {
	// 멤버 변수
	private int private1; // 클래스 내부에서 사용
	int package2; // (package) 내부에서 사용
	protected int protected3; // 같은 패키지 혹은 상속받은 클래스들에서 사용
	public int public4; // 어디서든지 사용

	// 메소드
	public void display() {
		System.out.println("private1 = " + private1);
		System.out.println("package1 = " + package2);
		System.out.println("protected3 = " + protected3);
		System.out.println("public4 = " + public4);
	}
}
