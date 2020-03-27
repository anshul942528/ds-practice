package com.anshul.mt;

public class Prac2 {

	public static void main(String[] args) throws InterruptedException {
		Thread2 tt = new Thread2();
		Thread t1 = new Thread(tt, "thread1");
		Thread t2 = new Thread(tt, "thread2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}

class Thread2 implements Runnable {
	int[] arr = { 1, 2, 3, 4, 5, 6 };
	int count = 0;
	Object lock = new Object();

	@Override
	public void run() {
		while (count < arr.length) {
			if ("thread1".equals(Thread.currentThread().getName())) {
				synchronized (lock) {
					while (count % 2 != 0) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (count < arr.length) {
						System.out.println(Thread.currentThread().getName() + " : " + arr[count++]);
					}
					lock.notifyAll();
				}
			} else {
				synchronized (lock) {
					while (count % 2 == 0) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (count < arr.length) {
						System.out.println(Thread.currentThread().getName() + " : " + arr[count++]);
					}
					lock.notifyAll();
				}
			}
		}
	}
}
