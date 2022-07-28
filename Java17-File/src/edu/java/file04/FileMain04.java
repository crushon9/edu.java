package edu.java.file04;

import java.io.*;

// 프로그램 ===> ObjectOutputStream ===> FileOutputStream ===> 파일(HDD)

public class FileMain04 {

	public static void main(String[] args) {
		OutputStream out = null;
		ObjectOutputStream oout = null;

		try {
			out = new FileOutputStream("temp/member.txt"); // 다형성인가?
			oout = new ObjectOutputStream(out); // 내보내다(도착지)

			MemberVo m1 = new MemberVo(1, "root1", "root123");
			oout.writeObject(m1); // 내보내다.써서(이내용을)
			MemberVo m2 = new MemberVo(2, "root2", "root123");
			oout.writeObject(m2);
			MemberVo m3 = new MemberVo(3, "root3", "root123");
			oout.writeObject(m3);

			System.out.println("파일저장성공");

		} catch (Exception e) {
			System.out.println("예외발생 : " + e.toString());
// java.io.NotSerializableException: edu.java.file04.MemberVo
		} finally {
			try {
				// 리소스를 해제할 때는 최종적으로 생성된 리소스(oout)만 해제하면
				// 그 리소스가 사용하고 잇는 다른 리소스들(out)도 순차적으로 해제됨
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
