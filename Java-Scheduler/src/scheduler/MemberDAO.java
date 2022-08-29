package scheduler;

interface MemberDAO {
	// 회원 등록
	public abstract int insert(MemberVO vo);

//	// 회원 전체검색
//	public abstract ArrayList<MemberVO> select();
	
	// 회원 상세검색
	public abstract MemberVO select(String ID);

	// 회원 수정
	public abstract int update(MemberVO vo);

	// 회원 삭제
	public abstract int delete(String id);

}
