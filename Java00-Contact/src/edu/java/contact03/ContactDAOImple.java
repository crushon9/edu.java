package edu.java.contact03;

import java.util.ArrayList;

public class ContactDAOImple implements ContactDAO {

	private ArrayList<ContactVO> list = new ArrayList<>(); // 연락처 저장 컬렉션 ArrayList

	public ContactDAOImple() { // 기본생성자
	}

	@Override // 연락처 등록
	public int insert(ContactVO vo) {
		list.add(vo);
		return 1; // 0:실패, 1:성공
	}

	@Override // 연락처 전체 검색
	public ArrayList<ContactVO> select() {
		return list; // 전체 ArrayList 통째로 리턴
	}

	@Override // 연락처 상세 검색
	public ContactVO select(int index) {
		return list.get(index); // 해당 index의 ContactVO만 반환
	}

	@Override // 연락처 수정
	public int update(int index, ContactVO vo) {
		list.get(index).setName(vo.getName());
		list.get(index).setPhone(vo.getPhone());
		list.get(index).setEmail(vo.getEmail());
		// 전달받은vo객체의 멤버변수를 get하여, 전달받은인덱스객체의 set값으로 넣음
		return 1; // 0:실패, 1:성공
	}
	
	@Override
	public int delete(int index) {
		list.remove(index);
		return 1; // 0:실패, 1:성공
	}
}
