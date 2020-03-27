package com.anshul.dp;

/* Here we assumed that fibonacci number starts from 0 */
public class DP_Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacci(1));
		System.out.println(fibonacci(2));
		System.out.println(fibonacci(3));
		System.out.println(fibonacci(4));
		System.out.println(fibonacci(5));
	}

	// Returns nth fibonacci number, where n is number passed as parameter
	public static int fibonacci(int number) {
		int[] fib = new int[number + 1];

		if (number == 1) {
			fib[1] = 0;
		} else if(number == 2){
			fib[0] = 1;
			fib[2] = 1;
		}else {
			fib[1] = 0;
			fib[2] = 1;

			for (int count = 3; count <= number; count++) {
				fib[count] = fib[count - 1] + fib[count - 2];
			}
		}
		return fib[number];
	}
}
