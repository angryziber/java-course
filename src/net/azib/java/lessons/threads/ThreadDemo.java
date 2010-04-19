package net.azib.java.lessons.threads;

/**
 * ThreadDemo
 *
 * @author anton
 */
public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		Runnable code = new Runnable() {
			public void run() {
//				try {
//					Thread.sleep(2000);
//				}
//				catch (InterruptedException e) {
//				}
				int j = 0;
				for (int i = 0; i < 100000000; i++) {
					j += Math.random();
					if (Thread.interrupted()) {
						break;
					}
				}
				System.out.println(Thread.currentThread().getName() + j);
			}
		};
		Thread t = new Thread(code);
		t.setName("separateThread");
		t.start();
		Thread.sleep(5);
		t.interrupt();
		//code.run();
		System.out.println("main");
	}
}
