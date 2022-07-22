package edu.java.contact02;

import java.util.Scanner;

public class ContactMain02 {
	private static Scanner sc = new Scanner(System.in);
	private static ContactDAOImple dao = new ContactDAOImple();

	public static void main(String[] args) {
		System.out.println("< 연락처 프로그램 Ver 0.2 >");

		boolean run = true;
		while (run) {
			showMainMenu();
			int choice = sc.nextInt();

			switch (choice) {
			case Menu.INSERT:
				insertContact();
				break;

			case Menu.SELECT_ALL:
				selectAll();
				break;

			case Menu.SELECT_BY_INDEX:
				selectByIndex();
				break;

			case Menu.UPDATE:
				updateContact();
				break;

			case Menu.QUIT:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;

			default:
				System.out.println("0 ~ 4번 중에 선택해주세요!");
				break;
			}
		} // while 종료

		sc.close();

	} // end main()

	private static void showMainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println("1.등록 | 2.전체검색 | 3.상세검색 | 4.수정 | 0.종료");
		System.out.println("-----------------------------------------");
		System.out.println("선택>");
		while (!sc.hasNextInt()) {
			sc.next();
			System.err.println("숫자만 입력해주세요!");
			showMainMenu();
		}
	} // end showMainMenu()

	private static void insertContact() {
		System.out.println("=============== 정보 등록 ===============");
		System.out.print("아이디 입력>");
		String name = sc.next();
		System.out.print("비밀번호 입력>");
		String phone = sc.next();
		System.out.print("이메일 입력>");
		String email = sc.next();

		ContactVO vo = new ContactVO(name, phone, email); // 입력받은정보를 ContactVO 인스턴스를 새로 생성하며 넘겨줌
		int result = dao.insert(vo); // insert를구현한 ContactDAOimple로 정보가담긴인스턴스참조변수vo를 통째로넘겨주며 성공여부를 int로 반환
		if (result == 1) {
			System.out.println("저장성공!");
		} else {
			System.out.println("저장실패!");
		}
	} // end insertContact()

	private static void selectAll() {
		System.out.println("=============== 전체 검색 ===============");
		ContactVO[] list = dao.select(); // ContactVO배열임시그릇을만들고, DAO에저장되고있는전체배열을넘긴다
		int count = dao.getCount(); // ContactDAOimple의 private count를 getter로 가져옴
		for (int i = 0; i < count; i++) {
			System.out.print("[No." + i + "] ");
			System.out.println(list[i]); // list[i].toString() 과 같음
		}
		System.out.println("======================================");
	} // end selectAll()

	private static void selectByIndex() {
		System.out.println("=============== 상세 검색 ===============");
		System.out.println("검색할 No를 입력하세요>");
		while (!sc.hasNextInt()) {
			sc.next();
			System.err.println("숫자만 입력해주세요!");
			System.out.println("검색할 No를 입력하세요>");
		}
		int index = sc.nextInt();
		int count = dao.getCount();
		if (index >= 0 && index < count) {
			ContactVO vo = dao.select(index); // 한명의 정보만 가져옴
			System.out.print("[No." + index + "] ");
			System.out.println(vo);
		} else {
			System.out.println("저장되지 않은 No 입니다!!");
		}
		System.out.println("======================================");
	} // end selectByIndex()

	private static void updateContact() {
		System.out.println("=============== 정보 수정 ===============");
		System.out.println("수정할 No를 입력하세요>");
		while (!sc.hasNextInt()) {
			sc.next();
			System.err.println("숫자만 입력해주세요!");
			System.out.println("수정할 No를 입력하세요>");
		}
		int index = sc.nextInt();
		int count = dao.getCount();
		if (index >= 0 && index < count) {
			System.out.print("이름 입력>");
			String name = sc.next();
			System.out.print("연락처 입력>");
			String phone = sc.next();
			System.out.print("이메일 입력>");
			String email = sc.next();
			ContactVO vo = new ContactVO(name, phone, email);
			int result = dao.update(index, vo);
			if (result == 1) {
				System.out.println("[No." + index + "] 수정성공!");
			} else {
				System.out.println("[No." + index + "] 수정실패!");
			}
		} else {
			System.out.println("저장되지 않은 No 입니다!!");
		}
		System.out.println("======================================");
	} // end updateContact

} // end ContactMain class
