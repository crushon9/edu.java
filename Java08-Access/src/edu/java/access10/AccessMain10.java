package edu.java.access10;

public class AccessMain10 {

	public static void main(String[] args) {

		// PublicToilet 클래스의 인스턴스 생성
//		PublicToilet p1 = new PublicToilet(); 기본생성자가 private라 접근불가
		PublicToilet p1 = PublicToilet.getInstance(); // static이라 클래스로 호출
		p1.setLocation("p1캠핑장");
		System.out.println("p1주소 : " + p1);
		System.out.println(p1.getLocation());

		PublicToilet p2 = PublicToilet.getInstance();
		System.out.println("p2주소 : " + p2);
		System.out.println(p2.getLocation()); // p2에 값넣은적없는데 p1값이 나옴
		
		System.out.println();
		p2.setLocation("p2공연장");
		System.out.println(p2.getLocation());
		System.out.println(p1.getLocation()); // p2값을 변경했는데 p1값도 변함
		
		
	} // end main()

} // end AcceccMain10
