package com.anshul.test;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = {55, 44, 33, 22, 11};
		int[] arr1 = {55, 44, 33, 22, 11};
		
		System.out.println("Array elements before sorting : " + Arrays.toString(arr));
		bubbleSort(arr,  arr.length);
		System.out.println("Array elements after sorting : " + Arrays.toString(arr));
		
		System.out.println("Array elements before recursive-sorting : " + Arrays.toString(arr1));
		bubbleSortRecursive(arr1, arr1.length);
		System.out.println("Array elements after recursive-sorting : " + Arrays.toString(arr1));
	}

	private static void bubbleSortRecursive(int[] arr, int num) {
		if(num <= 0)
			return;
		
		for(int count_1 = 0; count_1 < num - 1; count_1++) {
			if(arr[count_1] > arr[count_1 + 1]) {
				swap(arr, count_1, count_1 + 1);
			}
		}
		
		bubbleSortRecursive(arr, num - 1);
	}

	private static void bubbleSort(int[] arr, int num) {
		for(int count_1 = 0; count_1 < num - 1; count_1++) {
			for(int count_2 = 0; count_2 < num - count_1 - 1; count_2++) {
				if(arr[count_2] > arr[count_2 + 1]) {
					swap(arr, count_2, count_2+1);
				}
			}
		}
	}

	private static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

}
