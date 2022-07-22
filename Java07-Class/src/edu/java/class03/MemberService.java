package edu.java.class03;

public class MemberService {

	public boolean login(String id, String password) {
		boolean x = false;
		if (id.equals("hong") && password.equals("12345")) {
			x = true;
		}
		return x;
	}

	public void logout(String id) {
		System.out.println("로그아웃 되었습니다");
	}
	
}
