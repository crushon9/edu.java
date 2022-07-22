package edu.java.string03;

public class StringMain03 {

	public static void main(String[] args) {
		// length() : 문자열의 길이를 리턴
		String str1 = "abc";
		String str2 = "Hello";
		System.out.println(str1.length());
		System.out.println(str2.length());

		System.out.println("----------");
		// equals(문자열) : String클래스의 equals()는 내용을 비교함
		// Object 클래스의 equals()메소드를 override 함
		System.out.println(str1.equals(str2));

		System.out.println("----------");
		String str3 = "hello";
		String str4 = "Hello";
		System.out.println(str3.equals(str4));
		System.out.println(str3.equalsIgnoreCase(str4));

		System.out.println("----------");
		// charAt() : 문자열 중에서 해당 인덱스의 문자 하나 리턴
		System.out.println(str3.charAt(1));

		System.out.println("----------");
		// indexOf() : 해당 문자 또는 문자열이 처음으로 등장하는 인덱스
		// lastIndexOf() : 문자 또는 문자열이 가장 마지막으로 등장하는 인덱스
		String str5 = "Hello, world!";
		System.out.println(str5.indexOf("lo"));
		System.out.println(str5.lastIndexOf("l"));

		System.out.println("----------");
		// startsWith() : 해당 문자열로 시작하는지 아닌지 확인
		// contains() : 해당 문자열을 포함하는지 아닌지 확인
		String str6 = "https://www.google.com";
		System.out.println(str6.startsWith("https://"));
		System.out.println(str6.contains("google"));

		System.out.println("----------");
		// split() : 문자열을 특정 기준으로 나눠서 배열로 리턴
		String str7 = "2022.07.22";
		String[] result = str7.split("\\."); // 특수기호 앞에는 \\
		for (String x : result) {
			System.out.println(x);
		}
		String str8 = "C:\\Program Files\\test folder";
		result = str8.split("\\\\"); // or 연산자 |
		for (String x : result) {
			String[] r = x.split(" ");
			for (String x2 : r) {
				System.out.println(x2);
			}
		}

		System.out.println("-----Quiz-----");
		String str9 = "2022-07-22 10:13:08";
		String[] quiz = str9.split("\\-| |\\:");
		if (quiz[1].charAt(2) < '7') {
			System.out.println("상반기");
		} else {
			System.out.println("하반기");
		}

	}

}
