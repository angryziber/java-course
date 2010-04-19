package net.azib.java.lessons.threads;

/**
 * DeadLockDemo
 *
 * @author anton
 */
public class DeadLockDemo {
	static Object lock1 = new Object(), lock2 = new Object();
	
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				synchronized (lock1) {
					quietSleep();
					synchronized (lock2) {
						quietSleep();
					}
				}
			}
		}.start();
		new Thread() {
			public void run() {
				synchronized (lock2) {
					synchronized (lock1) {
						quietSleep();
					}
				}
			}
		}.start();
	}
	
	private static void quietSleep() {
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
		}
	}
}
