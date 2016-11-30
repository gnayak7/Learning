package edu.asu.msse.gnayak2.demo1;
public class Main {
	public static void main(String[] args) {
		ThreadDemo threadDemo1 = new ThreadDemo();
		threadDemo1.start();
		System.out.println("Thread Demo 1");
		ThreadDemo threadDemo2 = new ThreadDemo();
		threadDemo2.start();
	}
}
