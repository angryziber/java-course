package net.azib.java.lessons.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * NotSynchronizingDemo
 *
 * @author anton
 */
public class AtomicDemo implements Runnable {
	static AtomicInteger i = new AtomicInteger();
	
	public static void main(String[] args) throws InterruptedException {
		long t = System.currentTimeMillis();
		AtomicDemo code = new AtomicDemo();
		Thread t1 = new Thread(code);
		Thread t2 = new Thread(code);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println(i);
		System.out.println((System.currentTimeMillis()-t) + "ms");
	}

	public void run() {		
		System.out.println("start " + Thread.currentThread().getName());
		for (int j = 0; j < 100000000; j++) {
			i.incrementAndGet();
		}
	}
}
