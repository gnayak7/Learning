package edu.asu.msse.gnayak2.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		System.out.println("Thread pool example");
		for(int i=0;i<5;i++) {
			executor.submit(new ThreadClass(i));
		}
		executor.shutdown();
		
		System.out.println("Submitted all tasks to the thread");
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All tasks completed");

	}

}
