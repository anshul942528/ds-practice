package com.anshul.misc;

public class Fibonacci1 {
	
	public static void main(String[] args) {
		System.out.println(fibonacci(1));
		System.out.println(fibonacci(2));
		System.out.println(fibonacci(3));
		System.out.println(fibonacci(4));
		System.out.println(fibonacci(5));
		printFibonacciSeries(10);
		System.out.println(fibonacciRecursive(1));
		System.out.println(fibonacciRecursive(2));
		System.out.println(fibonacciRecursive(3));
		System.out.println(fibonacciRecursive(4));
		System.out.println(fibonacciRecursive(10));
	}
	
	// Returns nth fibonacci number, where n is number passed as parameter
	public static int fibonacci(int number) {
		int f0 = 0;
		int f1 = 1;
		int temp = 0;
		
		if(number == 1) {
			return 0;
		} else if(number == 2) {
			return 1;
		} else {
			for(int count = 2; count < number; count++) {
				temp = f0 + f1;
				f0 = f1;
				f1 = temp;
			}
			return f1;
		}
	}
	
	// Prints first n numbers of fibonacci series, where n is number passed as parameter
	public static void printFibonacciSeries(int number) {
		int f0 = 0;
		int f1 = 1;
		int temp = 0;
		
		if(number == 1) {
			System.out.println(0);
		} 
		if(number == 2) {
			System.out.println(0);
			System.out.println(1);
		} else {
			System.out.println(0);
			System.out.println(1);
			for(int count = 2; count < number; count++) {
				temp = f0 + f1;
				f0 = f1;
				f1 = temp;
				System.out.println(temp);
			}
		}
	}
	
	// Returns nth fibonacci number, where n is number passed as parameter(Recursive solution)
	public static int fibonacciRecursive(int number) {
		
		if(number == 1 || number == 2) {
			return number - 1;
		} else {
			return fibonacci(number - 1) + fibonacci(number - 2);
		}
	}
}
