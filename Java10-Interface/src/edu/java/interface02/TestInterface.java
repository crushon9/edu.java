package edu.java.interface02;

// Java 8 버전부터 바뀐 인터페이스 :
// 인터페이스가 가질 수 있는 멤버들 :
// 1. public static final 필드 -> 7버전과동일
// 2. public abstract 메소드 -> 7버전과동일
// 3. default 메소드 (본체가 구현, 인스턴스 생성되어야만 사용가능한 메소드, default 키워드로 선언)
// 4. static 메소드 (본체가 구현, 인스턴스 생성없이 사용가능한 메소드, static 키워드로 선언)

public interface TestInterface {

	public static final int MAX = 100;

	public abstract int test(int a);

	public default void defaultM() {
		System.out.println("hello");
	}

	public static void defaultS() {
		System.out.println("hello");
	}

}
