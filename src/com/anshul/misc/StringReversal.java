package com.anshul.misc;

public class StringReversal {
	
	public static void main(String[] args) {
		String str = "Anshul";
		long startTime = System.currentTimeMillis();
		System.out.println(firstStringReversal(str));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + "ms");
		
		startTime = System.currentTimeMillis();
		System.out.println(secondStringReversal(str));
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + "ms");
		
		startTime = System.currentTimeMillis();
		System.out.println(thirdStringReversal(str));
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + "ms");
	}

	private static String firstStringReversal(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	
	private static String secondStringReversal(String str) {
		StringBuilder builder = new StringBuilder();
		for(int i = str.length() - 1; i >= 0; i--) {
			builder.append(str.charAt(i));
		}
		return builder.toString();
	}
	
	private static String thirdStringReversal(String str) {
		char[] charArr = new char[str.length()];
		int j = 0;
		for(int i = str.length() - 1; i >= 0; i--) {
			charArr[j] = str.charAt(i);
			j++;
		}
		return new String(charArr);
	}
}
