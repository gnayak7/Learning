package edu.asu.msse.gnayak2.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	private static Random random = new Random();
	
	public static void producer() {
		while(true){
			try {
				queue.put(random.nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void consumer() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (random.nextInt(10) == 0) {
				try {
					Integer value = queue.take();
					System.out.println("The value is : " + value);
					System.out.println("The size is: " + queue.size());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				producer();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				consumer();
			}
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
