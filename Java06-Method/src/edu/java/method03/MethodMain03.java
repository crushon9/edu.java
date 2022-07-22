package edu.java.method03;

import java.util.Scanner;

public class MethodMain03 {

	public static void main(String[] args) {
//	1. 국어, 영어, 수학 점수를 입력받아서 3개의 변수에 저장
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요>");
		int kor = sc.nextInt();
		System.out.println("영어 점수를 입력하세요>");
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력하세요>");
		int math = sc.nextInt();
//	2. 입력받은 점수를 출력
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
//	3. 함수를 정의하여 세 과목의 총점을 출력
		System.out.println("총점 : " + calcTotal(kor, eng, math));
//	4. 함수를 정의하여 세 과목의 평균을 출력(소수점까지 출력)
		System.out.println("평균 : " + calcAverage(kor, eng, math));
//	5. 함수를 정의하여 평균에 따른 등급을 출력
		System.out.println("평균등급 : " + selectGrade(calcAverage(kor, eng, math)));

		sc.close();
	} // end main()

	// 총점을 리턴하는 함수
//parameter와 argument가 같은 의미일때 이름을 동일하게 하면 나중에 찾기쉽고 자동완성도됨..
	public static int calcTotal(int kor, int eng, int math) {
		return kor + eng + math;
	}

	// 평균을 리턴하는 함수
	public static double calcAverage(int kor, int eng, int math) {
		return (double) (calcTotal(kor, eng, math)) / 3;
	}

	// 등급을 리턴하는 함수
	public static char selectGrade(double x) {
		char grade;
		if (x >= 90) {
			grade = 'A';
		} else if (x >= 80) {
			grade = 'B';
		} else if (x >= 70) {
			grade = 'C';
		} else {
			grade = 'F';
		}
		return grade;
	}
	

}// end MethodMain03
