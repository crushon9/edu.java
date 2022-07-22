package edu.java.interface01;

// 예시 다른팀에서 임시로 테스트하기 위한 용도로 사용할 클래스
public class DummyImple implements DataBaseQuery {

	@Override
	public int insert(String id, String pw) {
		return 0;
	}

}
