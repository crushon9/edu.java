package edu.java.access02;

import java.util.Scanner;

import edu.java.access01.Test01;

public class AccessMain02 {

	public static void main(String[] args) {
		// Crtl + Shift + o : 자동 import
		Scanner sc = new Scanner(System.in);
		Test01 t1 = new Test01(); // 다른 패키지일때는 import 해야함
		Test02 t2 = new Test02(); // 같은 패키지일때는 import 없음
//		Student stu1 = new Student(); 다른 프로젝트는 import 불가
		
//		t1.private1 = 100; // private : 다른 클래스이므로 직접 접근 불가
//		t1.package2 = 200; // (package) : 다른 패키지에 있으므로 직접 접근 불가
//		t1.protected3 = 300; // protected : 다른 패키지고, 상속받지 않았으므로 직접 접근 불가
		t1.public4 = 400; //public : 어디서든지 직접 접근 가능
		t1.display(); // 메소드를 통한 우회 접근
		
		sc.close();
	}

}
