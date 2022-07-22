package edu.java.inherit06;

public class HybridCar extends Car {
	// 멤버 변수
	private int battery;

	public HybridCar() {
	}

	public HybridCar(int battery) {
		this.battery = battery;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	@Override
	public String toString() {
		return "HybridCar [battery=" + battery + "]";
	}

	@Override
	public void display() {
		System.out.println("자식 하이브리드 자동차 연료 : " + getFuel());
		// 상속을 받으면 Car.gerFuel() 라고 안해도 자동으로 부모메소드를 호출할 수 있다
		System.out.println("자식 하이브리드 자동차 배터리 : " + battery);
	}

}
