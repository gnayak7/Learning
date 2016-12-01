package edu.asu.msse.gnayak2.reentrantlocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Processor {
	int count = 0;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	public void increment() {
		for(int i=0;i<10000;i++) {
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("first thread");
		condition.await();
		try{
			increment();
		} finally {
			lock.unlock();
		}
		System.out.println("finishing first thread");
	}
	
	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press Return Key...");
		scanner.nextLine();
		condition.signal();
		System.out.println("second thread");
		try{
			increment();
		} finally {
			lock.unlock();
		}
		System.out.println("finishing second thread");
	}
	
	public void finalcall() {
		System.out.println("Count: " + count);
	}
}
