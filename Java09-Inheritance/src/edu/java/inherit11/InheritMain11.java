package edu.java.inherit11;

// final : 최종적인, 변경할 수 없는
// - final 멤버변수/지역변수 : 상수(한번 초기화된 값을 변경할 수 없는 변수)
// - final 메소드 : override 할 수 없는 메소드 (overloading은 가능)
// - final 클래스 : 상속을 허용하지 않는 클래스

class SuperClass {
	public void test() {
		System.out.println("test");
	}

	public final void testFinal() {
		System.out.println("testFinal");
	}
	
	public void testFinal(int overloading) {
		System.out.println("testFinal_overloading");
	}	
}

class SubClass extends SuperClass{
	@Override
	public void test() {
	}
	
	// testFinal() : final 로 선언된 메소드는 override 불가능
}

public class InheritMain11 {

	public static void main(String[] args) {

	}

}
