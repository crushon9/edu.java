package edu.java.access05;

// 클래스의 접근 제한 수식어 : public, (package) 두 가지만!
// (클래스를 private하면 다른 클래스에서 사용할 수 없잖아? 의미없으니깐 안쓰는 듯)
// 1. public class : 어디서든지 인스턴스 생성이 가능한 클래스
// 2. (package) class : 같은 패키지에 속한 클래스들에서만 인스턴스 생성이 가능
// 주의사항 :
// - public class의 이름은 반드시 java 파일의 이름과 같아야 함!
// - 하나의 java 파일에 여러 개의 클래스를 정의하는 것은 가능하지만, 같은 파일에서는 public class는 오직 하나만 있어야 함

public class AccessMain05 {

	public static void main(String[] args) {
		// 같은 패키지에 있는 public class의 인스턴스 생성 가능
		TestPublic t1 = new TestPublic();
		System.out.println(t1); // t1 변수에는 클래스의 참조주소값이 담겨져 있음

		// 같은 패키지에 있는 (package) class의 인스턴스 생성 가능
		TestPackage t2 = new TestPackage();
		System.out.println(t2);
		
		final int a = 1;
	

	}

}
