package edu.java.access03;

// 캡슐화(encapsulation)
// - 클래스를 설계할 때, 멤버 변수들을 private로 선언하여 외부 클래스에 필드들을 직접 접근해서 읽거나 쓰지 못하게 하는 것
// - 필요한 경우에 한하여 public 메소드를 정의하여 private 멤버 변수를 간접적으로 읽거나 쓰는 것을 가능하게 할 수 있음

public class AccessMain03 {

	public static void main(String[] args) {

		MyNumber num0 = new MyNumber(); // 0으로 값 초기화
//		num0.number = 10000; // 접근 불가하여 값 할당 불가
		System.out.println("num0 : " + num0.getNumber()); // getter메소드로 접근하여 읽기만 가능

		MyNumber num1 = new MyNumber(100); // 초반에 넣은값은 다시 접근해서 바꿀 수 없음
		System.out.println("num1 : " + num1.getNumber());
		num1.setNumber(200); // setter 메소드로 접근하여 수정
		System.out.println("num1 : " + num1.getNumber());
		num1.addToNumber(10); // addToNumber 메소드로 더하기
		System.out.println("num1 : " + num1.getNumber());

	}

}
