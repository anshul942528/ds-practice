package com.anshul.mt;

/* Normal thread creation through Thread Class */
/* Thread created through Thread is asynchronous in nature */

public class B_ThreadThreadCreation {
	
	public static void main(String[] args) {
		ThreadSecond ts = new ThreadSecond();
		ts.start();
		System.out.println("Main thread");
	}
}

class ThreadSecond extends Thread {
	
	@Override
	public void run() {
		System.out.println("Thread thread");
	}
}