package edu.java.inherit01;

// BasicTv : 상위클래스(super class), 부모클래스(parent class), 기본클래스(base class)
// SmartTv : 하위클래스(sub class), 자식클래스(child class), 유도클래스(derived class)
public class InheritMain01 {

	public static void main(String[] args) {
		// 자식 SmartTv 클래스의 인스턴스 생성
		SmartTv tv1 = new SmartTv();
		tv1.powerOn = true; // 자식클래스는 부모클래스의 변수 접근가능
		tv1.turnOnOff(); // 자식클래스는 부모클래스의 메소드 사용가능
		tv1.setIp("172.16.7.31");
//		tv1.equals(); // 모든 클래스는 java.lang.Object 라는 내장 클래스를 상속받음

		// 부모 BasicTv 클래스의 인스턴스 생성
		BasicTv tv2 = new BasicTv();
//		tv2.setIp(""); // 부모클래스는 자식클래스의 메소드 및 변수 사용불가 (불효자)

		
		
		
	} // end main()

} // end InheritMain01
