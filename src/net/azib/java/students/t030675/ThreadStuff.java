package net.azib.java.students.t030675;

/**
 * ThreadStuff
 *
 * @author t030675
 */

public class ThreadStuff {

	private static class Code implements Runnable{
		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println(name + " started");
			try {
				Thread.sleep(2000);
				System.out.println(name + " stopped");
			}
			catch (InterruptedException e) {
				System.out.println(name + " interrupted");
			}
//			System.out.println(name + " " + (Thread.interrupted() ? "interrupted" : "stopped"));
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Code());
//		System.out.println(t.getState());
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		t.start();
//		System.out.println(t.getState());
//		t.join(1000);
//		t.interrupt();
//		System.out.println(t.getState());
		System.out.println("Main stopped");
	}
	
}
