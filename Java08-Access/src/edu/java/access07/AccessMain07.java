package edu.java.access07;

public class AccessMain07 {

	public static void main(String[] args) {

		System.out.println("===== num1 ======");
		MyNumber num1 = new MyNumber();
		System.out.println("주소 : " + num1);
		System.out.println("초기값 : " + num1.getnumber());
		num1.setNumber(5);
		System.out.println("set값 : " + num1.getnumber());

		System.out.println("===== num2 ======");
		MyNumber num2 = new MyNumber(2);
		System.out.println("주소 : " + num2);
		System.out.println("set값 : " + num2.getnumber());

		System.out.println("==== num1이 add메소드 호출 =====");
		System.out.println("num1주소 : " + num1);
		System.out.println("메소드리턴값(자기자신객체주소값) : " + num1.add(num2));
		// num1 객체의 number와 num2 객체의 number 값을 더해서
		// num1 객체의 number 변수에 저장하고, num1이 담은 주소를 반환한다.
		System.out.println("메소드연산결과 : " + num1.getnumber());

		System.out.println("==== num3이 add메소드 여러개 호출 =====");
		// add메소드가 리턴하는값이 객체니깐 연달아 호출가능
		MyNumber num3 = new MyNumber(1);
		MyNumber x = new MyNumber(2);
		MyNumber y = new MyNumber(3);
		MyNumber z = new MyNumber(4);
		System.out.println("num3주소 : " + num3);
		System.out.println("num3초기값 : " + num3.getnumber());
		System.out.println("메소드리턴값 : " + num3.add(x).add(y).add(z));
		System.out.println("메소드연산결과 : " + num3.getnumber());
		
		System.out.println("==== num3이 add메소드 여러개 호출 뜯어보기=====");
		num3.setNumber(1); // 초기화
		MyNumber r1 = num3.add(x); //r1에는 num3.number값에 x.number가 더해지고 num3객체주소반환하여 r1에 담음
		MyNumber r2 = r1.add(y); //r2에는 r1에 담긴 num3으로 num3.number값에 y.number가 더해지고 num3객체주소반환하여 r2에 담음
		MyNumber r3 = r2.add(z); //r3에는 r2에 담긴 num3으로 num3.number값에 z.number가 더해지고 num3객체주소반환하여 r3에 담음
		System.out.println("num3주소값 : " + num3);
		System.out.println("r3주소값 : " + r3);
		System.out.println("num3연산결과 : " + num3.getnumber());
		System.out.println("r3연산결과 : " + r3.getnumber());
	}
}
