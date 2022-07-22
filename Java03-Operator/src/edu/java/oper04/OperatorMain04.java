package edu.java.oper04;

// 비교 연산자
// - 두 값을 범위적으로 비교할 때 사용
// - 연산 결과로 true, false를 리턴
// - < > <= >= == !=

// 논리 연산자
// - boolean 타입의 변수를 사용하여 연산
// - A && B : AND(논리곱) 연산
// 			  A 와 B 모두 true일 때만 true, 나머지는 false
// - A || B : OR(논리합) 연산
//  		  A 또는 B가 true이면 true, A와 B 모두 false일 때는 false 
// - !A : NOT(논리 부정) 연산
//		  A가 true이면 false, A가 false이면 true

public class OperatorMain04 {

	public static void main(String[] args) {
		System.out.println("비교 연산자");
		
		System.out.println(10 > 20); // 10이 20보다 큰가? false
		System.out.println(123 != 100); // 123이 100과 다른가? true
		
		System.out.println("논리 연산자");
		boolean t = true;
		boolean f = false;
		System.out.println(t && f);
		System.out.println(t || f);
		System.out.println(!f);
		
		System.out.println((10 > 0) && (10 < 100));
		System.out.println(10 > 0 && 10 < 100);
		System.out.println(10 > 0 || 10 < 100); 
									// Dead code : 앞이 true니깐 뒤는 보지도않음 Lazy Evaluation
		
	}
}