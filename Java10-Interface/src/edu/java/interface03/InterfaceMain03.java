package edu.java.interface03;

// 클래스<-클래스는 extends가능(한개만), implements불가능
// 클래스<-인터페이스 extends불가능, implements가능(여러개)
// 인터페이스<-클래스 extends불가능, implements불가능
// 인터페이스<-인터페이스는 extends가능(한개만), implements불가능
interface Test1 {
	public abstract void test1();
}

interface Test2 {
	public abstract void test2();
}

class TestImple implements Test1, Test2 {
	@Override
	public void test2() {
		System.out.println("test2");
	}

	@Override
	public void test1() {
		System.out.println("test1");
	}
}

public class InterfaceMain03 {

	public static final int mam = 1;

	public static void main(String[] args) {
		TestImple CimI_CimI = new TestImple();
		CimI_CimI.test1();
		CimI_CimI.test2();

		// 인터페이스의 다형성 :
		// 구현된 클래스의 객체를 인터페이스 타입의 참조변수에 저장 가능
		Test1 I_CimI = new TestImple();
		I_CimI.test1();
		((Test2) I_CimI).test2();
		// 변수를 Test1으로 선언했기 때문에 Test2의 메소드는 사용할 수 없음
		// Test2의 메소드를 사용하기 위해서는 강제형변환

		// 밑에 주소는... 참조변수를 담고있는 껍데기자료형말고 new 힙주소가 출력됨
//		System.out.println(CimI_CimI);
//		System.out.println(I_CimI);

	}

}
