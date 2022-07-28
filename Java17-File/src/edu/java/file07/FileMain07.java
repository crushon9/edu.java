package edu.java.file07;

import java.io.File;

// File 클래스 :
// 파일(txt, doc, mp4, jpg, png, ...) 객체와 디렉토리 객체를 다루기 위한 클래스

// File 클래스의 인스턴스 생성 : new File();
// 메모리(힙)에 File클래스의 인스턴스를 생성한다는 의미
// 실제 하드디스크에 있는 물리적인 파일/디렉토리를 생성하는 것은 아님
// 실제 파일/디렉토리를 만들기 위해서는 File클래스의 메소드(create..)를 호출해야함

// 파일(디렉토리)의 경로 : 절대경로, 상대경로
// 절대경로 : 루트(C:\, D:\)부터 파일(폴더)의 위치까지 전체 이름
// 상대경로 : 현재 작업 디렉토리를 기준으로 파일(폳더)가 어디에 있는지 표시 (. 현재디렉토리 / .. 상위디렉토리)

// 파일구분자(file separator) - 운영체제(OS)마다 다르게 사용
// Windows : \
// Unix, Linux, Android ... : /
// 따라서 자바에서는 File.separator 라는 변수를 제공

public class FileMain07 {

	public static final String TEST_DIR1 = "C:\\test1"; // \하나는 escape
	public static final String TEST_DIR2 = "test2";
	public static final String TEST_DIR3 = "C:" + File.separator + "Study" + File.separator + "test3";

	public static void main(String[] args) {
		System.out.println(TEST_DIR1);
		System.out.println(TEST_DIR2);
		System.out.println(TEST_DIR3);

		File f = new File(TEST_DIR3); // 파일, 디렉토리를 다루기 위한 객체
		// exists() : 파일, 폴더가 존재하는지 boolean값 리턴
		if (!f.exists()) { // 존재하지 않는 경우
			System.out.println("폴더가 없습니다");
			// mkdir() : 디렉토리를 1개만 생성하는 메소드. 성공여부를 boolean값 리턴
			// mkdirs() : 상위디렉토리를 포함하여 한번에 생성하는 메소드. 성공여부를 boolean값 리턴
			if (f.mkdirs()) {
				System.out.println("폴더생성 성공");
			} else {
				System.out.println("폴더생성 실패");
			}

		} else {
			System.out.println("폴더가 이미 존재합니다");
		}

	}

}
