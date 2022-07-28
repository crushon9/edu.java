package edu.java.file05;

import java.io.*;

import edu.java.file04.MemberVo;

public class FileMain05 {

	public static void main(String[] args) {
		InputStream in = null;
		ObjectInputStream oin = null;

		try {
			in = new FileInputStream("temp/member.txt");
			oin = new ObjectInputStream(in);

			while (true) {
				try {
					MemberVo m = (MemberVo) oin.readObject(); 
					// oin에 있는내용을 읽어와서 새m에 저장, 리턴타입 Object이므로 형변환
					System.out.println(m);
				} catch (EOFException e) { // EndOfFileException
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	} // end main()
} // end FileMain05
