package edu.java.inner02;

public class InnerMain02 {

	public static void main(String[] args) {
		// Car 인스턴스 및 Tire 인스턴스 생성
		Car car1 = new Car("포르쉐 911");
		Car.Tire tire1 = car1.new Tire(20);
		tire1.display();
		
		Car car2 = new Car("아반떼");
		Car.Tire tire2 = car2.new Tire(15);
		tire2.display();
		
		

	}

}
