package edu.java.interface01;

import java.util.Scanner;

// 인터페이스(Interface)
//1. 인터페이스의 모든 메소드는 public abstract 로 선언 (Java 8부터는 default,static 메소드 추가)
//		-> public abstract 수식어 생략 가능 
//2. 인터페이스의 모든 멤버변수는 public static final 로 선언
//		-> public static final 수식어 생략 가능
//3. 인터페이스를 선언할 때는 interface 키워드 사용
//4. 인터페이스를 구현(상속)하는 '클래스'는 implements 키워드 사용 (상속과 같은 능력이고, 클래스만가능)
//5. 클래스는 다중 상속이 불가능 : class Child extends Parent1, Parent2 (X)
//6. 인터페이스를 구현하는 개수는 제한이 없음 : class Child implements Inter1, Inter2 (O)

public class InterfaceMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력>");
		String id = sc.next();
		System.out.println("비밀번호 입력>");
		String pw = sc.next();

		DataBaseQuery db = new OracleDatabaseQuery(); // 인터페이스도 다형성 가능
		int result = db.insert(id, pw);
		if(result>0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert failure");
		}

		sc.close();
	}

}
