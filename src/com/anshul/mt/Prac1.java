package com.anshul.mt;

public class Prac1 {

	public static void main(String[] args) throws InterruptedException {
		Thread1 tt = new Thread1();
		Thread t1 = new Thread(tt, "thread1");
		Thread t2 = new Thread(tt, "thread2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}

class Thread1 implements Runnable {
	PrintEvenOdd peo = new PrintEvenOdd();

	@Override
	public void run() {
		if ("thread1".equals(Thread.currentThread().getName())) {
			peo.printEven();
		} else {
			peo.printOdd();
		}
	}
}

class PrintEvenOdd {
	int[] arr = { 1, 2, 3, 4, 5, 6 };
	Object lock = new Object();
	int count = 0;

	public void printEven() {
		while (count < arr.length) {
			synchronized (lock) {
				while(count % 2 != 0) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(count < arr.length) {
					System.out.println(Thread.currentThread().getName() + " : " + arr[count++]);
				}
				lock.notifyAll();
			}
		}
	}

	public void printOdd() {
		while (count < arr.length) {
			synchronized (lock) {
				while(count % 2 == 0) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(count < arr.length) {
					System.out.println(Thread.currentThread().getName() + " : " + arr[count++]);
				}
				lock.notifyAll();
			}
		}
	}
}
