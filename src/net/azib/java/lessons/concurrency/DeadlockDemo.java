package net.azib.java.lessons.concurrency;

public class DeadlockDemo {
	private static final Object lock1 = new Object();
	private static final Object lock2 = new Object();

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				while (!Thread.interrupted()) {
					synchronized (lock1) {
						synchronized (lock2) {
							System.out.println("got 1 and 2");
						}
					}
				}
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				while (!Thread.interrupted()) {
					synchronized (lock2) {
						synchronized (lock1) {
							System.out.println("got 2 and 1");
						}
					}
				}
			}
		}.start();
	}
}
