package edu.asu.msse.gnayak2.semaphores;

import java.util.concurrent.Semaphore;

public class Connection {
	private static Connection instance = new Connection();
	private int connections = 0;
	private Semaphore semaphore = new Semaphore(10);
	
	private Connection() {
		
	}
	
	public static Connection getInstance() {
		return instance;
	}
	
	public void connect() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			doConnect();
		}finally {
			semaphore.release();
		}
	}
	
	public void doConnect() {
		
		synchronized(this) {
			connections++;
			System.out.println("connections: " + connections);
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized(this) {
			connections--;
			System.out.println("connections: " + connections);
		}
		
	}
}
