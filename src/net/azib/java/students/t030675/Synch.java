package net.azib.java.students.t030675;

/**
 * Synch
 *
 * @author t030675
 */
public class Synch {
	
	private static int value;
	
	private static class Code implements Runnable{
		public void run() {
			for (int i = 0; i < 100000000; i++) {
				synchronized (this) {
					value++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Code code = new Code();
		Thread t1 = new Thread(code);
		Thread t2 = new Thread(code);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(value);
		
	}
}
