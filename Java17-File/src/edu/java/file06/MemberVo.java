package edu.java.file06;

import java.io.Serializable;

// 객체(Object) 타입을 파일에 쓰거나 파일에서 읽어오고 싶을때
// Serializable 인터페이스를 구현하는 클래스로 선언하면 됨
// 구현해야할 추상메소드는 없기때문에 implements Serializable 만 추가

public class MemberVo implements Serializable {

	private int no;
	private String id;
	private String pw;

	public MemberVo() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public MemberVo(int no, String id, String pw) {
		this.no = no;
		this.id = id;
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pw=" + pw + "]";
	}

}
