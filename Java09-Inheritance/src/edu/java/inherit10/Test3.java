package edu.java.inherit10;

import edu.java.inherit09.Test2;
// 상속의 상속도 가능하다
public class Test3 extends Test2 {
	@Override
	public void display() {
//		System.out.println("private = " + privateInt);
//		System.out.println("package = " + packageInt);
		System.out.println("protected = " + protectedInt);
		System.out.println("public = " + publicInt);
		
	}
	
	@Override // 할머니 클래스의 메소드도 오버라이드가능하다
	public void testMethod() {
	}
}
