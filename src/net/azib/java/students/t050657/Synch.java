package net.azib.java.students.t050657;

/**
 * Synch
 *
 * @author t050657
 */
public class Synch {
	
	private static int value; 
	
	private static class Code implements Runnable{
		public void run() {
			for(int i = 0; i<100000000; i++) {
				
				synchronized (Code.class) {
					value++;
				}
			}
		}
	} 
	
	public static void main(String[] args) throws InterruptedException{
		Code code = new Code();
		Thread t1 = new Thread(new Code());
		Thread t2 = new Thread(new Code());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(value);
	}

}
