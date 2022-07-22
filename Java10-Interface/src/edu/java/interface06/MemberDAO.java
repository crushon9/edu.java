package edu.java.interface06;

// *인터페이스 DAO 함수 설계 방식
// 함수의 리턴타입 : 돌려주는 데이터 형태에 따라
// 함수의 매개변수 : 전송되는 데이터 형태에 따라

public interface MemberDAO {
	// 회원정보 등록
	public abstract int insert(MemberVO vo);

	// 회원정보 전체검색
	public abstract MemberVO[] select();

	// 회원정보 상세검색 overloading
	public abstract MemberVO select(int index);

	// 회원정보 상세수정
	public abstract int update(int index, MemberVO vo);
}
