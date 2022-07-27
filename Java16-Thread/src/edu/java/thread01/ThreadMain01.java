package edu.java.thread01;

// 쓰레드(Thread) : 하나의 작업을 순차적으로 진행하는 실행 코드
// 멀티 쓰레드 프로그램 : 
// 하나의 프로그램(프로세스)에서 여러개의 쓰레드를 동작하는 프로그램
// 예시 채팅프로그램 - 채팅 + 파일전송

// 자바에서 쓰레드를 생성하고 사용하는 방법1 :
// 1. Thread 클래스를 상속받는 새로운 클래스 정의(extends Thread)
// 2. 정의한 새로운 클래스 안에서 run() 메소드를 override 하여 쓰레드가 해야할 기능 구현
// 3. 정의한 클래스의 인스턴스를 생성
// 4. 생성된 인스턴스에서 start() 메소드를 호출
// -> 쓰레드가 가져야할 메모리 공간확보, 스케쥴링을 위해 쓰레드 등록, 초기화
// -> 쓰레드의 run() 메소드가 자동실행
/////////////////////////////////////////////////////////////
// run 은 쓰레드 하나당 하나씩 구현해야한다. main이랑 비슷한 느낌

// 1. Thread 클래스를 상속받는 새로운 클래스 정의(extends Thread)
class MyThead extends Thread {
	// 멤버변수
	private String msg;

	public MyThead(String msg) {
		this.msg = msg;
	}

// 2. 정의한 새로운 클래스 안에서 run() 메소드를 override 하여 쓰레드가 해야할 기능 구현
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " : " + msg);
			try {
				sleep(100); // 1초 동안 일을 멈춤 (delay)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} // end run

	public void run2() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " = " + msg);
			try {
				sleep(100); // 1초 동안 일을 멈춤 (delay)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} // end run2

} // end MyThead

public class ThreadMain01 {

	public static void main(String[] args) { // 메인함수도 하나의 쓰레드 (메인쓰레드)
		// 3. 정의한 클래스의 인스턴스를 생성
		MyThead th1 = new MyThead("안녕");

		// 4. 생성된 인스턴스에서 start() 메소드를 호출
		th1.start(); // main과 MyThead 중에서 순서가 정해져있지 않아 뭐가 먼저 시작될지모름

		// 쓰레드 하나더 만들기
		MyThead th2 = new MyThead("Hello"); // th1과 th2의 우선순위가 안정해져있음
		th2.start();

		// join() : 해당 쓰레드가 종료될 때까지 main 쓰레드가 기다림
		try {
			th1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 이렇게 하니깐 그냥 메인안에서 순서대로 실행됨. 아마 start가 동시성을 가지게돌려주는 메소드인듯
		th1.run();
		th1.run2();

		System.out.println("<< 메인 쓰레드 종료 >>");
	}
}
