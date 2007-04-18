package net.azib.java.students.t030656;

/**
 * threadstuff
 *
 * @author t030656
 */
public class threadstuff {
	
	private static class Code implements Runnable{
		public void run(){
			String name = Thread.currentThread().getName();
			System.out.println(name + ": started");
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
			}
			System.out.println(name + ": closed");					
		}		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Code());
		t.setDaemon(true);
		t.start();
		t.join();
		System.out.println("Maine stopped");		
	}
}
