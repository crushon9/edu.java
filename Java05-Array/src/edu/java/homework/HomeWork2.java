package edu.java.homework;

public class HomeWork2 {

	public static void main(String[] args) {
		System.out.println("== 과제1 ===========================");
		int[] arr1 = { 6, 8, 4, 2, 5 };
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr1.length; i++) {
			if (max < arr1[i]) {
				max = arr1[i];
			}
		}
		System.out.println("최대값 = " + max);

		
		System.out.println("== 과제2 ===========================");
		int sum = 0;
		for (int i = 0; i < arr1.length; i++) {
			sum += arr1[i];
		}
		double avg = (double) (sum / arr1.length);
		System.out.println("원소 합 = " + sum);
		System.out.println("원소 평균 = " + avg);

		
		System.out.println("== 과제3 ===========================");
		int[] f = new int[20];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		for (int x : f) {
			System.out.print(x + " ");
		}

		
		System.out.println("\n== 과제4 ===========================");
		int[][] array = { { 95, 86 }, { 44, 22, 96 }, { 78, 83, 93, 87, 88 } };
		sum = 0;
		int count = 0;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
				count++;
				if (max < array[i][j]) {
					max = array[i][j];
				}
			}
		}
		avg = (double) (sum / count);
		System.out.println("원소 합 = " + sum);
		System.out.println("원소 평균 = " + avg);
		System.out.println("최대값 = " + max);
		
	}
}
