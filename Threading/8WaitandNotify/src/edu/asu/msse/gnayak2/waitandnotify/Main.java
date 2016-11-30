package edu.asu.msse.gnayak2.waitandnotify;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Processor processor = new Processor();
		
		System.out.println("Wait and Notify in Threads");
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				try {
					processor.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				try {
					processor.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Completed Processing");
	}

}
