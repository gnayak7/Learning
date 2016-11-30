package edu.asu.msse.gnayak2.demo3;
public class Main {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(i);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(i);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		System.out.println("Thread Demo 3");
		thread1.start();
		thread2.start();
	}
}
