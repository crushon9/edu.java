package edu.java.file08;

import java.io.*;

public class FileMain08 {

	public static final String DIR_NAME = "test1";
	public static final String FILE_NAME = "dummy.txt";
	public static final String FILE_PATH = DIR_NAME + File.separator + FILE_NAME;

	public static void main(String[] args) {
		System.out.println(FILE_PATH);

		File f = new File(FILE_PATH); // 상대경로. 기준은 현재 프로젝트 (Java17-File)
		//절대경로 C:\Users\goott07\git\edu.java\Java17-File\test1\dummy.txt
		if (!f.exists()) {
			System.out.println("파일이 없습니다");
			// creatNewFile() : 새로운 빈 파일 생성
			try {
				if (f.createNewFile()) { // 파일만 만드는 메소드. 폴더가 없으면 파일생성안됨
					System.out.println("파일생성 성공");
				} else {
					System.out.println("파일생성 실패");
				}
			} catch (IOException e) {
				System.out.println(e.toString());
			}

		} else {
			System.out.println("파일이 이미 존재합니다");
		}

	}
}
