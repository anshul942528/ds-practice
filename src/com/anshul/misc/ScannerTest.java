package com.anshul.misc;

import java.lang.invoke.MethodHandles;
import java.sql.Date;
import java.text.ParseException;

public class ScannerTest {
	
	public static void main(String[] args) throws ParseException {
		
		long millis = System.currentTimeMillis();
		java.sql.Date date = new Date(millis);
		System.out.println(date);
		//DateFormat dateFormat = news SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        /*String strDate = dateFormat.format(date);  
        System.out.println(strDate);*/
        //Date date1=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(strDate);  
        System.out.println(MethodHandles.lookup().lookupClass());
		/*Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] numArray = new int[size];
		
		for(int i = 0; i < size; i++) {
			numArray[i] = scan.nextInt();
		}
		
		System.out.print("Array is : " + Arrays.toString(numArray));
		
		scan.close();*/
	}
}
