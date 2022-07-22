package edu.java.interface05;

public class TV implements RemoteController {

	@Override
	public void turnOn() {
		System.out.println("TV켜짐");
	}

	@Override
	public void turnOff() {
		System.out.println("TV꺼짐");
	}

}
