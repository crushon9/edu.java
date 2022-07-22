package edu.java.string05;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringMain05 {

	public static void main(String[] args) {
		System.out.println("정규표현식 연습");
		Scanner sc = new Scanner(System.in);
		
		
		String data = sc.nextLine();
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		// (02|010) 02 또는 010으로 시작
		// \ escape
		// \d{3,4} \d=digit 3~4자리의 숫자
		if (Pattern.matches(regExp, data)) { // matches(regex, input); 순서바뀌면안됨
			System.out.println("정상적인 전화번호 형식");
		} else {
			System.out.println("잘못된 전화번호 형식");
		}

		data = sc.nextLine();
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		// \ escape
		// \w+ : 한개 이상의 알파벳 또는 숫자
		// (\\.\\w+)? : \.\w+ 가 존재할 수도 존재하지 않을 수도 있음
		if (Pattern.matches(regExp, data)) {
			System.out.println("정상적인 이메일 형식");
		} else {
			System.out.println("잘못된 이메일 형식");
		}
		
		
	}
}
