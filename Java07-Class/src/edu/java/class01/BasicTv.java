package edu.java.class01;

// 클래스(Class)
// - 만들고자 하는 대상의 상태(속성) 정보들을 "멤버 변수(필드)"로 선언하고,
//	 대상이 가져야 할 기능들을 "메소드"로 정의하는,
//	 새로이 만드는 "데이터 타입"

public class BasicTv {
	// TV가 가져야 할 상태(속성, 성질) => 멤버 변수(필드, 프로퍼티)
	boolean powerOn; // TV의 전원 상태(true : on, false : off)
	int channel = 1; // TV의 채널 정보. 1로 초기화
	int volume; // TV의 소리 정보. default 값인 0으로 초기화
	// 지역변수는 초기화가 필수이고 해당지역에서만 사용하고 사라질거니깐
	// 멤버변수는 여기가아니라 다른곳에서 사용될수 있기때문에 자동초기화가 지원된다.

	// TV가 가져야 할 기능 => 메소드
	public void turnOnOff() {
		if (powerOn) { // powerOn == true 와 같다/ 만약 TV가 켜져있으면
			powerOn = false;
			System.out.println("TV가 꺼졌습니다.");
		} else { // 만약 TV가 꺼져있으면
			powerOn = true;
			System.out.println("TV가 켜졌습니다.");
		}
	} // end turnOnOff

	// 채널 증가 기능 메소드
	// 이 메소드를 호출하면 변수가 1씩 증가하고 1 ~ 5 순환구조
	public void channelUp() {
		if (channel == 5) {
			channel = 1;
		} else {
			channel++;
		}
		System.out.println("channel up : " + channel);
	} // end channelUp

	// 채널 감소 기능 메소드
	public void channelDown() {
		if (channel == 1) {
			channel = 5;
		} else {
			channel--;
		}
		System.out.println("channel down : " + channel);
	} // end channelDown

	// 볼륨 증가 기능 메소드 (최대 4)
	public void volumeUp() {
		if (volume < 4) {
			volume++;
		}
		System.out.println("volume up : " + volume);
	} // end volumeUp

	// 볼륨 감소 기능 메소드 (최소 0)
	public void volumeDown() {
		if (volume > 0) {
			volume--;
		}
		System.out.println("volume down : " + volume);
	} // end volumeDown

	public void displayInfo() {
		System.out.println("--- TV 현재 상태 ---");
		System.out.println("전원 : " + powerOn);
		System.out.println("채널 : " + channel);
		System.out.println("볼륨 : " + volume);
	} // end displayInfo()

} // end BasicTv
