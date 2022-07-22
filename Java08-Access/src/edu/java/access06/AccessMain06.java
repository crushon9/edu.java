package edu.java.access06;

import edu.java.access05.TestPublic;

public class AccessMain06 {

	public static void main(String[] args) {
		// 다른 패키지에 있는 public class의 인스턴스 생성 가능 (import 필요)
		// import edu.java.access05.TestPublic;
		TestPublic test1 = new TestPublic();

		// 다른 패키지에 있는 (package) class의 인스턴스 생성 불가
//		TestPackage test2 = new TestPackage();

	}

}
