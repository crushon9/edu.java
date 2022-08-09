package edu.java.homework;

import java.io.*;
import java.util.Scanner;

// In-read / Out-write 프로그램입장
// Student stuOut ==writeObject()==> ObjectOutputStream oout ===> OutputStream out ===> student.txt
// student.txt ===> InputStream in ===> ObjectInputStream oin ==readObject()==> Student stuIn

public class Homework5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OutputStream out = null;
		ObjectOutputStream oout = null;
		InputStream in = null;
		ObjectInputStream oin = null;

		try {
			out = new FileOutputStream("temp/student.txt");
			oout = new ObjectOutputStream(out);

			for (int i = 0; i < 3; i++) {
				System.out.println("이름입력>");
				String name = sc.next();
				System.out.println("수학점수입력>");
				int math = sc.nextInt();
				System.out.println("영어점수입력>");
				int eng = sc.nextInt();

				Student stuOut = new Student(name, math, eng);
				oout.writeObject(stuOut);
			}
			System.out.println("내보내기 성공!");

			in = new FileInputStream("temp/student.txt");
			oin = new ObjectInputStream(in);

			while (true) {
				try {
					Student stuIn = (Student) oin.readObject();
					System.out.println(stuIn);
				} catch (EOFException e) {
					break;
				}
			}
			System.out.println("읽어오기 성공!");
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		} finally {
			try {
				oout.close();
				oin.close();
				sc.close();
			} catch (IOException e) {
				e.getMessage();
			}
		}

	}
}
