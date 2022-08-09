package edu.java.file06;

import java.io.*;
import java.util.ArrayList;

import edu.java.file04.MemberVo;

// 프로그램 ===> ObjectOutputStream ===> BufferedOutputStream ===> FileOutputStream ===> 파일(HDD)
// Buffered 는 두 사이에 속도 조절을 해주는 역할

public class FileMain06 {

	public static void main(String[] args) {
		System.out.println("ArrayList<Member> 객체를 파일에 저장하고 읽어오는 코드");

		/* 데이터를 ArrayList에 저장하는 코드 */
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
			out = new FileOutputStream("temp/list.txt"); // 다형성 가능
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);

			long startTime = System.currentTimeMillis();
			// list 에 데이터 추가
			ArrayList<MemberVo> list = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				String id = "member" + i;
				String pw = "pw" + i;
				MemberVo m = new MemberVo(i, id, pw);
				list.add(m);
			}
			// 스트림을 통해 최종적으로 파일로 출력
			oout.writeObject(list);
			System.out.println("데이터 저장 완료");
			long endTime = System.currentTimeMillis();
			System.out.println("경과시간" + (endTime - startTime));

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/* 데이터 파일을 읽어서 ArrayList의 내용을 출력 */
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;

		try {
			in = new FileInputStream("temp/list.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			// 읽어올 데이터를 담을 list 그릇 준비. 형변환
			ArrayList<MemberVo> list = (ArrayList<MemberVo>) oin.readObject();
			// list에 저장된 데이터를 출력하며 확인
			for (MemberVo x : list) {
				System.out.println(x);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
