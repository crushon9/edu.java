package edu.java.oper03;

// 증감 연산자
// 변수의 값을 1 증가 또는 감소할 때 사용하는 연산자
// 변수의 앞(prefix)과 뒤(suffix)에 사용
// ++ , --

public class OparatorMain03 {

	public static void main(String[] args) {
		System.out.println("증감 연산자(++, --)");
		
		int num1 = 100;
		num1++;
		System.out.println("num1 = " + num1);
		
		int num2 = 100;
		++num2;
		System.out.println("num2 = " + num2);
		
		int num3 = 100;
		int result = ++num3 + 5; // num3 = 101이 되고, +5를 실행
		System.out.println("num3 = " + num3);
		System.out.println("result = " + result);
		
		int num4 = 100;
		result = num4++ + 5; 
		// num4(100) + 5가 먼저 실행되고, result에 값을 저장한 뒤
		// num4를 1 증가시켜서 num4 =101이 저장됨
		System.out.println("num4 = " + num4);
		System.out.println("result = " + result);
		
		// 증감 연산자는 변수 앞 또는 변수 뒤에 사용할 수 있음
		// 증감 연산자가 단독으로 사용되는 경우는 앞과 뒤가 모두 동일한 결과
		//		x++; 와 --x; 는 동일한 효과 (연산없이 단독으로 사용할 경우)
		// 증감 연산자가 다른 연산자와 함께 사용되는 경우는
		// 앞은 다른 연산자보다 먼저 계산되고
		// 뒤는 다른 연산자보다 나중에 계산됨
		
		// Quiz 핵심! 섞어쓰면 복잡하니깐 x++만 쓰자
		int x = 10;
		result = x++ + 5 + ++x;
		// 계산 순서
		// 1. x++ + 5
		//		(1) x + 5 ==> 10 + 5 == > 15
		//		(2) x 증가 ==> x = 11
		// 2. 15 + ++x
		//		(2) x 증가 ==> x = 12
		//		(1) 15 + 12 = 27
		// 3. result = 27
		
	} // end main()
} // end OperatorMain03