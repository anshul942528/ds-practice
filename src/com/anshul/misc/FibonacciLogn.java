package com.anshul.misc;

/* _   _ n    _					_
 *| 1 1 |  = |	fn+1	fn		 |
 *|_1 0_|    |_	fn		fn-1	_|
 * 
 * */

public class FibonacciLogn {

	public static void main(String[] args) {
		System.out.println(fibonacci(1));
		System.out.println(fibonacci(2));
		System.out.println(fibonacci(3));
		System.out.println(fibonacci(4));
		System.out.println(fibonacci(5));
		System.out.println(fibonacci(6));
	}

	private static int fibonacci(int number) {
		int[][] arr = { {1, 1}, {1, 0} };
		
		if(number <= 0) {
			return -1;
		}else if(number == 1 || number == 2){
			return 1;
		}
		
		powerFib(arr, number - 1);
		return arr[0][0];
	}

	private static void powerFib(int[][] arr, int num) {
		int[][] temp = {{1, 1}, {1, 0}};
		
		if(num == 0 || num == 1) {
			return;
		}
		powerFib(arr, num/2);
		multiply(arr, arr);
		
		if(num % 2 != 0) {
			multiply(arr, temp);
		}
	}

	private static void multiply(int[][] arr, int[][] temp) {
		int x00 = arr[0][0] * temp[0][0] + arr[0][1] * temp[1][0];
		int x01 = arr[0][0] * temp[0][1] + arr[0][1] * temp[1][1];
		int x10 = arr[1][0] * temp[0][0] + arr[1][1] * temp[1][0];
		int x11 = arr[1][0] * temp[0][1] + arr[1][1] * temp[1][1];

		arr[0][0] = x00;
		arr[0][1] = x01;
		arr[1][0] = x10;
		arr[1][1] = x11;
	}
}
