package edu.java.array11;

import java.util.Scanner;

public class StudentScore {

	public static void main(String[] args) {
		System.out.println("<학생 점수 관리 프로그램>");

//		변수 명명 규칙
//		1. 첫 번재 글자는 문자이거나, '$' '_' 이어야 하고 숫자로 시작할 수 없다(필수)
//		2. 영어 대소문자가 구분된다(필수) // n과 N
//		3. 첫 문자는 영어 소문자로 시작하되, 다른 단어가 붙을 경우 첫 문자를 대문자로 한다(관례) // studentScore
//		4. 문자 길이의 제한은 없다
//		5. 자바 예약어(int, public, new, true, if 등) 는 사용할 수 없다(필수) // 다른문자와함께쓰면가능 int1
		Scanner sc = new Scanner(System.in);

		int stuNo = 0; // 학생 수
		int[] stuScores = null; // 학생 점수를 저장할 배열. null은 값이 없음을 의미

		boolean run = true;
		int count = 0;
		while (run) {
			System.out.println("---------------------------------------------");
			System.out.println("1.학생 수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.println("선택>");
			int selectNo = sc.nextInt();

			switch (selectNo) {
			case 1: // 학생 수 입력
				System.out.println("학생 수를 입력하세요>");
				stuNo = sc.nextInt();
				stuScores = new int[stuNo];
//				int[] stuScores = new int[stuNo]; 여기에 선언하면 case 1에서만 사용가능하니 반복문 바깥에 null로 선언
				System.out.println("입력된 학생 수 : " + stuNo); // 사용자를 생각하자
				break;

			case 2: // 각 학생의 점수 입력
				if (stuScores == null) { // 예외처리
					System.out.print("학생 수를 입력하세요");
					count++;
					for (int i = 0; i < count; i++) {
						System.out.print("!");
					}
					System.out.println();
					break;
				}
				for (int i = 0; i < stuScores.length; i++) {
					System.out.println(i + "번 학생의 점수를 입력하세요> ");
					stuScores[i] = sc.nextInt();
				}
				System.out.println("저장 되었습니다");
				break;

			case 3: // 점수 리스트
				if (stuScores == null) {
					System.out.print("학생 수를 입력하세요");
					count++;
					for (int i = 0; i < count; i++) {
						System.out.print("!");
					}
					System.out.println();
					break;
				}
				for (int i = 0; i < stuScores.length; i++) {
					System.out.println(i + "번 학생의 점수 : " + stuScores[i]);
				}
				System.out.println("저장 되었습니다");
				break;

			case 4: // 합계, 평균 출력
				if (stuScores == null) {
					System.out.print("학생 수를 입력하세요");
					count++;
					for (int i = 0; i < count; i++) {
						System.out.print("!");
					}
					System.out.println();
					break;
				}
				int sum = 0;
				for (int i = 0; i < stuScores.length; i++) {
					sum += stuScores[i];
				}
				System.out.println("점수 합계 = " + sum);
				System.out.println("점수 평균 = " + (double) (sum / stuScores.length));
				break;

			case 5:
				System.out.println("프로그램을 종료합니다");
				run = false;
				break;

			default:
				System.out.println("1 ~ 5번 중에 선택해주세요.");
				break;
			}

		}
		sc.close();
	} // end main()
} // end StudentScore
