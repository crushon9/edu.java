package edu.java.collection02;

import java.util.ArrayList;

class Student {
	private int StuNo;
	private String name;

	public Student(int stuNo, String name) {
		super();
		StuNo = stuNo;
		this.name = name;
	}

	public int getStuNo() {
		return StuNo;
	}

	public void setStuNo(int stuNo) {
		StuNo = stuNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [StuNo=" + StuNo + ", name=" + name + "]";
	}

}

public class ListMain02 {

	public static void main(String[] args) {
		Student[] list1 = new Student[3];

		// Student 타입을 저장할 수 있는 ArrayList인스턴스 생성
		ArrayList<Student> list2 = new ArrayList<>();

		Student stu1 = new Student(1, "kim");
		list2.add(stu1);
		list2.add(new Student(2, "park"));

		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i)); // 객체하나씩 접근
			System.out.println(list2.get(i).toString()); // 위와 동일
		}

	}

}
