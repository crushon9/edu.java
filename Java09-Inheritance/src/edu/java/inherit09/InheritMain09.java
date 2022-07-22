package edu.java.inherit09;

import edu.java.inherit10.Test3;
import edu.java.inherit10.Test4;

public class InheritMain09 {

	public static void main(String[] args) {
		System.out.println("== Test1 class ==");
		Test1 t1 = new Test1();
//		t1.privateInt = 0; // 자기자신클래스만
		t1.packageInt = 0; // 같은패키지
		t1.protectedInt = 0; // 같은패키지 + 상속받은클래스
		t1.publicInt = 0; // 어디든지
		t1.display();

		System.out.println("== Test2 class ==");
		Test2 t2 = new Test2();
//		t2.privateInt = 0; // 자기자신클래스만
		t2.packageInt = 0; // 같은패키지
		t2.protectedInt = 0; // 같은패키지 + 상속받은클래스
		t2.publicInt = 0; // 어디든지
		t2.display();

		System.out.println("== Test3 class ==");
		Test3 t3 = new Test3();
//		t3.privateInt = 0; // 자기자신클래스만
//		t3.packageInt = 0; // 같은패키지
		t3.protectedInt = 0; // 같은패키지 + 상속받은클래스
		t3.publicInt = 0; // 어디든지
		t3.display();
		
		
//		====== 혼자 테스트 ==========
//		Test1 할머니 - Test2 엄마 - Test3 자식 
//				   - Test4 이모
		Test4 t4 = new Test4();
		System.out.println((Test1) t2); // 부모자식관계 형변환가능
		System.out.println((Test1) t3); // 할머니손자관계 형변환가능
//		System.out.println((Test2) t4); // 형제관계 형변환불가
		// 모든 클래스는 Object의 자식이니깐 Object 로 형변환 가능하겠네?
		System.out.println((Object) t2);
		System.out.println((Object) t3);
		
	}
}
