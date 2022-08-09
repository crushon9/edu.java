package edu.java.file03;

import java.io.*;

/* [리소스 예외처리]
 * 1. try-catch-finally 구문 (일반적인)
 * 리소스 변수 = null; // 바깥 블록에 널 선언
 * try {
 * 		new 인스턴스 생성
 * } catch (Exception e) {
 * 		예외처리
 * } finally {
 * 		try { // 다시 예외처리해줘야함
 *				in.close(); 
 *			} catch (IOException e) {
 *				e.printStackTrace();
 *			}
 * }
 * 2.  try-catch-resource 구문 (Java7부터 제공)
 * : try( )안에서 생성된 리소스들의 해제 코드(close();)를 자동으로 호출해줌
 * try (리소스생성) {
 * 	실행문
 * } catch (Exception e) {
 * 	예외처리
 * }
 */

public class FileMain03 {
	public static void main(String[] args) {

		try (InputStream in = new FileInputStream("temp/big_text.txt");
				OutputStream out = new FileOutputStream("temp/big_text2.txt");) {
			int byteCopied = 0;
			long startTime = System.currentTimeMillis();
			while (true) {
				// 1KB = 1024Byte
				// 4KB = 4 * 1024Byte
				// 1MB = 1024 * 1024Byte
				byte[] buffer = new byte[1024 * 1024]; // 1MB길이의 byte타입 배열생성
				int len = in.read(buffer); // 생성한 배열을 read로 넣으면 길이를 리턴
//the total number of bytes read into the buffer, or -1 if there is no more data because the end ofthe stream has been reached.
				System.out.println(len);
				// read(byte[] b) :
				// 피일에서 읽은 데이터를 매개변수 배열 b에 저장
				// 실제로 읽은 바이트 수를 리턴, 파일 끝에서는 -1을 리턴

				if (len == -1) {// 완료되면 read메소드가 -1을 리턴
					break;
				}
				out.write(buffer, 0, len);
				// write(byte[] b) :
				// 매개변수 배열 b의 내용을 한번에 파일에 씀
				// write(byte[] b, int off, int len) :
				// 배열 b의 인덱스 off번째부터 len 길이 만큼까지만 파일에 씀

				byteCopied += len;
			}
			long endTime = System.currentTimeMillis();
			System.out.println("복사 경과 시간 : " + (endTime - startTime));
			System.out.println(byteCopied + "바이트 복사됨");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
