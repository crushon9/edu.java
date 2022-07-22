package edu.java.inherit12;

// abstract 메소드 (추상 메소드)
// 메소드의 원형(prototype)만 선언하고 메소드의 본체(body)를 구현하지 않는 메소드. 즉{..}없음
// 선언형태 : abstract 리턴타입 메소드이름(매개변수,,);
//
// abstract 클래스 (추상 클래스)
// 추상메소드를 하나라도 가지고 있다면 추상클래스가 되어야한다.
// 선언형태 : abstract class 클래스이름{..}
// 추상클래스는 인스턴스를 생성할수없음 (생성자호출불가)
// 상속받는 클래스에서 메소드를 override하면 인스턴스를 생성할수없음

abstract class TestAbstract {
	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	// 추상 메소드 : 본체{ }가 없는 메소드 -> 추상클래스에서만 선언가능
	public abstract void hello();
} // end TestAbstract

class TestChild extends TestAbstract {
	// 추상클래스를 상속받으면 거기에 정의된 추상메소드를 꼭 Override하여 정의해야함
	@Override
	public void hello() {
		System.out.println("안녕하세요");
	}
} // end TestChild

public class InheritMain12 {

	public static void main(String[] args) {
		// 추상클래스는 인스턴스를 생성할 수 없음
//		TestAbstract ab = new TestAbstract();
		// 추상클래스를 상속받은 일반클래스로 인스턴스를 생성해야함
		TestChild ch = new TestChild();
		ch.setX(1);
		ch.hello();

	}
}

// ---------혼자 테스트
abstract class TestAbstract2 {
	// abstract 클래스로 선언한뒤 추상메소드를 정의하지않는것은 가능한가보네?? 그냥 인스턴스를 생성할수없겠지
}

class TestChild2 extends TestAbstract2 {
	// 상속한 추상클래스에 정의된 추상메소드가 없다면 Override 할것도 없음
}