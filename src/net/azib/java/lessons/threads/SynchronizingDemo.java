package net.azib.java.lessons.threads;

/**
 * NotSynchronizingDemo
 *
 * @author anton
 */
public class SynchronizingDemo implements Runnable {
	static int i;
	
	public static void main(String[] args) throws InterruptedException {
		long t = System.currentTimeMillis();
		SynchronizingDemo code = new SynchronizingDemo();
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
			synchronized (this) {
				i++;
			}
		}
		System.out.println("end " + Thread.currentThread().getName());
	}
}
