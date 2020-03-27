package com.anshul.misc;

public class Solution1 {
	public String dayOfTheWeek(int day, int month, int year) {
		String[] week = new String[] { "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday" };

		int[] daysDiffForMonths = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };// regular year
		
		int leapYears = getNumberOfLeapYear(year);

		int daysLapse = (year - 1971) * 365 + leapYears + daysDiffForMonths[month - 1] + day - 1;

		if (year % 4 == 0 && year != 2100 && month <= 2) {
			daysLapse--;
		}

		return week[daysLapse % 7];
	}
	
	public int getNumberOfLeapYear(int year) {
		int count = 0;
		
		for(int i = 1971; i < year; i++) {
			if((i % 400 == 0) || (i % 4 == 0 && i % 100 != 0)) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		System.out.println(sol.dayOfTheWeek(2, 1, 1971));
	}
}