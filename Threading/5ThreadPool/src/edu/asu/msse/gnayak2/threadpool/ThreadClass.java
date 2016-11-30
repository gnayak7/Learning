package edu.asu.msse.gnayak2.threadpool;

public class ThreadClass implements Runnable {
	private int id;
	public ThreadClass(int id) {
		this.id = id;
	}
	
	public void run() {
		System.out.println("Started task " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed task " + id);
	}
}
