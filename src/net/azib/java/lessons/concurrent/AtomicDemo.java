package net.azib.java.lessons.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicDemo
 *
 * @author anton
 */
public class AtomicDemo {
	static AtomicInteger i = new AtomicInteger();
	
	public static void main(String[] args) throws InterruptedException {
		Runnable bgCode = new Runnable() {
			public void run() {
				for (int j = 0; j < 1000000; j++) {
					i.incrementAndGet();
				}
			}
		};
		
		Thread t1 = new Thread(bgCode);
		t1.start();
		
		Thread t2 = new Thread(bgCode);
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(i.get());
	}
}
