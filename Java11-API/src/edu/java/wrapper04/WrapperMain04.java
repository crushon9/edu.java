package edu.java.wrapper04;

public class WrapperMain04 {

	public static void main(String[] args) {
		String str = "2022년 7월 22일 17:41:43";
		String[] result = str.split("[^0-9]+");
		int sum = 0;
		for (String x : result) {
			System.out.println(x);
			sum += Integer.parseInt(x);
		}
		System.out.println(sum);

	}
}
