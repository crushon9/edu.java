package edu.java.homework;

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private int math;
	private int eng;

	public Student(String name, int math, int eng) {
		this.name = name;
		this.math = math;
		this.eng = eng;
	}

	public void displayInfo() {
		System.out.println("이름 : " + name);
		System.out.println("수학 : " + math);
		System.out.println("영어 : " + eng);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", math=" + math + ", eng=" + eng + "]";
	}
	
}
