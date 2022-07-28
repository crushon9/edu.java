package edu.java.homework;

import java.io.*;

// In-read / Out-write 프로그램입장
// Student stuOut =writeObject()=> ObjectOutputStream oout ==> OutputStream out ==> student.txt
// student.txt ==> InputStream in ==> ObjectInputStream oin =readObject()=> Student stuIn

public class Homework5 {

	public static void main(String[] args) {
		OutputStream out = null;
		ObjectOutputStream oout = null;
		InputStream in = null;
		ObjectInputStream oin = null;

		try {
			out = new FileOutputStream("temp/student.txt");
			oout = new ObjectOutputStream(out);

			Student stuOut = new Student("홍길동", 40, 40);
			oout.writeObject(stuOut);
			System.out.println("내보내기 성공!");

			in = new FileInputStream("temp/student.txt");
			oin = new ObjectInputStream(in);

			while (true) {
				try {
					Student stuIn = (Student) oin.readObject();
					System.out.println("읽어오기 성공!\n" + stuIn);

				} catch (EOFException e) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		} finally {
			try {
				oout.close();
				oin.close();
			} catch (IOException e) {
				e.getMessage();
			}
		}

	}
}
