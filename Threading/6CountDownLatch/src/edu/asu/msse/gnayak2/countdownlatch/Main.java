package edu.asu.msse.gnayak2.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		System.out.println("CountDownLatch program");
		for(int i=0;i<3;i++) {
			executor.submit(new ThreadClass(latch));
		}
		
		System.out.println("Submitted the jobs");
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed all the tasks");
	}

}
