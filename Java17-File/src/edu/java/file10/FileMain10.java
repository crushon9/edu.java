package edu.java.file10;

import java.io.File;
//window - show view - task 하면 todo 목록이 보임
public class FileMain10 {

	public static void main(String[] args) {
		// 현재 디렉토리(current working directory) 정보 확인
		String cwd = System.getProperty("user.dir");
		System.out.println("CWD : " + cwd);

		// 현재 디렉토리에 대한 File 객체
		File f = new File(cwd);
		// getName() : 파일, 디렉토리의 이름 리턴
		System.out.println("이름 : " + f.getName());
		// getPath() : 경로를 리턴
		// File 객체를 생성할 때
		// 1. 절대경로로 생성했으면, 절대경로로 이름을 리턴
		// 1. 상대경로로 생성했으면, 상대경로로 이름을 리턴
		System.out.println("경로 : " + f.getPath());
		// getAbsolutePath() : 절대 경로를 리턴
		System.out.println("절대 경로 : " + f.getAbsolutePath());
		// isDirectory() : File 객체가 디렉토리이면 true를 리턴
		// isFile() : File 객체가 파일이면 true를 리턴
		System.out.println("디렉토리? : " + f.isDirectory());
		System.out.println("파일? : " + f.isFile());

		// listFiles() : 디렉토리의 내용 확인
		File[] list = f.listFiles();
		for (File x : list) {
			System.out.println("\n" + x);
			if (x.isDirectory()) {
				System.out.print("<DIR>\t"); // \t : tap
			} else {
				System.out.print("<FILE>\t");
			}
			System.out.print(x.getName() + "\t");
			System.out.println(x.length() + "Bytes");
		}

	}
}
