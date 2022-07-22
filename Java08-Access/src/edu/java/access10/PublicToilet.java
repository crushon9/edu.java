package edu.java.access10;

// 싱글톤 디자인 패턴(singleton design pattern)
// - 클래스의 인스턴스를 오직 하나만 생성할 수 있도록 작성하는 설계 기법
// 인스턴스에 저장된 값을 공유해야할 때 해당기법 사용.
// 1. 클래스 자신 타입의 private static 변수를 선언
// 2. 생성자는 private 로 선언
// 3. public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계
// 처음 생성한 인스턴스는 변경이 불가능(주소값이 같음)

public class PublicToilet {

	// 1. 클래스 자신 타입의 private static 변수를 선언
	// PublicToilet에서는 누구나 접근가능한 공간에 instance = null 상태로 있다
	// private이므로 해당클래스 외부에서는 접근불가 (캡슐화??)
	private static PublicToilet instance = null;

	// 2. 생성자는 private 로 선언
	// 생성자가 private이기 때문에 메인에서 직접 호출못하고(new로 생성불가)
	// getInstance 메소드로 우회되어 사용될 것
	private PublicToilet() {
	}

	// 3. public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계
	// static이니깐 인스턴스를 생성하지 않고 클래스로 바로 호출가능
	// 인스턴스가 초기세팅값(null)이면 새로만들어 리턴하고, 아니라면(생성되었다면) 기존인스턴스를 리턴
	public static PublicToilet getInstance() {
		if (instance == null) {
			instance = new PublicToilet();
		}
		return instance;
	}
	
	
	private String location;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
