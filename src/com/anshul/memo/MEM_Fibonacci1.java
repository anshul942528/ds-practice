package com.anshul.memo;

public class MEM_Fibonacci1 {

	public static void main(String[] args) {
		int[] fib = new int[1 + 1];
		System.out.println(fibonacci(1, fib));
		fib = new int[2 + 1];
		System.out.println(fibonacci(2, fib));
		fib = new int[3 + 1];
		System.out.println(fibonacci(3, fib));
		fib = new int[4 + 1];
		System.out.println(fibonacci(4, fib));
		fib = new int[5 + 1];
		System.out.println(fibonacci(5, fib));
		fib = new int[6 + 1];
		System.out.println(fibonacci(6, fib));
		fib = new int[7 + 1];
		System.out.println(fibonacci(7, fib));
		fib = new int[8 + 1];
		System.out.println(fibonacci(8, fib));
	}

	public static int fibonacci(int number, int[] fib) {
		if (fib[number] != 0) {
			return fib[number];
		}

		if (number == 1 || number == 2) {
			fib[number] = 1;
		} else {
			fib[number] = fibonacci(number - 1, fib) + fibonacci(number - 2, fib);
		}

		return fib[number];
	}
}
