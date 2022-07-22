package edu.java.inherit06;

// 다형성(Polymorphism)
// - 객체(인스턴스)를 여러가지 타입으로 호출 할 수 있는 것
// - 생성된 인스턴스를 참조하는 참조변수를 선언할 때
// 	 생성된 인스턴스의 클래스타입으로 선언할 수도 있고 부모타입으로 선언할 수도 있는 것
// 다형성의 장점
// 1. 배열을 사용할 때 부모타입으로만 선언해도 그 배열에는 부모/자식타입 모두 저장 가능
// 2. 메소드를 정의할 때 매개변수나 리턴타입을 부모타입으로만 정의해도
//	  부모/자식타입 모두 매개변수나 리턴값으로 사용할 수 있음
// ** 반대로 자식타입으로 선언한 그릇에 부모를 담을 수는 없다

// ChildClass 변수이름 = new ChildClass(); 자식<-자식 : 당연가능
// ParentClass 변수이름 = new ChildClass(); 부모<-자식 : 다형성 가능
// ChildClass 변수이름 = new ParentClass(); 자식<-부모 : 불가능

public class InheritMain06 {

	public static void main(String[] args) {
		// 부모 Car 클래스의 인스턴스 생성
		Car car1 = new Car();

		// 자식 HybidCar 클래스의 인스턴스 생성
		HybridCar car2 = new HybridCar();

		Car car3 = new HybridCar(); // 다형성(Polymorphism)
		// 그릇만 Car고 내용물은 HybridCar (상속에서만 자식은 부모타입으로 자동형변환 됨)
		double d = 1.0f; // 이거랑 같은 상황이지
		int i = '가';

//		HybridCar car4 = new Car(); // 자식클래스에 부모클래스 객체 저장 불가
		
		// 부모 Car 배열에 저장하기 
		Car[] cars = new Car[3];
		cars[0] = car1; // Car 객체
		cars[1] = car2; // HybridCar 객체
		cars[2] = car3; // HybridCar 객체
		
		// 주소는 각기 다르네? 이 주소는 stack의 참조변수주소가아니라 힙영역 객체주소인듯??
		// 객체의 해시코드(hashCode())란 객체를 식별할 하나의 정수 값
		System.out.println(car1.getClass().getName() + '@' + Integer.toHexString(car1.hashCode()));
		System.out.println(car2.getClass().getName() + '@' + Integer.toHexString(car2.hashCode()));
		System.out.println(car3.getClass().getName() + '@' + Integer.toHexString(car3.hashCode()));

		System.out.println("< 배열에 잘 저장되어있는지 확인 >");
		for (Car x : cars) { // cars 배열에 있는 객체를 x에 하나씩 저장
			x.display();
			System.out.println("----------------------");
		}

		System.out.println("< util로 택배 보내기 >");
		CarUtil util = new CarUtil();
		util.drive(cars);
		// 나중에 받은 택배를 확인(instanceof)하고 형변환해야 사용가능

	}

}
