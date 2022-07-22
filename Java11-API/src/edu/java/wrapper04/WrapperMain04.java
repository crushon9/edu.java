package edu.java.wrapper04;

public class WrapperMain04 {

	public static void main(String[] args) {
		String str = "2022년 7월 22일 17:41:43";
		String[] result = str.split("[^0-9]+");
		for (String x : result) {
			System.out.println(x);
		}
		int sum = 0;
		for (int i = 0; i < result.length; i++) {
			sum = sum + Integer.parseInt(result[i]);
		}
		System.out.println(sum);

	}
}
