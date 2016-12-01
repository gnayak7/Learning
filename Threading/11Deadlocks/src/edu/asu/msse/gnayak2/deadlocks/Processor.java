package edu.asu.msse.gnayak2.deadlocks;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Processor {
	
	private Account ac1 = new Account();
	private Account ac2 = new Account();
	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();
	
	private void acquireLock(Lock lock1, Lock lock2) throws InterruptedException {
		while(true) {
			// acquired lock
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			try {
				gotFirstLock = lock1.tryLock();
				gotSecondLock = lock2.tryLock();
			} finally {
				if (gotFirstLock && gotSecondLock){
					return ;
				} 
				if (gotFirstLock) {
					lock1.unlock();
				} 
				if (gotSecondLock){
					lock2.unlock();
				}
			}
			// acquire lock
			Thread.sleep(1);
		}
	}
	
	public void firstThread() throws InterruptedException {
		Random random = new Random();
//		System.out.println("first thread started");
		for(int i=0; i<1000;i++) {
			acquireLock(lock1,lock2);
			
			try {
				Account.transfer(ac1, ac2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
//				System.out.println("first thread ended");
			}
		}
	}
	
	public void secondThread() throws InterruptedException {
		Random random = new Random();
//		System.out.println("second thread started");
		for(int i=0; i<1000;i++) {
			acquireLock(lock2,lock1);
//			System.out.println("secondThread() acquired lock2");
//			System.out.println("secondThread() acquired lock1");
			try {
				Account.transfer(ac2, ac1, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
//				System.out.println("second thread ended");
			}
		}
	}
	
	public void finalcall() {
		System.out.println(ac1.getBalance());
		System.out.println(ac2.getBalance());
		System.out.println(ac1.getBalance() + ac2.getBalance());
	}
}
