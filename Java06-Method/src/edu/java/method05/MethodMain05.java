package edu.java.method05;

// 메소드 overloading
// 1. 매개변수의 개수가 다르거나
// 2. 매개변수의 타입이 다른 경우 (순서가 다른 경우)
// 같은 이름으로 정의 할 수 있음
// (주의) 메소드의 리턴타입만 다른 경우는 같은 이름으로 메소드를 정의할 수 없음 -> 호출할때 구분안되니깐
public class MethodMain05 {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("문자열");
		System.out.println(1);
		System.out.println(1.0);
		System.out.println(true);

		sayHello();
		sayHello(1);
		sayHello("청미");
		sayHello("청미", 1);
		sayHello(1, "청미");
//		System.out.println(sayHello()); 리턴값이 없는 메소드이니 이렇게 넣으면 아무것도 출력되지 않는다

	} // end main()

	public static void sayHello() {
		System.out.println("안녕하세요.");
	} // end sayHello()

	public static void sayHello(int x) {
		System.out.println("안녕하세요 int");
	} // end sayHello()

	public static void sayHello(String name) {
		System.out.println("제 이름은 " + name + "입니다.");
	} // end sayHello()

	public static void sayHello(String name, int age) {
		System.out.println("안녕하세요 name int");
	} // end sayHello()

	public static void sayHello(int age, String name) {
		System.out.println("안녕하세요 int name");
	} // end sayHello()

} // end MethodMain05
