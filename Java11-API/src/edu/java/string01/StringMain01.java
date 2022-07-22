package edu.java.string01;

// API (Application Programming Interface)
// 프로그램언어나 운영체제가 제공하는 기능을 사용할 수 있게 만든 인터페이스
// 예를들어 System.out.println();
public class StringMain01 {

	public static void main(String[] args) {
		String str1 = "안녕하세요"; // 문자열 상수 : 기본타입
		System.out.println(str1); // str1 은 str1.toString() 과 같음

		String str2 = new String("안녕하세요"); // 참조타입. 인스턴스생성
		System.out.println(str2);

		if (str1 == str2) { // == != 주소값 비교
			System.out.println("같은참조");
		} else {
			System.out.println("다른참조");
		}
		
		if (str1.equals(str2)) { // 내용 비교
			System.out.println("같은내용");
		} else {
			System.out.println("다른내용");
		}
		
		

	}

}
