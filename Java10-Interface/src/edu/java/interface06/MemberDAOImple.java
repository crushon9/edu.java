package edu.java.interface06;

// DAO (Data Access Object) :
// 데이터의 전송을 담당하는 역할

public class MemberDAOImple implements MemberDAO {

//-------싱글톤 디자인 패턴 적용 시작------------------------------
//	클래스 자신 타입의 private static 변수를 선언
	private static MemberDAOImple instance = null;

//	생성자는 private 로 선언
	private MemberDAOImple() {
	}

//	public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계 (if_null)
	public static MemberDAOImple getInstance() {
		if (instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}

//---------------------------------------------------------
	private final int MAX = 100; // 최대 회원수
	private MemberVO[] list = new MemberVO[MAX]; // 회원정보 저장 배열을 메인이아니라 기능구현을 하는여기다 선언
	private int count; // 배열에 데이터를 저장하면 증가하는 카운트

	public int getCount() { // private count를 외부로 반환해주기 위해서 getter 선언
		return count;
	}

	@Override
	public int insert(MemberVO vo) { // 회원등록
		list[count] = vo; // 메인에서 넘겨받은 vo를 배열에 차곡차곡 저장하고
		System.out.println("========== No." + count + "이 등록 되었습니다 ==========");
		count++; // 저장할때마다 인덱스를 증가
		return 1; // 0:실패, 1:성공
	}

	@Override
	public MemberVO[] select() {
		return list; // 전체배열 통째로 반환
	}

	@Override
	public MemberVO select(int index) {
		return list[index]; // 해당 index만 반환
	}

	@Override
	public int update(int index, MemberVO vo) {
// list[index](역시 MemberVO 객체)를 set(메인에서 생성한 vo객체에 담긴 private pw를 반환해주는 getter반환값을통해)
		list[index].setPw(vo.getPw());
		list[index].setEmail(vo.getEmail());
		return 1; // 0:실패, 1:성공
	}

}
