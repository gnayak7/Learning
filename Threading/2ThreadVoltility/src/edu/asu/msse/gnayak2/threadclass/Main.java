package edu.asu.msse.gnayak2.threadclass;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ThreadClass thread1 = new ThreadClass();
		System.out.println("Thread Volatility");
		thread1.start();
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		// this method wont be called till enter key is pressed.
		// the main thread waits for user to press return key. 
		thread1.shutdown();

	}

}
