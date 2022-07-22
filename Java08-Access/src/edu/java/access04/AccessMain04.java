package edu.java.access04;

public class AccessMain04 {

	public static void main(String[] args) {
		// 객체 생성 및 데이터 저장 방식1
		Contact c1 = new Contact(0, "닥터스트레인지", "000-0000-0000", "strange@mail.com");
		System.out.println(c1.toString());
		// 번호를 변경
		c1.setPhone("000-0000-0001");
		System.out.println(c1.toString());

		// 객체 생성 및 데이터 저장 방식2
		Contact c2 = new Contact();
		c2.setNo(1);
		c2.setName("토르");
		c2.setPhone("111-1111-1111");
		c2.setEmail("thor@mail.com");
		System.out.println(c2.toString());

		// 3명의 연락처 정보를 배열로 묶음
		Contact[] contacts = new Contact[3];
		// 닥터스트레인지의 정보를 contacts[0]에 저장
		contacts[0] = c1;
		contacts[1] = c2;
		contacts[2] = new Contact(2, "죠르디", "222-2222-2222", "jordi@mail.com");
		for (Contact x : contacts) {
			System.out.println(x.toString());
		}

	}

}
