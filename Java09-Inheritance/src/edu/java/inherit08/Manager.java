package edu.java.inherit08;

public class Manager extends Employee {
	private String type;

	public Manager() {
	}

	public Manager(String name, String type) {
		super(name);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	public void test() {
		System.out.println("test 자식 매니저");
	}

}
