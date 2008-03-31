package net.azib.java.lessons.threads;

/**
 * DeadlockDemo
 *
 * @author anton
 */
public class DeadlockDemo {
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r1 = new Runnable() {
			public void run() {
				synchronized (lock1) {
					try {
						Thread.sleep(1000);
					}
					catch (InterruptedException e) {
					}
					synchronized (lock2) {
						System.out.println("Hello from " + Thread.currentThread().getName());
					}
				}
			}
		};
		Runnable r2 = new Runnable() {
			public void run() {
				synchronized (lock2) {
					synchronized (lock1) {
						System.out.println("Hello from " + Thread.currentThread().getName());
						try {
							Thread.sleep(1000);
						}
						catch (InterruptedException e) {
						}
					}
				}
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start(); 
		t2.start();
		
		t1.join(); 
		t2.join();
		System.out.println("Finish!");
	}
}
