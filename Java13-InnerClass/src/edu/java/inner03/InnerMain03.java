package edu.java.inner03;

// 외부클래스
class OuterTest {
	private int value;

	public OuterTest(int value) {
		this.value = value;
	}

	public void printValues() {
		System.out.println("---OuterTest---");
		System.out.println("value = " + value);
	}

	// 멤버 내부 클래스
	class InnerTest {
		private int value; // 외부클래스와 동일한 이름도 가능

		public InnerTest(int value) {
			this.value = value;
		}

		// 외부클래스의 멤버변수(A)이름과 내부클래스의 멤버변수(B)이름이같을때 A를 참조하는방법
		public void displayValues() {
			System.out.println("---InnerTest---");
			System.out.println("value = " + value);
			System.out.println("this.value = " + this.value);
			System.out.println("OuterTest.this.value = " + OuterTest.this.value);

		}

	} // end InnerTest
} // end OuterClass

public class InnerMain03 {

	public static void main(String[] args) {
		OuterTest out = new OuterTest(111);
		out.printValues();

		OuterTest.InnerTest inner = out.new InnerTest(222);
		inner.displayValues();

	}

} // end InnerMain03
