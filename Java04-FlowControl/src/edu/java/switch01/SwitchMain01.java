package edu.java.switch01;

import java.util.Scanner;

// switch - case 문
// - if문과 비슷하지만 비교값을 정형화하는 방식
// - 변수와 일치하는 값에 따라 해당 case문이 실행됨 (조건==연산만 가능)
// switch (변수) {
//	case 값1 :
//		코드
//		break;
//	case 값2 :
//		코드
//		break;
//	default :
//		코드
//		break;
// }

// **case가 선택된순간 다른 case는 꺼지고 다음 break를 만나기 전까지의 코드가 실행된다
// 아래의 경우 2일때 case 3은 꺼지고 다음 코드가 실행되고 break된다
// case 1:
// case 2:
// case 3:
//		코드;
//		break;

public class SwitchMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		// if문
		System.out.println("if - else 문");
		if (a == 1) {
			System.out.println("1번 선택");
		} else if (a == 2) {
			System.out.println("2번 선택");
		} else {
			System.out.println("그 외 선택");
		}

		// switch문
		System.out.println("switch문");
		switch (a) {
		case 1:
			System.out.println("1번 선택");
			break;
		case 2:
			System.out.println("2번 선택");
			break;
		default:
			System.out.println("그 외 선택");
			break;
		}

		sc.close();
	}

}
