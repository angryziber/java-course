package net.azib.java.lessons.threads;

/**
 * ThreadsDemo
 *
 * @author anton
 */
public class AtomicDemo {
	private static Object lock = new Object();
	static int i;
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r = new Runnable() {
			public void run() {
				for (int j = 0; j < 1000000; j++) {
					synchronized (lock) {
						i++;
					}
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
