package edu.asu.msse.gnayak2.demo2;

public class Thread2 implements Runnable {
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
}
