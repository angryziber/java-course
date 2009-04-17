package net.azib.java.lessons.concurrent;

/**
 * DefaultThreadsDemo
 * 
 * Enables jconsole
 * -Dcom.sun.management.jmxremote
 *
 * @author anton
 */
public class ThreadsDemo {
	
	public static void main(String[] args) throws InterruptedException {
		Runnable bgCode = new Runnable() {
			public void run() {
				try {
					Thread.sleep(100);
				}
				catch (InterruptedException e) {
				}
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		Thread t = new Thread(bgCode);
		t.start();
		
		System.out.println(Thread.currentThread().getName());
	}
}
