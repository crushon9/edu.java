package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
	// select 번호
	public static final char MENU_QUIT = '0';
	public static final char MENU_ADD = '1';
	public static final char MENU_LIST = '2';
	public static final char MENU_FIND = '3';
	public static final char MENU_EDIT = '4';
	// 연락처 최대 저장 개수 (final이므로 변경불가)
	public static final int MAX = 100;
	// 연락처 저장 배열 (전역변수이므로 어디서든지 배열에 접근가능)
	public static Contact[] contactlist = new Contact[MAX];
	// 배열에 데이터를 저장하면 증가하는 카운트 (전역변수이라서 모두 같은 값 공유)
	public static int count = 0;
	// Scanner 선언
	public static Scanner sc = new Scanner(System.in);

	// main 메소드 시작
	public static void main(String[] args) {
		System.out.println("< 연락처 프로그램 ver 0.1 >");

		boolean run = true;
		while (run) {
			System.out.println();
			System.out.println("-----------------------------------------");
			System.out.println("1.등록 | 2.전체검색 | 3.상세검색 | 4.수정 | 0.종료");
			System.out.println("-----------------------------------------");
			System.out.print("선택>");
			// 메뉴 입력 받기
			char select = inputStrToChar();

			switch (select) {
			case MENU_ADD:
				System.out.println("====== 정보 등록 ======");
				contactlist[count] = new Contact();
				setAll(contactlist[count], count);
				System.out.println("== No." + count + " 이 등록 되었습니다. ==");
				count++;
				break;

			case MENU_LIST:
				System.out.println("====== 전체 검색 ======");
				for (int i = 0; i < count; i++) {
					System.out.println(contactlist[i].toString());
				}
				System.out.println("=== " + count + "개 등록 되어있습니다 ===");
				break;

			case MENU_FIND:
				System.out.println("====== 상세 검색 ======");
				System.out.println("검색할 No를 입력하세요>");
				int find = inputStrToInt();
				if (find >= count) {
					System.out.println("저장되지 않은 No 입니다!!");
					break;
				}
				getAll(contactlist[find]);
				System.out.println("=== No." + find + " 이 검색 되었습니다. ===");
				break;

			case MENU_EDIT:
				System.out.println("====== 정보 수정 ======");
				System.out.println("수정할 No를 입력하세요>");
				int edit = inputStrToInt();
				if (edit >= count) {
					System.out.println("저장되지 않은 No 입니다!!");
					break;
				}
				setAll(contactlist[edit], edit);
				System.out.println("=== No." + edit + " 이 수정 되었습니다. ===");
				break;

			case MENU_QUIT:
				System.out.println("=== 프로그램을 종료합니다. ===");
				run = false;
				break;

			default:
				System.out.println("0 ~ 4번 중에 선택해주세요!");
				break;
			}
		} // while 종료

		sc.close(); // 프로그램이 끝날때 닫는게 편함

	} // end main()

	public static void setAll(Contact c, int index) {
		c.setNo(index);
		System.out.print("이름>");
		c.setName(sc.nextLine());
		System.out.print("전화번호>");
		c.setPhone(sc.nextLine());
		System.out.print("이메일>");
		c.setEmail(sc.nextLine());
	} // end setAll

	public static void getAll(Contact c) {
		System.out.println("이름 : " + c.getName());
		System.out.println("전화번호 : " + c.getPhone());
		System.out.println("이메일 : " + c.getEmail());
	} // end getAll

	public static char inputStrToChar() {
		char result;
		String str = sc.nextLine();
		if (str.length() == 1 && MENU_QUIT <= str.charAt(0) && str.charAt(0) <= MENU_EDIT) {
			result = str.charAt(0);
		} else {
			result = MENU_EDIT + 1;
		}
		return (char) result;
	} // end inputStrToChar

	public static int inputStrToInt() {
		int result;
		String str = sc.nextLine();
		if (str.length() == 1 && '0' <= str.charAt(0) && str.charAt(0) <= '9') {
			result = str.charAt(0) - '0';
		} else if (str.length() == 2 && '0' <= str.charAt(0) && str.charAt(0) <= '9' && '0' <= str.charAt(1)
				&& str.charAt(1) <= '9') {
			result = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
		} else {
			result = MAX + 1;
		}
		return (int) result;
	} // end inputStrToInt

}// end class
