package net.azib.java.lessons.concurrency;

public class ConcurrencyFailureDemo implements Runnable {
	static int counter = 0;


	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			synchronized (this) {
				counter++;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();

		Runnable code = new ConcurrencyFailureDemo();

		Thread t1 = new Thread(code);
		t1.start();

		Thread t2 = new Thread(code);
		t2.start();

		t1.join();
		t2.join();
		System.out.println(counter);
		System.out.println(System.currentTimeMillis() - start);
	}
}
