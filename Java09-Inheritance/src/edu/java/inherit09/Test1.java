package edu.java.inherit09;

public class Test1 {
	private int privateInt;
	int packageInt;
	protected int protectedInt;
	public int publicInt;

	public void display() {
		System.out.println("private = " + privateInt);
		System.out.println("package = " + packageInt);
		System.out.println("protected = " + protectedInt);
		System.out.println("public = " + publicInt);
	}
	
	public void testMethod() {
	}

}
