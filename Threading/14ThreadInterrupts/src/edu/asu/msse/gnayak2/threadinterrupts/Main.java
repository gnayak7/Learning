package edu.asu.msse.gnayak2.threadinterrupts;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Thread Interrupt Program");
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		Future<?> future = threadPool.submit(new Callable<Void>() {
			public Void call() {
				Random random = new Random();
				
				for(int i = 0;i<1E8;i++) {
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("Thread is interrupted");
						break;
					}
					Math.sin(random.nextDouble());
				}
				return null;
			}
		});
		
		threadPool.shutdown();
		
		Thread.sleep(500);
		threadPool.shutdownNow();
//		future.cancel(true);
		threadPool.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println("Finished Thread Interrupt Program");

	}

}
