package edu.java.contact02;

public interface ContactDAO {

	// 연락처 등록
	public abstract int insert(ContactVO vo);

	// 연락처 전체검색
	public abstract ContactVO[] select();

	// 연락처 상세검색 overloading
	public abstract ContactVO select(int index);

	// 연락처 수정
	public abstract int update(int index, ContactVO vo);

}
