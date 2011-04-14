package net.azib.java.lessons.concurrency;

public class DaemonDemo {
	public static void main(String[] args) {
		Thread another = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
				System.out.println("another thread finished");
			}
		};
		another.setDaemon(true);
		another.start();

		System.out.println("main thread finished");
	}
}
