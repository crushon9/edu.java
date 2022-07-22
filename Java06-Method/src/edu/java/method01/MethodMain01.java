package edu.java.method01;

// 메소드

// 기능을 수행하기 위한 코드. 주로 반복적으로 기능을 수행할 때 생성
// 메소드는 클래스의 내부이며, 다른 메소드의 외부인 영역에서 만들어야 한다.
// **즉 메소드 안에 또 다른 메소드를 만들 수 없음
// 정의 : 수식어 리턴타입 메소드이름(매개변수1, 매개변수2 ..) {본문}
//		-수식어 : public(생략가능), private, static ..
//		-리턴타입(O/X) : 자료타입(int, String, class ..) / void(없음)
//		-매개변수(O/X) : 메소드를 호출할 때 input 데이터 / 없을땐 선언 생략
//		-{본문} : 메소드의 본체body. 수행해야할 기능을 작성

public class MethodMain01 {
	// 메소드 생성 _메소드는 클래스의 내부이며, 다른 메소드의 외부인 영역에서 만들어야 한다.
	public static void sayHello(String name) { // String name : parameter
		System.out.println("안녕하세요~");
		System.out.println("저는 " + name + "입니다.");
	} // end sayHello()

	public static void sayAge(int age) {
		System.out.println("제 나이는 " + age + " 입니다!");
	}

// static 수식어 : 프로그램이 실행될 때 순서와 상관없이 생성하도록 선언하는 키워드
//				*static 메소드에서는 static으로 선언된 메소드만 호출가능

	public static void main(String[] args) {
		System.out.println("저는 컴퓨터입니다.");
		System.out.println("저는 스마트폰입니다.");

		sayHello("심청미"); // 메소드 호출. 인자값으로 "심청미"를 넘겨줌 argument
		sayHello("행운이");

		sayAge((int)'A');
		
		
	} // end main()

} // end MethodMain01
