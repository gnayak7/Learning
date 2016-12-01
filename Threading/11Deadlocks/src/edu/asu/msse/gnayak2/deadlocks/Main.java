package edu.asu.msse.gnayak2.deadlocks;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Processor processor = new Processor();
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				try {
					processor.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				try {
					processor.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("Reentrant thread program");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		processor.finalcall();
		
		System.out.println("Finised program");
	}
}
