package edu.java.lambda03;

@FunctionalInterface
interface Test1 {
	public abstract void printMax(int x, int y);
}

@FunctionalInterface
interface Test2 {
	public abstract int findMax(int x, int y);
}

public class LambdaMain03 {
	public static void main(String[] args) {
		// 람다표현식을 이용하여 구현
		Test1 t1 = (x, y) -> {
			int max;
			if (x > y) {
				max = x;
			} else {
				max = y;
			}
			System.out.println("최대값 : " + max);
		};
		t1.printMax(100, 101);

		Test2 t2 = (x, y) -> (x > y) ? x : y;
		System.out.println("최대값 : " + t2.findMax(10, 5));

	}
}
