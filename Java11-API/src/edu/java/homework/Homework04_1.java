package edu.java.homework;

public class Homework04_1 {

	public static void main(String[] args) {
		String str = "사과:배:바나나:복숭아";
		String[] result = str.split(":");
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			buff.append(result[i]);
		}
		System.out.println(buff);

	}

}
