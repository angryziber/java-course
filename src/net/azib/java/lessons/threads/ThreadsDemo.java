package net.azib.java.lessons.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadsDemo
 *
 * @author anton
 */
public class ThreadsDemo {
	static AtomicInteger i = new AtomicInteger();
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r = new Runnable() {
			public void run() {
				for (int j = 0; j < 1000000; j++) {
					i.incrementAndGet();
				}
			}
		};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start(); t2.start();
		
		t1.join(); t2.join();
		System.out.println(i);
	}
}
