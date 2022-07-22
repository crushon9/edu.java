package edu.java.interface01;

public interface DataBaseQuery {
	// 인터페이스의 멤버변수 : public static final
	public static final int DATABASE_VERSION = 1;
//	int TEST = 1; (public static final 생략가능)

	// 인터페이스의 메소드 : public abstract
	public abstract int insert(String id, String pw);
//	int test(String id, String pw); (public abstract 생략가능)

}
