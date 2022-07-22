package edu.java.interface04;

// 인터페이스의 활용 : 상수(public static final) 등만 정의하는 타입
// public abstract 
// public static final
public interface Menu {
	// 이렇게 정의하면 수정되어도 유지보수가 편리하다
	public static final int INSERT = 1;
	public static final int SELECT = 2;
	public static final int QUIT = 3;

	// public static final 생략해도 자동으로 있는듯 작동
	// (한 단어씩 생략해도 저절로 인식되네?)
	String STR_INSERT = "입력 메뉴";
	static final String STR_SELECT = "검색 메뉴";
	public String STR_QUIT = "프로그램 종료";
	final String test1 = "test";
	static String test2 = "test";
	final static public int test = 1; // 순서 바꿔도 되네?
	

}
