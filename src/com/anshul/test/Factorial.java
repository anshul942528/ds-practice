package com.anshul.test;

public class Factorial {
	
	public static void main(String[] args) {
		
		System.out.println(factorial(5));
		System.out.println(factorial(3));
		
		System.out.println(factorialRecursive(5));
		System.out.println(factorialRecursive(3));
	}

	private static int factorialRecursive(int number) {
		if(number == 0 || number == 1)
			return 1;
		return number * factorialRecursive(number - 1);
	}

	private static int factorial(int number) {
		
		int fact = 1;
		
		for(int count = 1; count <= number; count++) {
			fact = fact * count;
		}
		return fact;
	}
	
	

}
