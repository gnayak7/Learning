package edu.asu.msse.gnayak2.lowlevelproducerconsumer;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Processor processor = new Processor();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("Low level producer consumer problem");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Finished processing");
		
	}
}
