package com.anshul.mt;

import java.util.ArrayList;

public class Prac3 {

	public static void main(String[] args) throws InterruptedException {
		Thread4 tt = new Thread4();
		int num = 3;
		ArrayList<Thread> threadList = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			threadList.add(new Thread(tt, "" + i));
		}
		for (int i = 0; i < num; i++) {
			threadList.get(i).start();
		}
		for (int i = 0; i < num; i++) {
			threadList.get(i).join();
		}
		
		/*Thread t1 = new Thread(tt, "0");
		Thread t2 = new Thread(tt, "1");
		Thread t3 = new Thread(tt, "2");
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();*/
	}
}

class Thread4 implements Runnable {
	int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
	int count = 0;
	Object lock = new Object();

	@Override
	public void run() {
		while (count < arr.length) {
			synchronized (lock) {
				while (count % 3 != Integer.parseInt(Thread.currentThread().getName())) {
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