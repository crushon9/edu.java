package edu.java.variable05;

// char : 문자 하나를 저장하는 데이터 타입. 2byte
// - 문자의 유니코드 값(0 또는 양의 정수)를 저장하는 타입
// - 0 ~ 65,535 (*2byte는 16bit이고 2^16은 65,536인데 0부터 시작이니깐 1뺀 65,535까지)
// (*C언어 ASCII코드는 7bit(0~127) 따라서 1byte char에 ASCII 1개가 담김)
// - 문자(character)는 작은 따옴표(' ')를 사용
// - 문자열(string)은 큰 따옴표(" ")를 사용
// - '한', '글', ' ' : 문자(character) 리터럴
// - "한글", "한국", "한", " " : 문자열(string) 리터럴

public class CharacterMain {
	
	public static void main(String[] args) {
		char ch1 = 'A';
		System.out.println("ch1 = " + ch1);
		
		char ch2 = 65;
		System.out.println("ch2 = " + ch2);
		
		char ch3 = '1';
		System.out.println("ch3 = " + ch3);
		
		char ch4 = 1;
		System.out.println("ch4 = " + ch4);
		
		char ch5 = '\n';
		System.out.println("ch5 = " + ch5);
		// println 은 개행이 포함된 출력이다
		
		boolean b = '가' < '나'; // '가' '나'는 실제로 숫자라서 비교가 가능하다
		System.out.println("b = " + b);
		
		System.out.println("문자열(String) 자료형");
		// C언어에서는 문자열을 char형 배열로 표현하지만
		// 자바에서는 문자열을 위한 String이라는 클래스를 별도로 제공 그래서 맨 앞 대문자인가봐
		//string(x) String(o)
		String str = "안녕하세요";
		System.out.println("str = " + str);
		
		
	} // end main()

} // end CharacterMain
