package edu.java.file02;
// 근데 어떻게 read()가 while 다음 횟수때 다음 데이터를 알아서 가져와???

import java.io.*;

// 프로그램 <=== FileInputStream <=== 파일
// FileInputStream 클래스의 read() 메소드를 사용하여 파일을 읽음
// 프로그램 ===> FileOutputStream ===> 파일
// FileOutputStream 클래스의 write() 메소드를 사용하여 파일을 씀

public class FileMain02 {

	public static void main(String[] args) {
		// temp/original.txt 파일에서 데이터를 읽어서
		// temp/copy.txt 파일에서 데이터를 씀
		InputStream in = null;
		OutputStream out = null;

		try { // 오류가 날수있기 때문에 무조건 예외처리하도록 되어있음
				// 파일에서 데이터를 읽어올 통로인 FileInputStream 객체 생성
			in = new FileInputStream("temp/original.txt");
			// 파일에서 데이터를 쓸 통로인 FileInputStream 객체 생성
			out = new FileOutputStream("temp/copy.txt");

			int data = 0; // data = read() 메소드가 리턴하는 값을 저장할 변수
			int byteCopied = 0; // write() 메소드를 호출할 때마다 1씩 증가
			while (true) {
				// read() : 파일에서 1바이트씩 데이터를 읽어옴
				// 파일끝에 도달했을때 -1 리턴
				data = in.read();
// read 리턴값 the next byte of data, or -1 if the end of thestream is reached.
				System.out.println("옮기는중" + data);
				if (data == -1) {
					break;
				}

				// write() : 1바이트씩 파일에 씀
				out.write(data);
				byteCopied++;
			}
			System.out.println(byteCopied + "바이트 복사됨");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
