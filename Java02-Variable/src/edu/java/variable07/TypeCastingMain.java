package edu.java.variable07;

public class TypeCastingMain {

	public static void main(String[] args) {
		System.out.println("형 변환(Type Casting)");
		
		byte num1 = 127;
		int num2 = num1; // int > byte 이므로 자동 형 변환
		System.out.println("num2 = " + num2);
		
		int num3 = 127;
		byte num4 = (byte) num3; 
		// **byte < int 이므로 저장된 사이즈로 강제 형 변환 (자동 형 변환 불가능)
		System.out.println("num4 = " + num4);
		
		int num5 = Byte.MAX_VALUE + 2;
		System.out.println("num5 = " + num5);

		byte num6 = (byte) num5; //오버플로우 
		// **1byte는 8bit니깐 2^8은 원래 256이어야하는데 왜 byte최대값은 127일까?
		// 1bit는 +-부호를 표기하기땜에 7bit(0~127)까지 표기되는 것
		// 1000 0001(127) 오버플로우-> 1000 0000(-128)
		System.out.println("num6 = " + num6);
		// 주의) num5에 저장된 값이 byte의 범위를 넘어가면
		// 형 변환은 가능하지만, 잘못된 값(쓰레기값)이 저장됨
		
		short num7 = 12345;
		// 12345는 리터럴(상수)이기 때문에 int 타입
		// 정수 리터럴 byte나 short에 저장할 때
		// 해당 타입에 저장할 수 있는 범위만 넘지 않으면 자동 형 변환을 해줌
		// int -> byte, int -> short
		
		// long 타입의 리터럴은 자동 현 변환을 하지 않음
//		int num8 = 100L;
		
		double num9 = 123; // int -> double 자동 형 변환
		System.out.println("num9 = " + num9);
		
		double num = 1.23;
		// 실수 타입 리터럴의 기본타입은 double (1.23 -> double 취급)
		int num10 = (int) 3.14; // double -> int 강제 형 변환 (소수점 사라짐)
		System.out.println("num10 = " + num10);
		
		char ch1 = 'A';
		System.out.println("ch1 = " + ch1); // 문자 자체 출력
		System.out.println("ch1 = " + (int) ch1); // 문자 유니코드값 출력
		
		// ch1을 사용하여 'B'라는 문자를 출력하세요.
		char ch2 = (char) (ch1 + 1);
		//**ch1 + 1울 하면 ch1이 1리터럴땜에 int로 형변환된거임
//		char ch2 = (char)ch1 + (char)1; 안되는 이유,,? 산술연산자를 사용하는순간 정수로 바뀜!!
		System.out.println(ch2);
		
	} // end main()

} // TypeCastingMain
