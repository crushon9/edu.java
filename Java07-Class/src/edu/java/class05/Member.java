package edu.java.class05;

public class Member {

	public boolean login(String id, String password) {
		if (id.equals("test") && password.equals("1234")) { // equals 는 데이터를 비교
//		if (id == "test" && password == "1234") { id,password는 주소값이 전송되어있음 id == "test" : id주소값과 "test"주소값을 비교
			// scanner를 통해 입력받은 test는 힙영역에 있으니깐 주소값이 다름
			return true;
		} else {
			return false;
		}
	}
}
