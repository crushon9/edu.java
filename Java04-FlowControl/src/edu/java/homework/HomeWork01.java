package edu.java.homework;

public class HomeWork01 {

	public static void main(String[] args) {
		System.out.println("===== Quiz 1 ======");
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
		System.out.println();

		System.out.println("===== Quiz 2 ======");
		while (true) {
			// random() : 0 <= x < 1 사이의 난수 발생
			double rX = Math.random();
			double rY = Math.random();
			int x = (int) (6 * rX + 1);
			int y = (int) (6 * rY + 1);
			System.out.println("(" + x + " , " + y + ")");

			if (x + y == 5) {
				break;
			}
		}

		System.out.println("===== Quiz 3 ======");
		int n = 1;
		int sum = 0;
		while (true) {
			if (n % 2 == 1) {
				sum += n;
			} else {
				sum -= n;
			}
			if (sum > 100) {
				System.out.println("n = " + n);
				System.out.println("sum = " + sum);
				break;
			}
			n++;
		}

		System.out.println("===== Quiz 4 ======");
		int max = 5;
		for (int i = 0; i < 2 * max; i++) {

			if (i < max) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
			} else {
				for (int y = 2 * max - i; y < max; y++) {
					System.out.print(" ");
				}
				for (int z = 2 * max - i; z > 0; z--) {
					System.out.print("*");
				}
			}

			System.out.println();
		}

	}// end main()

}// end HomeWork01