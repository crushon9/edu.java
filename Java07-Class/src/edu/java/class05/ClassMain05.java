package edu.java.class05;

import java.util.Scanner;

public class ClassMain05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		String password = sc.nextLine();
		
System.out.println(System.identityHashCode(id)); // new Scanner를 통해 heap에 입력받은 id의 암호화된 주소값 출력
System.out.println(System.identityHashCode("test")); // test 리터럴 주소값 출력

		Member member = new Member();
		boolean result = member.login(id, password); // 값 자체가 아니라 주소값 전송

		if (result) {
			System.out.println("로그인 되었습니다");
		} else {
			System.out.println("id 또는 password가 일치하지 않습니다");
		}
		
		sc.close();
	}
}
