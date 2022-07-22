package edu.java.inherit09;

public class Test2 extends Test1 {
	@Override
	public void display() {
		// 부모변수는 메소드안에서 사용가능하다 (바깥필드에서 사용불가)
//		System.out.println("private = " + privateInt);
		System.out.println("package = " + packageInt);
		System.out.println("protected = " + protectedInt);
		System.out.println("public = " + publicInt);
	}
}
