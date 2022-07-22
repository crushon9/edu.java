package edu.java.access07;

public class MyNumber {
	// 멤버 변수
	private int number;
	//private 니깐 외부에서 넘버에 바로 접근할수없어서 메소드로 우회해서 접근한다
	public MyNumber() {
	}

	public MyNumber(int number) {
		this.number = number;
	}

	public int getnumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void addToNumber(int x) {
		number += x;
	}

	// 기능 : 현재 객체(this :MyNumber)의 number변수와 매개변수에 있는 number를 더한 후,
	// 현재 객체의 number에 저장
	// 리턴타입 : MyNumber
	// 함수이름 : add
	// 매개변수 : MyNumber number

	public MyNumber add(MyNumber number) { 
		this.number += number.number;
		return this;
	} // 아하 this라는건 MyNumber this 구나!!
	// 나중에 인스턴스화됐을때 이 메소드를 호출할 주소를담고있는 객체자기자신
	// MyNumber this(<-객체);
	// this = new MyNumber(); <-인스턴스
}
