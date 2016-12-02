package edu.asu.msse.gnayak2.callableandfuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		System.out.println("Callable and future");
		Future<?> future = threadPool.submit(new Callable<Void>(){
			public Void call() throws IOException{
				Random random = new Random();
				int duration = random.nextInt(4000);
				if(duration > 2000){
					throw new IOException("Sleeping too long");
				}
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				return null;
			}
		});
		
		threadPool.shutdown();
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException e){
			
		}catch(ExecutionException e) {
			IOException ex = (IOException) e.getCause();
			System.out.println(ex.getMessage());
		}
	}
}
