package com.anshul.test;

import java.util.Arrays;

public class ArrayOne {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(arr));
		solution(arr);
		System.out.println(Arrays.toString(arr));

		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(arr1));
		recursiveSolution(arr1, 0, 0);
		System.out.println(Arrays.toString(arr1));
	}

	private static void solution(int[] arr) {
		int temp = arr[0];

		for (int count = 1; count < arr.length; count++) {
			temp = temp + arr[count];
			arr[count] = temp;
		}
	}

	private static void recursiveSolution(int[] arr, int sum, int index) {
		if(index < arr.length) {
			sum = sum + arr[index];
			arr[index] = sum;
			recursiveSolution(arr, sum, index + 1);
		}
	}
}
