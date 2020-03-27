package com.anshul.mt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* Normal thread creation through Callable Interface */
/* Thread created through Callable is asynchronous in nature */

public class C_CallableThreadCreation {

	public static void main(String[] args) throws Exception {
		ExecutorService pool = Executors.newFixedThreadPool(1);
		ThreadThird third = new ThreadThird();
		Future<String> result = pool.submit(third);
		System.out.println("Main thread");
		pool.shutdownNow();
	    if (!pool.awaitTermination(100, TimeUnit.SECONDS)) {
	        System.out.println("Still waiting...");
	        
	    }
	    System.out.println("Exiting normally...");
	}
}

class ThreadThird implements Callable<String> {

	@Override
	public String call() {
		System.out.println("Callable thread");
		return "result";
	}
}
