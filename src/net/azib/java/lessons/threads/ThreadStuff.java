package net.azib.java.lessons.threads;

/**
 * ThreadStuff
 *
 * @author anton
 */
public class ThreadStuff {
	
	private static class Code implements Runnable {

		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println(name + " started");
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
			}
			System.out.println(name + " " + (Thread.interrupted() ? "interrupted" : "stopped"));
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Code());
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		//t.join(1000);
		//t.interrupt();
		System.out.println("Main stopped");
	}
}
