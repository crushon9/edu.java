package edu.java.inherit06;

public class CarUtil {
	
	public void drive(Car[] cars) { // Car배열을 인자값으로 받아옴
		for (Car x : cars) {
			x.display();
			System.out.println("----------------------");
		}

	}
}
