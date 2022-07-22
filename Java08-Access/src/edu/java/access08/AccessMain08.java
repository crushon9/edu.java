package edu.java.access08;

import java.util.Scanner;

// * Java Runtime Environment(JRE)
// - Java 애플리케이션을 생성하고 실행하기 위한 구성요소
// - JRE는 Java 개발 도구(Java Development Kit, JDK)의 일부
// - 운영체제와 Java 프로그램 사이에서 조정 역할을 수행

// * JVM(Java Virtual Machine)
// - Java 바이트 코드를 실행하는 주체(소프트웨어)
// - 특정 공간을 할당하여 메모리를 관리

// * JVM이 관리하는 메모리 영역:
// - Stack(스택) : 지역 변수들이 저장되는 메모리 영역
// - Heap(힙) : 인스턴스(참조 자료형)가 저장되는 메모리 영역
// - Method(메소드) : static으로 선언한 변수, 메소드의 실행 코드들이 저장되는 메모리 영역

// * final 제한자
// - 초기화된 값을 바꿀 수 없음. (final : 최종적인, 변경할 수 없는)
// - final + 멤버변수, 지역변수 : 상수(한 번 초기화된 값을 변경할 수 없는 변수)
// - final + 메소드 : override 할 수 없는 메소드
// - final + 클래스 : 상속을 허용하지 않는 클래스


public class AccessMain08 {
	public static int x = 0;
	public static final int MENU_INSERT = 1; // (static final은 관습적으로 대문자하고 단어구분시 _)
	public static final int MENU_DELETE = 2;
	public static int test = 100; //
	public int test2 = 1; // static으로 선언하지 않으면 static 메소드 안에서 쓸 수가 없음

	public static void main(String[] args) {
		// 멤버변수 : 클래스 단계에서 선언된 변수
		// 지역변수 : 메소드나 특정 위치에 포함된 곳에서 선언된 변수 ({ } 기준으로 영역이 나뉨)
		// - 지역변수의 이름은 멤버변수와 동일하게 선언되면 안됨
		int x = 10;
		final int y = 10; 
//		System.out.println(this.x); 지역변수와 멤버변수 이름 같을 때 this로 구분하는데, static은 인스턴스화되지 않으니깐 this로 나타낼수가 없음. 
		// 그럼 static없는 메인함수도 있을수있나? ㄴㄴ
		
		x = 123; // 일반적인 지역변수는 초기화 이후에도 언젠든지 값 변경 가능
//		y = 123; // final 지역변수는 처음 초기화된 값을 변경할 수 없음
		
		System.out.println("1.등록. 2.삭제.");
		System.out.println("메뉴선택>");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		switch (select) {
		case MENU_INSERT:
			System.out.println("오예");
			break;
		case MENU_DELETE:
			System.out.println("ㅠㅠ");
			break;
		default:
			break;
		}
		sc.close();
		

	}

}
