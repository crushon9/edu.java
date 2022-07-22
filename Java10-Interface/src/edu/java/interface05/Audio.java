package edu.java.interface05;

public class Audio implements RemoteController {

	@Override
	public void turnOn() {
		System.out.println("Audio켜짐");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio꺼짐");
	}

}
