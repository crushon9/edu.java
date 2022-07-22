package edu.java.inherit08;

public class Employee {
	private String name;

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void test() {
		System.out.println("test 부모 직원");
	}

}
