package com.anshul.test;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		binarySearch(arr, 0, arr.length - 1, 2);
		recursiveBinarySearch(arr, 0, arr.length - 1, 2);
	}

	private static void recursiveBinarySearch(int[] arr, int start, int end, int number) {
		if(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] == number) {
				System.out.println("Element is present in the array : " + number);
				return;
			} else if(arr[mid] > number) {
				recursiveBinarySearch(arr, start, mid - 1, number);
				return;
			} else if (arr[mid] < number) {
				recursiveBinarySearch(arr, mid + 1, end, number);
				return;
			}
		}
		System.out.println("Element is not present in the array : " + number);
		
	}

	private static void binarySearch(int[] arr, int start, int end, int number) {

		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] == number) {
				System.out.println("Element is present in the array : " + number);
				return;
			} else if(arr[mid] > number) {
				end = mid - 1;
			} else if (arr[mid] < number) {
				start = mid + 1;
			}
		}
		System.out.println("Element is not present in the array : " + number);
	}
}
