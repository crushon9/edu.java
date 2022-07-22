package edu.java.interface06;

import java.util.Scanner;

// MVC 디자인 패턴 (Model-View-Controller)
// 개발순서 : 메모장에 정보와 기능 설계 -> 백앤드 -> 프론트엔드 -> 합치기
// Java에서 비슷하게 MVC 구현
// Model = ClassVO(정보)
// View  = Main클래스 (UI)
// Controller = InterfaceDAO & ClassDAOimple(기눙)

public class MemberMain { // View 클래스(UI를 담당하는 역할) = Main 클래스
	private static Scanner sc;
	private static MemberDAO dao; // MemberDAOimple 인스턴스를 저장할 변수

	public static void main(String[] args) {
		System.out.println("< 회원 관리 프로그램 >");
		sc = new Scanner(System.in);
		dao = MemberDAOImple.getInstance(); // 다형성. 싱글톤 인스턴스생성

		boolean run = true;
		while (run) {
			showMainMenu();
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case Menu.INSERT:
				insertMember();
				break;

			case Menu.SELECT_ALL:
				selectAll();
				break;

			case Menu.SELECT_BY_INDEX:
				selectByIndex();
				break;

			case Menu.UPDATE:
				updateMember();
				break;

			case Menu.QUIT:
				System.out.println("=========== 프로그램을 종료합니다 ===========");
				run = false;
				break;

			default:
				System.out.println("0 ~ 4번 중에 선택해주세요!");
				break;
			}
		} // while 종료

		sc.close(); // 프로그램이 끝날때 닫는게 편함

	} // end main()

	private static void showMainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println("1.등록 | 2.전체검색 | 3.상세검색 | 4.수정 | 0.종료");
		System.out.println("-----------------------------------------");
		System.out.print("선택>");
	} // end showMainMenu()

	private static void insertMember() {
		System.out.println("=============== 정보 등록 ===============");
		System.out.print("아이디 입력>");
		String id = sc.nextLine();
		System.out.print("비밀번호 입력>");
		String pw = sc.nextLine();
		System.out.print("이메일 입력>");
		String email = sc.nextLine();

		MemberVO vo = new MemberVO(id, pw, email); // 입력받은정보를 MemberVO 인스턴스를 새로 생성하며 넘겨줌
		int result = dao.insert(vo); // insert 기능이 담긴 MemberDAOimple로 정보가담긴인스턴스참조변수vo를 통째로넘겨주며 성공여부를 int로 반환
		if (result == 1) {
			System.out.println("성공!");
		} else {
			System.out.println("실패!");
		}
	} // end insertMember()

	private static void selectAll() {
		System.out.println("=============== 전체 검색 ===============");
		MemberVO[] voList = dao.select(); // 리턴을 받을 임시그릇을 만든다 (묶어서 한번만 전달하면되니깐)
		int count = ((MemberDAOImple) dao).getCount(); // MemberDAOimple의 private count를 사용하기 위해서,
		// getter로 가져오고 현재 MemberDAO 인터페이스 타입그릇에 담긴 dao를 형변환을 한다
		for (int i = 0; i < count; i++) {
			System.out.print("회원정보 [" + i + "] : ");
			System.out.println(voList[i]); // list[i].toString() 과 같다
		}
		System.out.println("======================================");
	} // end selectAll()

	private static void selectByIndex() {
		System.out.println("=============== 상세 검색 ===============");
		System.out.println("검색할 No를 입력하세요>");
		int index = sc.nextInt();

		int count = ((MemberDAOImple) dao).getCount();
		if (index >= 0 && index < count) {
			MemberVO vo = dao.select(index); // 한명의 정보만 가져옴
			System.out.print("회원정보 [" + index + "] : ");
			System.out.println(vo);
		} else {
			System.out.println("저장되지 않은 No 입니다!!");
		}
		System.out.println("======================================");
	} // end selectByIndex()

	private static void updateMember() {
		System.out.println("=============== 정보 수정 ===============");
		System.out.println("수정할 No를 입력하세요>");
		int index = sc.nextInt();
		int count = ((MemberDAOImple) dao).getCount();
		if (index >= 0 && index < count) {
			System.out.print("비밀번호 입력>");
			String pw = sc.next();
			System.out.print("이메일 입력>");
			String email = sc.next();
			MemberVO vo = new MemberVO("", pw, email); // id는 수정하지 않으니깐 ""으로넘김
			int result = dao.update(index, vo);
			if (result == 1) {
				System.out.println("성공!");
			} else {
				System.out.println("실패!");
			}
		} else {
			System.out.println("저장되지 않은 No 입니다!!");
		}
		System.out.println("======================================");
	} // end updateMember

} // end MemberMain class