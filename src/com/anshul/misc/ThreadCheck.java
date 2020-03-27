package com.anshul.misc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCheck {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		CountDownLatch latch = new CountDownLatch(10);
		for(int count = 0; count < 100; count++) {
			Task task = new Task(latch, count);
			threadPool.execute(task);
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadPool.shutdown();
	}
}

class Task implements Runnable {
	CountDownLatch latch;
	int count;
	
	public Task(CountDownLatch latch, int count) {
		this.latch = latch;
		this.count = count;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count + " Hello");
		latch.countDown();
	}
}