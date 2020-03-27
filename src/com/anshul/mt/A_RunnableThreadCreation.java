package com.anshul.mt;

/* Normal thread creation through Runnable Interface */
/* Thread created through Runnable is asynchronous in nature */

public class A_RunnableThreadCreation {
	
	public static void main(String[] args) throws InterruptedException {
		ThreadFirst tf = new ThreadFirst();
		Thread t1 = new Thread(tf);
		t1.start();
		System.out.println("Main thread");
	}
}

class ThreadFirst implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable thread");
	}
}