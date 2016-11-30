package edu.asu.msse.gnayak2.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadLocks {
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();	
	Object lock1 = new Object();
	Object lock2 = new Object();
	Random random = new Random();
	
	public void task1() {
		synchronized(lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));	
		}
	}
	
	public void task2() {
		synchronized(lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
	
	public void process() {
		for(int i=0;i<1000;i++) {
			task1();
			task2();
		}
	}
	
	public void main() {
		long startTime = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		System.out.println(list1.size());
		System.out.println(list2.size());
	}
}
