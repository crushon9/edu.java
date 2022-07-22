package edu.java.inherit09;

public class Test1 {
	private int privateInt;
	int packageInt;
	protected int protectedInt;
	public int publicInt;

	public void display() {
		System.out.println("1private = " + privateInt);
		System.out.println("1package = " + packageInt);
		System.out.println("1protected = " + protectedInt);
		System.out.println("1public = " + publicInt);
	}
	
	public void testMethod() {
	}

}
