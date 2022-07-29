package edu.java.contact04;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactMain03 {
	private static Scanner sc = new Scanner(System.in);
	private static ContactDAO dao;

	public static void main(String[] args) {
		System.out.println("< 연락처 프로그램 Ver 0.4 >");
		dao = ContactDAOImple.getInstance(); // 다형성

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

			case Menu.DELETE:
				deleteContact();
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
		System.out.println("-------------------------------------------------");
		System.out.println("1.등록 | 2.전체검색 | 3.상세검색 | 4.수정 | 5.삭제 | 0.종료");
		System.out.println("-------------------------------------------------");
		System.out.println("선택>");
		while (!sc.hasNextInt()) { // int가 아니라면
			sc.next();
			System.err.println("숫자만 입력해주세요!"); // 에러출력
			showMainMenu();
		}
	} // end showMainMenu()

	private static void insertContact() {
		System.out.println("---------- 정보 등록 ----------");
		System.out.print("아이디 입력>");
		String name = sc.next();
		System.out.print("비밀번호 입력>");
		String phone = sc.next();
		System.out.print("이메일 입력>");
		String email = sc.next();

		ContactVO vo = new ContactVO(name, phone, email); // 입력받은정보를 ContactVO 인스턴스를 새로 생성하며 넘겨줌
		int result = dao.insert(vo); // insert를구현한 ContactDAOimple로 정보가담긴인스턴스참조변수vo를 넘겨주며 성공여부를 int로 반환
		if (result == 1) {
			System.out.println("저장성공!");
		} else {
			System.out.println("저장실패!");
		}
	} // end insertContact()

	private static void selectAll() {
		System.out.println("---------- 전체 검색 ----------");
		ArrayList<ContactVO> list = dao.select(); // 임시그릇을만들고, DAO에저장되고있는 전체list주소를 받음
		for (int i = 0; i < list.size(); i++) {
			System.out.print("[No." + i + "] ");
			System.out.println(list.get(i)); // == list.get(i).toString()
		}
		System.out.println("----------------------------");
	} // end selectAll()

	private static void selectByIndex() {
		System.out.println("---------- 상세 검색 ----------");
		System.out.println("검색할 No를 입력하세요>");
		while (!sc.hasNextInt()) {
			sc.next();
			System.err.println("숫자만 입력해주세요!");
			System.out.println("검색할 No를 입력하세요>");
		}
		int index = sc.nextInt();
		int size = ((ContactDAOImple) dao).getListSize(); // 다형성으로 casting후에 ContactDAOImple의 메소드size에 접근하여 값을 받아옴
		if (index >= 0 && index < size) {
			ContactVO vo = dao.select(index); // 한명의 정보만 가져옴
			System.out.print("[No." + index + "] ");
			System.out.println(vo);
		} else {
			System.out.println("저장되지 않은 No 입니다!!");
		}
	} // end selectByIndex()

	private static void updateContact() {
		System.out.println("---------- 정보 수정 ----------");
		System.out.println("수정할 No를 입력하세요>");
		while (!sc.hasNextInt()) {
			sc.next();
			System.err.println("숫자만 입력해주세요!");
			System.out.println("수정할 No를 입력하세요>");
		}
		int index = sc.nextInt();
		int size = ((ContactDAOImple) dao).getListSize();
		if (index >= 0 && index < size) {
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
	} // end updateContact

	private static void deleteContact() {
		System.out.println("---------- 정보 삭제 ----------");
		System.out.println("삭제할 No를 입력하세요>");
		while (!sc.hasNextInt()) {
			sc.next();
			System.err.println("숫자만 입력해주세요!");
			System.out.println("삭제할 No를 입력하세요>");
		}
		int index = sc.nextInt();
		int size = ((ContactDAOImple) dao).getListSize();
		if (index >= 0 && index < size) {
			int result = dao.delete(index);
			if (result == 1) {
				System.out.println("[No." + index + "] 삭제성공!");
			} else {
				System.out.println("[No." + index + "] 삭제실패!");
			}
		} else {
			System.out.println("저장되지 않은 No 입니다!!");
		}

	} // end deleteContact

} // end ContactMain class
