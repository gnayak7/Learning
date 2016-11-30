package edu.asu.msse.gnayak2.waitandnotify;

import java.util.Scanner;

public class Processor {
	public void producer() throws InterruptedException {
		synchronized(this){
			System.out.println("Processor in producing");
			wait();
			System.out.println("Finished producing");
		}
	}
	
	public void consumer() throws InterruptedException {
		System.out.println("Consumer is consumig");
		Thread.sleep(2000);
		Scanner scanner = new Scanner(System.in);
		synchronized(this) {
			System.out.println("Press return key to continue");
			scanner.nextLine();
			System.out.println("Enter key pressed. Notifiying the producer");
			notify();
			Thread.sleep(5000);
		}
	}

}
