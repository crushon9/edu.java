package edu.java.inner05;

class OuterClass {
	private int value;
	
	public OuterClass(int value) {
		this.value = value;
	}
	
	public void test() {
		int x = 123; // 지역 변수(local variable)
		
		// 지역 변수를 선언하는 위치에서 정의하는 클래스 : 지역 클래스
		class LocalClass {
			private int value2; // 지역클래스의 멤버 변수
			
			// 지역 클래스의 생성자
			public LocalClass(int value2) {
				this.value2 = value2;
			}
			
			// 지역 클래스의 메소드
			public void display() {
				// 외부 클래스의 멤버 변수를 참조 가능
				System.out.println("value = " + value);
				
				// 메소드의 지역 변수 사용 가능
				System.out.println("x = " + x);
				
				// 지역 클래스의 멤버 변수를 참조 가능
				System.out.println("value2 = " + value2);
			} // end display()
			
		} // end LocalClass
		
		// 지역 클래스의 인스턴스를 메소드안에서 생성, 생성자로 값을 전달
		LocalClass local = new LocalClass(1234);
		// 지역클래스 내부의 메소드 호출
		local.display();
		
	} // end test()
	
} // end OuterClass

public class InnerMain05 {

	public static void main(String[] args) {
		// 지역클래스를 담고있는 외부클래스의 인스턴스 생성
		OuterClass outer = new OuterClass(100);
		// 외브클래스인스턴스를 통하여 메소드에 접근 해당메소드를 호출하기만하면 지역클래스의 메소드가 수행됨
		outer.test();
	} // end main()

} // end InnerMain05







