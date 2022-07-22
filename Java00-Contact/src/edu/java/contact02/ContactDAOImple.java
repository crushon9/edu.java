package edu.java.contact02;

public class ContactDAOImple implements ContactDAO {

	private final int MAX = 100; // 최대 연락처수
	private ContactVO[] list = new ContactVO[MAX]; // 연락처 저장 배열
	private int count; // 배열에 데이터를 저장하면 증가하는 카운트

	public ContactDAOImple() { // 기본생성자
	}

	public int getCount() { // private count를 외부로 반환해주기 위해서 getter 선언
		return count;
	}

	@Override // 연락처 등록
	public int insert(ContactVO vo) {
		list[count] = vo;
		System.out.print("[No." + count + "] ");
		count++;
		return 1; // 0:실패, 1:성공
	}

	@Override // 연락처 전체 검색
	public ContactVO[] select() {
		return list; // 전체배열 통째로 반환
	}

	@Override // 연락처 상세 검색
	public ContactVO select(int index) {
		return list[index]; // 해당 index만 반환
	}

	@Override // 연락처 수정
	public int update(int index, ContactVO vo) {
		list[index].setName(vo.getName());
		list[index].setPhone(vo.getPhone());
		list[index].setEmail(vo.getEmail());
		// 전달받은vo객체의 멤버변수를 get하여 전달받은인덱스 배열객체의 set값으로 넣음
		return 1; // 0:실패, 1:성공
	}
}
