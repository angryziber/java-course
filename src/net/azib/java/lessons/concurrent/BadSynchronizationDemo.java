package net.azib.java.lessons.concurrent;

/**
 * BadSynchronizationDemo
 *
 * @author anton
 */
public class BadSynchronizationDemo {
	static int i;
	
	public static void main(String[] args) throws InterruptedException {
		Runnable bgCode = new Runnable() {
			public void run() {
				for (int j = 0; j < 1000000; j++) {
					i++;
				}
			}
		};
		
		Thread t1 = new Thread(bgCode);
		t1.start();
		
		Thread t2 = new Thread(bgCode);
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(i);
	}
}
