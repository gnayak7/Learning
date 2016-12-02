package edu.asu.msse.gnayak2.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		System.out.println("Semaphores program");
		for (int i=0; i<200;i++) {
			threadPool.submit(new Runnable() {
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}
		threadPool.shutdown();
		try {
			threadPool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished Semaphores program");
	}

}
