package com.anshul.mt;

import java.util.concurrent.Callable;

public class D_CallableThreadCreation {
	
	public static void main(String[] args) {
		ThreadFourth fourth = new ThreadFourth();
		
	}

}

class ThreadFourth implements Callable<String> {

	@Override
	public String call() {
		System.out.println("Callable thread");
		return "result";
	}
}