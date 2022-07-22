package edu.java.class03;

public class ClassMain03 {

	public static void main(String[] args) {
		System.out.println("==기본생성자로 MyCircle 인스턴스 생성==");
		MyCircle cir1 = new MyCircle();
		// 값을 저장하지 않아도 double default값 0.0
		System.out.println("반지름 : " + cir1.radius);
		System.out.println("넓이 : " + cir1.calcAlea());
		
		cir1.radius = 2.0;
		System.out.println("반지름 : " + cir1.radius);
		System.out.println("넓이 : " + cir1.calcAlea());

		System.out.println("==매개변수가 있는 생성자로 인스턴스 생성==");
		MyCircle cir2 = new MyCircle(10.4);
		System.out.println("반지름 : " + cir2.radius);
		System.out.println("넓이 : " + cir2.calcAlea());
	
	}

}
