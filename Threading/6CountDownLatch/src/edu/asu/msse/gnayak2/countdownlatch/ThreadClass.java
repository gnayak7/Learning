package edu.asu.msse.gnayak2.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class ThreadClass implements Runnable {
	CountDownLatch latch;
	
	public ThreadClass(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed");
		latch.countDown();
	}
}
