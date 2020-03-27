package com.anshul.test;

public class Sum {
	
	public static void main(String[] args) {
		System.out.println(sum(5));
		System.out.println(sum(3));
	}
	
	public static int sum(int number) {
		int sum = 0;
		
		for(int count = 1 ; count <= number; count++) {
			sum = sum + count;
		}
		return sum;
	}
}
