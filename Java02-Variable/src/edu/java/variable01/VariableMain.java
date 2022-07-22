package edu.java.variable01;

public class VariableMain {
	
	// 주석
	// 프로그램 시작점 : main() 메소드
	public static void main(String[] args) {
		// println() : 데이터를 console 창에 보여주는 함수
		System.out.println("변수(Variable)");
		// Ctrl + Space : 자동완성 단축키
		System.out.println();
		// Ctrl + F11 : 자동실행 단축키
		
		int x = 10; // 변수 x에 10을 저장
		System.out.println("x = " + x); // x의 값을 출력
		
		int y; // 변수 선언
		y = 20; // 변수 초기화(값을 저장)
 		System.out.println("y = " + y); // y의 값을 출력
		
 		// Ctrl + Space 해당커서위치에서 선언되어있는 변수 목록 확인
 		x = 12; // 이미 선언된 변수의 값을 변경
 		System.out.println("x = " + x);
 		x = 12 + y; // 다른 변수를 연산할 수 있음
 		System.out.println("x = " + x);
 		y = 10;
 		System.out.println("y = " + y);
 		
	} // end main()

} // end VariableMain