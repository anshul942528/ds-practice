package com.anshul.test;

public class LinearSearch {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		linearSearch(arr, 2);
		recursiveLinearSearch(arr, 6, 0);
	}

	private static void recursiveLinearSearch(int[] arr, int number, int index) {
		
		if(index < arr.length && arr[index] == number) {
			System.out.println("Element is present in the array : " + number);
			return;
		} else if(index < arr.length) {
			recursiveLinearSearch(arr, number, index + 1);
		} else {
			System.out.println("Element is not present in the array : " + number);
		}
	}

	private static void linearSearch(int[] arr, int number) {
		for(int ele : arr) {
			if(ele == number) {
				System.out.println("Element is present in the array : " + number);
				return;
			}
		}
		System.out.println("Element is not present in the array : " + number);
	}
}
