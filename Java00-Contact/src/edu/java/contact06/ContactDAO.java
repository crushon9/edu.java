package edu.java.contact06;

import java.util.ArrayList;

// DAO. Data Access Object
// VO. Value Object
// 연락처 등록, 전체검색, 상세검색, 수정, 삭제
public interface ContactDAO {

	// 연락처 등록
	public abstract int insert(ContactVO vo);
	// 리턴타입 int : 데이터를 삽입한 뒤 성공여부(0,1)를 저장
	// insert : 등록 기능을 의미하므로 insert로 이름설정
	// 매개변수 ContactVO : 연락처정보를 데이터클래스인 ContactVO로 넘겨받아 삽입하기 때문에

	// 연락처 전체검색
	public abstract ArrayList<ContactVO> select();

	// 연락처 상세검색 - overloading(매개변수가 다름, 리턴값이 다른건 상관없음)
	public abstract ContactVO select(int contactId);

	// 연락처 수정
	public abstract int update(ContactVO vo);

	// 연락처 삭제
	public abstract int delete(int contactId);

}
