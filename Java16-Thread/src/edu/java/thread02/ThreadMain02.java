package edu.java.thread02;

// 자바는 다중 상속을 허용하지 않기 때문에
// 다른클래스를 이미 상속받고있는 경우에는 Thread클래스를 상속받을 수 없음
// Runnable 인터페이스를 구현하여 Thread를 생성할 수 있는 방법을 제공

// 자바에서 쓰레드를 생성하고 사용하는 방법2 :
//1. Runnable 인터페이스를 구현하는 클래스 정의(Implements Runnable)
//2. 정의한 클래스에서 run() 메소드를 override
//3. 정의한 클래스의 인스턴스 생성
//4. Runnable 인스턴스를 매개변수로해서 Thread 인스턴스 생성
//5. Thread 인스턴스에서 start() 메소드 호출 -> run() 자동호출
////////////////////////////////////////////////////////////

//1. Runnable 인터페이스를 구현하는 클래스 정의(Implements Runnable)
class MyRunnable implements Runnable {
	private String msg;

	public MyRunnable(String msg) {
		super();
		this.msg = msg;
	}

//2. 정의한 클래스에서 run() 메소드를 override
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " : " + msg);
			try {
				Thread.sleep(100); // 상속을 받은게 아니므로 Thread.를 통해 접근
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
} // end MyRunnable

public class ThreadMain02 {

	public static void main(String[] args) {
		// 3. Runnable인터페이스를 구현하는 클래스(MyRunnable)의 인스턴스 생성
		MyRunnable r1 = new MyRunnable("r1");
		Runnable r2 = new MyRunnable("r2"); // 다형성

		// 4. Runnable 인스턴스를 매개변수로해서 Thread 인스턴스 생성
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);

		// 5. Thread 인스턴스에서 start() 메소드 호출 -> run() 자동호출
		th1.start();
		th2.start();

		System.out.println("<< 메인 쓰레드 종료 >>");
	}

}
