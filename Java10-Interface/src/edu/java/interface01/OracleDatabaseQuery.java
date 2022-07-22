package edu.java.interface01;

public class OracleDatabaseQuery implements DataBaseQuery {
	// 추상인터페이스를 implements하면 거기정의된 추상메소드를 꼭 Override 해야함
	@Override
	public int insert(String id, String pw) {
		System.out.println("오라클 DB 연결");
		System.out.println("SQL 문장 작성/실행");
		System.out.println("SQL 실행 결과 처리");
		return 1;
	}

}
