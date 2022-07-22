package edu.java.interface05;

// 상속 : IS-A 관계가 성립할 때
// 		SmartTV is a TV
//		class SmartTV extends TV {...}

// 구현(인터페이스) : HAS-A 관계가 성립할 때
//		TV has a RemoteController
// 		class TV implements RemoteController {...}

public class InterfaceMain05 {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.turnOn();
		tv.turnOff();

		Audio audio = new Audio();
		audio.turnOn();
		audio.turnOff();

		RemoteController rc1 = new TV(); // 다형성
		rc1.turnOn();

		RemoteController rc2 = new Audio(); // 다형성
		rc2.turnOn();

		RemoteController[] arrRc = new RemoteController[2]; // 이건 생성자가 아니라 배열의 new 임!
		arrRc[0] = tv;
		arrRc[1] = audio;

	}
}
