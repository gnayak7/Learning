package edu.asu.msse.gnayak2.lowlevelproducerconsumer;

import java.util.LinkedList;
import java.util.Random;

public class Processor {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private int LIMIT = 10;
	private Object lock = new Object();
	Random random = new Random();
	
	public void producer() throws InterruptedException{
		
		while(true) {
			synchronized(lock) {
				System.out.println("Producing ...");
				while(list.size() == LIMIT) {
					System.out.println("producer limit reached... lock is waiting");
					lock.wait();
				}
				list.add(random.nextInt(100));
				System.out.println("finished producing");
				lock.notify();
			}
		}
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized(lock) {
				System.out.println("consuming ...");
				while(list.size() == 0) {
					System.out.println("consumer limit reached... lock is waiting");
					lock.wait();
				}
				int value = list.removeFirst();
				System.out.println("The value is: " + value + " The size is: " + list.size());
				System.out.println("finished consuming");
				lock.notify();
			}
			Thread.sleep(random.nextInt(1000));
		}
		
	}
}
