package test;

import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		int n = 3;
		int[] arr = { 1, 2, 3 };
		per(arr, 0, n, 3);

	}

	static void per(int[] arr, int depth, int n, int r) {
		if (depth == r) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			per(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

}
