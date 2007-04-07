package net.azib.java.students.t050657.Class;

/**
 * ThreadStuff
 *
 * @author t050657
 */
public class ThreadStuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Code());
		t.start();
		t.join(1000);
		t.interrupt();
		System.out.println("Main Stopped");
	}
	

	private static class Code implements Runnable{
		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println(name + "Started");
			try {
				Thread.sleep(2000);
				//System.out.println(name + "stopped");
			}catch(InterruptedException e) {
				System.out.println(name + "interrupted");
			}
			System.out.println(name + " " + (Thread.interrupted() ?  "interrupted" : "not interrupted"));
		}
	}

}
